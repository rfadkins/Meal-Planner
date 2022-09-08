package com.techelevator.controller;

import com.techelevator.business.IngredientService;
import com.techelevator.business.RecipeService;
import com.techelevator.business.UserService;
import com.techelevator.model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class recipe_IngredientController{
    RecipeService recipeService;
//This controller handles join tables related to ingredients in recipes

    /*--------------------
    addIngredientToRecipe()
    POST
    Ingredient/recipe/{ingredient_id}/{recipe_id}

     */
    @PostMapping ("/")
    public void addIngredientToRecipe(@PathVariable("ingredientId") Long ingredientId, @PathVariable("recipeId") Long recipeId) {
        recipeService.addIngredientToRecipe(ingredientId, recipeId);
    }


    /*--------------------
    removeIngredientFromRecipe()
    DELETE
    ingredient/recipe/{ingredient_id}/{recipe_id}
    --------------------*/

}