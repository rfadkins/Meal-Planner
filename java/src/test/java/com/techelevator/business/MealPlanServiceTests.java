package com.techelevator.business;


import com.techelevator.model.MealPlan;
import com.techelevator.repository.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MealPlanServiceTests {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;
    @Autowired
    IngredientRepository ingredientRepository;
    @Autowired
    IngredientService ingredientService;
    @Autowired
    RecipeRepository recipeRepository;
    @Autowired
    RecipeService recipeService;
    @Autowired
    MealService mealService;
    @Autowired
    MealRepository mealRepository;
    @Autowired
    MealPlanService mealPlanService;
    @Autowired
    MealPlanRepository mealPlanRepository;

//
//    @Test
//    public void mealPlanIdIsNotNull() {
//        MealPlan mealPlan = MealPlan.builder()
//                .mealPlanName("TestMealPlanName")
//                .build();
//
//        mealPlanRepository.save(mealPlan);
//
//        mealPlan = mealPlanService.displayMealPlan(mealPlan.getMealPlanId());
//
//        Assertions.assertThat(mealPlan.getMealPlanId()).isNotNull();
//    }

}
