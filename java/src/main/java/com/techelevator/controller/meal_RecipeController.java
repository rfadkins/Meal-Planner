package com.techelevator.controller;

import com.techelevator.business.MealRecipeService;
import com.techelevator.business.UserService;
import com.techelevator.exceptions.MealNotFoundException;
import com.techelevator.exceptions.RecipeNotFoundException;
import com.techelevator.model.Meal;
import com.techelevator.model.MealsInMealPlan;
import com.techelevator.model.Recipe;
import com.techelevator.model.RecipesInMeal;
import com.techelevator.repository.MealRepository;
import com.techelevator.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    MealRepository mealRepository;
    @Autowired
    RecipeRepository recipeRepository;


    @Autowired
    public void MealRecipeController(UserService userService, MealRecipeService mealRecipeService) {
        this.userService = userService;
        this.mealRecipeService = mealRecipeService;
    }


    @ResponseStatus(HttpStatus.OK)
    @PostMapping ("/recipe/meal/{recipeId}/{mealId}")
    public ResponseEntity<RecipesInMeal> addRecipeToMeal(@PathVariable("recipeId") Long recipeId,
                                                        @PathVariable("mealId") Long mealId) {
        try {
            Meal meal = mealRepository.findByMealId(mealId);
            Recipe recipe = recipeRepository.findByRecipeId(recipeId);
            if (meal == null) {
                throw new MealNotFoundException();
            } else if (recipe == null) {
                throw new RecipeNotFoundException();
            } else {
                return ResponseEntity.ok(mealRecipeService.addRecipeToMeal(recipeId, mealId));
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping ("/recipe/meal/{mealId}")
    public ResponseEntity<List<Recipe>> getRecipesInMeal(@PathVariable("mealId") Long mealId) {
        return ResponseEntity.ok(mealRecipeService.getRecipesInMeal(mealId));
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/recipe/meal/{recipeId}/{mealId}")
    public void removeRecipeFromMeal(@PathVariable("recipesInMealId") Long recipesInMealId) {
        mealRecipeService.deleteRecipeInMeal(recipesInMealId);
    }

}