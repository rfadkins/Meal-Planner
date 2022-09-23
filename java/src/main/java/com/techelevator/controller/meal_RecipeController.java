package com.techelevator.controller;

import com.techelevator.business.MealRecipeService;
import com.techelevator.business.UserService;
import com.techelevator.model.MealsInMealPlan;
import com.techelevator.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class meal_RecipeController{

    private UserService userService;
    private MealRecipeService mealRecipeService;

    @Autowired
    public void MealRecipeController(UserService userService, MealRecipeService mealRecipeService) {
        this.userService = userService;
        this.mealRecipeService = mealRecipeService;
    }


    @PostMapping ("/recipe/meal/{recipeId}/{mealId}")
    public void addRecipeToMeal(@PathVariable("recipeId") Long recipeId,
                                @PathVariable("mealId") Long mealId) {
        mealRecipeService.addRecipeToMeal(recipeId, mealId);
    }


    @GetMapping ("/recipe/meal/{mealId}")
    public List<Recipe> getRecipesInMeal(@PathVariable("mealId") Long mealId) {
        return this.mealRecipeService.getRecipesInMeal(mealId);
    }


    @DeleteMapping("/recipe/meal/{recipeId}/{mealId}")
    public void removeRecipeFromMeal(@PathVariable("recipesInMealId") Long recipesInMealId) {
        mealRecipeService.deleteRecipeInMeal(recipesInMealId);
    }

}