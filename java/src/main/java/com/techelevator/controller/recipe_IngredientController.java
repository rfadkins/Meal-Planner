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
@PreAuthorize("isAuthenticated()")
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



    @PostMapping ("/ingredient/recipe/{ingredientId}/{recipeId}")
    public IngredientsInRecipe addIngredientToRecipe(@PathVariable("ingredientId") Long ingredientId,
                                                    @PathVariable("recipeId")  Long recipeId,
                                                    @RequestParam String ingredientQuantity,
                                                    @RequestParam String ingredientMeasurement) {
        return this.recipeIngredientService.addIngredientToRecipe(recipeId,ingredientId,  ingredientQuantity, ingredientMeasurement);
    }

    @GetMapping("/ingredient/recipe/{recipeId}")
    public List<IngredientsInRecipe> listIngredientsInRecipe(@PathVariable("recipeId") Long recipeId) {
        return this.recipeIngredientService.listIngredientsInRecipe(recipeId);
    }

    @DeleteMapping("/ingredient/recipe/{ingredientId}/{recipeId}")
    public String removeIngredientFromRecipe(@PathVariable("ingredientsInRecipeId") Long ingredientsInRecipeId) {
        return this.recipeIngredientService.deleteIngredientFromRecipe(ingredientsInRecipeId);
    }


}