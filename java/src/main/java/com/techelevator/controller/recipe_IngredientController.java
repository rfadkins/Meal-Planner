package com.techelevator.controller;

import com.techelevator.business.*;
import com.techelevator.model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//@PreAuthorize("isAuthenticated()")
public class recipe_IngredientController{

//This controller handles join tables related to ingredients in recipes

    //Uncomment when RecipeIngredientService is implemented
    UserService userService;
    RecipeIngredientService recipeIngredientService;

    @Autowired
    public void RecipeIngredientController(UserService userService, RecipeIngredientService recipeIngredientService) {
        this.userService = userService;
        this.recipeIngredientService = recipeIngredientService;
    }




    /*--------------------
    addIngredientToRecipe()
    POST
    Ingredient/recipe/{ingredient_id}/{recipe_id}
<<<<<<< Updated upstream
     --------------------*/

    @PostMapping ("/ingredient/recipe/{ingredientId}/{recipeId}")
    public void addIngredientToRecipe(@PathVariable("ingredientId") Long ingredientId, @PathVariable("recipeId") Long recipeId) {
        recipeIngredientService.addIngredientToRecipe(recipeId,ingredientId);
    }


    /*--------------------
    removeIngredientFromRecipe()
    DELETE
    ingredient/recipe/{ingredient_id}/{recipe_id}
    --------------------*/

    @DeleteMapping("/ingredient/recipe/{ingredientId}/{recipeId}")
    public void removeIngredientFromRecipe(@PathVariable("ingredientId") Long ingredientId, @PathVariable("recipeId") Long recipeId) {
       recipeIngredientService.removeIngredientFromRecipe(recipeId,ingredientId);
    }
}