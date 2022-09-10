package com.techelevator.controller;

import com.techelevator.business.IngredientService;
import com.techelevator.business.MealService;
import com.techelevator.business.UserService;
import com.techelevator.datatransfer.IngredientDTO;
import com.techelevator.model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//@PreAuthorize("isAuthenticated()")
public class meal_RecipeController{
    //This controller handles join tables related to recipes in meals

    //Uncomment when MealRecipeService is implemented.
/*    UserService userService;
    MealRecipeService mealRecipeService;

    @Autowired
    public MealRecipeController(UserService userService, MealRecipeService mealRecipeService) {
        this.userService = userService;
        this.mealRecipeService = mealRecipeService;
    }*/

    /*--------------------
    addRecipeToMeal()
    POST
    recipe/meal/{recipe_id}/{meal_id}
    --------------------*/
    @PostMapping ("/recipe/meal/{recipeId}/{mealId}")
    public String addRecipeToMeal(@PathVariable("recipeId") Long recipeId, @PathVariable("mealId") Long mealId) {
        return("Post Received for "+ recipeId + "/" +mealId + " though addrecipetomeal is not implemented yet.");
    }


    /*--------------------
    removeRecipeFromMeal()
    DELETE
    recipe/meal/{recipe_id}/{meal_id}
    --------------------*/
    @DeleteMapping("/recipe/meal/{recipeId}/{mealId}")
    public String removeRecipeFromMeal(@PathVariable("recipeId") Long recipeId, @PathVariable("mealId") Long mealId) {
        return("Delete Received for "+ recipeId + "/" +mealId + " though removerecipefrommeal is not implemented yet.");
    }

}