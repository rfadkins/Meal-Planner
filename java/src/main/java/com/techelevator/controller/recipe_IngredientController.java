package com.techelevator.controller;

import com.techelevator.business.IngredientService;
import com.techelevator.business.MealService;
import com.techelevator.business.RecipeService;
import com.techelevator.business.UserService;
import com.techelevator.model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//@PreAuthorize("isAuthenticated()")
public class recipe_IngredientController{

//This controller handles join tables related to ingredients in recipes

    //Uncomment when RecipeIngredientService is implemented
 /*   UserService userService;
    RecipeIngredientService recipeIngredientService;

    @Autowired
    public RecipeIngredientController(UserService userService, RecipeIngredientService recipeIngredientService) {
        this.userService = userService;
        this.recipeIngredientService = recipeIngredientService;
    }*/




    /*--------------------
    addIngredientToRecipe()
    POST
    Ingredient/recipe/{ingredient_id}/{recipe_id}
     --------------------*/

    @PostMapping ("/ingredient/recipe/{ingredientId}/{recipeId}")
    public String addIngredientToRecipe(@PathVariable("ingredientId") Long ingredientId, @PathVariable("recipeId") Long recipeId) {
        return("Post Received for "+ ingredientId + "/" +recipeId + " though addingredienttorecipe is not implemented yet.");
    }


    /*--------------------
    removeIngredientFromRecipe()
    DELETE
    ingredient/recipe/{ingredient_id}/{recipe_id}
    --------------------*/

    @DeleteMapping("/ingredient/recipe/{ingredientId}/{recipeId}")
    public String removeIngredientFromRecipe(@PathVariable("ingredientId") Long ingredientId, @PathVariable("recipeId") Long recipeId) {
        return("Delete Received for "+ ingredientId + "/" +recipeId + " though removeingredientfromrtecipe is not implemented yet.");
    }
}