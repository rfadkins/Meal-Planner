package com.techelevator.business;

import com.techelevator.model.Ingredient;
import com.techelevator.model.User;
import com.techelevator.repository.IngredientRepository;
import com.techelevator.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.transaction.Transactional;
import java.util.Map;



@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class IngredientServiceTests {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;
    @Autowired
    IngredientRepository ingredientRepository;
    @Autowired
    IngredientService ingredientService;

    @Test
    public void ingredientIdIsNotNull() {
        Ingredient ingredient = Ingredient.builder()
                .ingredientName("TestIngredient")
                .ingredientCategory("TestCategory")
                .build();
        ingredient = ingredientService.createIngredient(ingredient.getIngredientName(), ingredient.getIngredientCategory());

        Assertions.assertThat(ingredient.getIngredientId()).isNotNull();
    }

    //fails -- unsure how to test
    @Test
    public void deletedIngredientIdShouldBeNull() throws Exception {
        Ingredient ingredient = Ingredient.builder()
                .ingredientName("TestIngredient")
                .ingredientCategory("TestCategory")
                .build();
        ingredient = ingredientService.createIngredient(ingredient.getIngredientName(), ingredient.getIngredientCategory());
        //ingredientService.deleteIngredient(ingredient.getIngredientId());

        ingredientRepository.deleteById(ingredient.getIngredientId());

        Assertions.assertThat(ingredient).isNull();
    }

    @Test
    public void userPantryUserIdAndIngredientIdAreNotNull() {
        User user = User.builder()
                .username("TestUsername")
                .password("TestPassword")
                .build();
        Ingredient ingredient = Ingredient.builder()
                .ingredientName("TestIngredient")
                .ingredientCategory("TestCategory")
                .build();
        user = userService.create(user.getUsername(), user.getPassword());

        ingredient = ingredientService.createIngredient(ingredient.getIngredientName(), ingredient.getIngredientCategory());

        Map<Long, Ingredient> testUserPantry = ingredientService.addIngredientToUserPantry(user.getUserId(), ingredient.getIngredientId());

        Assertions.assertThat(testUserPantry.get(user.getUserId())).isNotNull();
        }

    @Test
    public void deletedIngredientShouldBeRemovedFromUserPantry() {
        User user = User.builder()
                .username("TestUsername")
                .password("TestPassword")
                .build();
        Ingredient ingredient = Ingredient.builder()
                .ingredientName("TestIngredient")
                .ingredientCategory("TestCategory")
                .build();
        user = userService.create(user.getUsername(), user.getPassword());

        ingredient = ingredientService.createIngredient(ingredient.getIngredientName(), ingredient.getIngredientCategory());

        Map<Long, Ingredient> testUserPantry = ingredientService.addIngredientToUserPantry(user.getUserId(), ingredient.getIngredientId());
        long testId = ingredient.getIngredientId();
        ingredientService.deleteIngredient(ingredient.getIngredientId());

        Assertions.assertThat(testUserPantry.get(testId)).isNull();
    }


}

