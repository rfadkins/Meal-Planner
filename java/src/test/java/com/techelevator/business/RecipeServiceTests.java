package com.techelevator.business;

import com.techelevator.model.*;
import com.techelevator.repository.IngredientRepository;
//import com.techelevator.repository.RecipeIngredientRepository;
import com.techelevator.repository.RecipeRepository;
import com.techelevator.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;
import java.util.Set;

//@DataJpaTest
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RecipeServiceTests {

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
//    @Autowired
//    RecipeIngredientRepository recipeIngredientRepository;
    @Autowired
    RecipeIngredientService recipeIngredientService;

//    @Test
//    public void recipeIdIsNotNull() {
//        Recipe recipe = Recipe.builder()
//                .recipeName("TestRecipeName")
//                .recipeInstructions("TestRecipeInstructions")
//                .category("TestCategory")
//                .build();
//
//        recipe = recipeService.createRecipe(recipe.getRecipeName(),
//                                            recipe.getRecipeInstructions(),
//                                            recipe.getCategory());
//
//        Assertions.assertThat(recipe.getRecipeId()).isNotNull();
//    }



//    @Test
//    public void recipeIngredientIdIsNotNull() {
//        Recipe recipe = Recipe.builder()
//                .recipeName("TestRecipeName")
//                .recipeInstructions("TestRecipeInstructions")
//                .category("TestCategory")
//                .build();
//        Ingredient ingredient = Ingredient.builder()
//                .ingredientName("TestIngredient")
//                .ingredientCategory("TestCategory")
//                .build();
//
//
//        recipe = recipeService.createRecipe(recipe.getRecipeName(), recipe.getRecipeInstructions(), recipe.getCategory());
//        recipeRepository.saveAndFlush(recipe);
//
//        ingredient = ingredientService.createIngredient(ingredient.getIngredientName(), ingredient.getIngredientCategory());
//        ingredientRepository.saveAndFlush(ingredient);
//
//        RecipeIngredient recipeIngredient = RecipeIngredient.builder()
//                .recipe(recipe)
//                .ingredient(ingredient)
//                .build();
//
//        recipeIngredient = recipeIngredientService.createRecipeIngredient(recipeIngredient.getRecipe().getRecipeId(), recipeIngredient.getIngredient().getIngredientId());
//        recipeIngredientRepository.saveAndFlush(recipeIngredient);
//
//        Set<RecipeIngredient> testRecipeIngredients = recipe.getIngredientsInRecipe();
//        testRecipeIngredients.add(recipeIngredient);
//
//
//
//
//        Assertions.assertThat(testRecipeIngredients.contains(recipeIngredient)).isTrue();
//    }

//    @Test
//    public void userRecipeIdIsNotNull() {
//        User user = User.builder()
//                .username("TestUsername")
//                .password("TestPassword")
//                .build();
//        Recipe recipe = Recipe.builder()
//                .recipeName("TestRecipeName")
//                .recipeInstructions("TestRecipeInstructions")
//                .category("TestCategory")
//                .build();
//
//        user = userService.create(user.getUsername(), user.getPassword());
//        recipe = recipeService.createRecipe(recipe.getRecipeName(), recipe.getRecipeInstructions(), recipe.getCategory());
//
//        Map<Long, Recipe> testUserRecipes = recipeService.addRecipeToUserRecipes(user.getUserId(), recipe.getRecipeId());
//
//        Assertions.assertThat(testUserRecipes.get(user.getUserId())).isNotNull();
//    }

//    @Test
//    public void mealRecipeIdIsNotNull() {
//        Meal meal = Meal.builder()
//                .mealName("TestMealName")
//                .build();
//        Recipe recipe = Recipe.builder()
//                .recipeName("TestRecipeName")
//                .recipeInstructions("TestRecipeInstructions")
//                .category("TestCategory")
//                .build();
//        recipe = recipeService.createRecipe(recipe.getRecipeName(), recipe.getRecipeInstructions(), recipe.getCategory());
//        meal = mealService.createMeal(meal.getMealName());
//        Set<Recipe> testMealRecipes = mealService.
////        Map<Long, Recipe> testMealRecipes = recipeService.addRecipeToMeal(meal.getMealId(), recipe.getRecipeId());
//
//        Assertions.assertThat(testMealRecipes.get(meal.getMealId())).isNotNull();
//    }
//
//    @Test
//    public void deletedRecipeIsNull() {
//        Recipe recipe = Recipe.builder()
//                .recipeName("TestRecipeName")
//                .recipeInstructions("TestRecipeInstructions")
//                .category("TestCategory")
//                .build();
//
//        recipe = recipeService.createRecipe(recipe.getRecipeName(), recipe.getRecipeInstructions(), recipe.getCategory());
//        recipeService.deleteRecipe(recipe.getRecipeId());
//
//        Recipe testRecipe = recipeRepository.findByRecipeId(recipe.getRecipeId());
//
//        Assertions.assertThat(testRecipe).isNull();
//    }

}


/*
This is the method that has count in recipe-ingredient:

    @Test
    public void recipeIngredientIdIsNotNull() {
        Recipe recipe = Recipe.builder()
                .recipeName("TestRecipeName")
                .recipeInstructions("TestRecipeInstructions")
                .category("TestCategory")
                .build();
        Ingredient ingredient = Ingredient.builder()
                .ingredientName("TestIngredient")
                .ingredientCategory("TestCategory")
                .build();


        recipe = recipeService.createRecipe(recipe.getRecipeName(), recipe.getRecipeInstructions(), recipe.getCategory());
        recipeRepository.saveAndFlush(recipe);

        ingredient = ingredientService.createIngredient(ingredient.getIngredientName(), ingredient.getIngredientCategory());
        ingredientRepository.saveAndFlush(ingredient);

        RecipeIngredient recipeIngredient = RecipeIngredient.builder()
                .recipe(recipe)
                .ingredient(ingredient)
                .count("one")
                .build();

        recipeIngredient = recipeIngredientService.createRecipeIngredient(recipeIngredient.getRecipe().getRecipeId(), recipeIngredient.getIngredient().getIngredientId(), "one");
        recipeIngredientRepository.saveAndFlush(recipeIngredient);

        Set<RecipeIngredient> testRecipeIngredients = recipe.getIngredientsInRecipe();
        testRecipeIngredients.add(recipeIngredient);




        Assertions.assertThat(testRecipeIngredients.contains(recipeIngredient)).isTrue();
    }
 */