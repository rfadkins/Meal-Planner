package com.techelevator.controller;

import com.techelevator.business.MealRecipeService;
import com.techelevator.business.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//@PreAuthorize("isAuthenticated()")
public class meal_RecipeController{
    //This controller handles join tables related to recipes in meals

    //Uncomment when MealRecipeService is implemented.
    UserService userService;
    MealRecipeService mealRecipeService;

    @Autowired
    public void MealRecipeController(UserService userService, MealRecipeService mealRecipeService) {
        this.userService = userService;
        this.mealRecipeService = mealRecipeService;
    }

    /*--------------------
    addRecipeToMeal()
    POST
    recipe/meal/{recipe_id}/{meal_id}
    --------------------*/
    @PostMapping ("/recipe/meal/{recipeId}/{mealId}")
    public void addRecipeToMeal(@PathVariable("recipeId") Long recipeId, @PathVariable("mealId") Long mealId) {
      mealRecipeService.addRecipeToMeal(mealId,recipeId);
    }


    /*--------------------
    removeRecipeFromMeal()
    DELETE
    recipe/meal/{recipe_id}/{meal_id}
    --------------------*/
    @DeleteMapping("/recipe/meal/{recipeId}/{mealId}")
    public void removeRecipeFromMeal(@PathVariable("recipeId") Long recipeId, @PathVariable("mealId") Long mealId) {
        mealRecipeService.removeRecipeFromMeal(mealId,recipeId);
    }

}