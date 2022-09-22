package com.techelevator.controller;

import com.techelevator.business.*;
import com.techelevator.model.Ingredient;
import com.techelevator.model.IngredientsInRecipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
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
    public IngredientsInRecipe addIngredientToRecipe(@PathVariable("ingredientId") Long ingredientId, @PathVariable("recipeId")  Long recipeId, @RequestParam String ingredientQuantity, @RequestParam String ingredientMeasurement) {
        return this.recipeIngredientService.addIngredientToRecipe(recipeId,ingredientId,  ingredientQuantity, ingredientMeasurement);
    }

    @GetMapping("/ingredient/recipe/{recipeId}")
    public List<IngredientsInRecipe> listIngredientsInRecipe(@PathVariable("recipeId") Long recipeId) {
        return recipeIngredientService.listIngredientsInRecipe(recipeId);
    }
//
//
//    /*--------------------
//    removeIngredientFromRecipe()
//    DELETE
//    ingredient/recipe/{ingredient_id}/{recipe_id}
//    --------------------*/
//
//    @DeleteMapping("/ingredient/recipe/{ingredientId}/{recipeId}")
//    public void removeIngredientFromRecipe(@PathVariable("ingredientId") Long ingredientId, @PathVariable("recipeId") Long recipeId) {
//       recipeIngredientService.removeIngredientFromRecipe(recipeId,ingredientId);
//    }


}