package com.techelevator.controller;

import com.techelevator.business.*;
import com.techelevator.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class TestController {

    @Autowired
    UserOwnershipService userOwnershipService;

    @Autowired
    IngredientService ingredientService;

    @Autowired
    MealService mealService;

    @Autowired
    MealRecipeService mealRecipeService;


    @Autowired
    RecipeIngredientService recipeIngredientService;


//    @GetMapping("/user/")
//    public List<User> getAllUsers() {
//        return userOwnershipService.listAllUsers();
//    }
//
//    @GetMapping("/test/ingredient")
//    public List<Ingredient> listIngredients() {
//        return ingredientService.getAllIngredients();
//    }
//
//    @PostMapping("/recipe/user/{recipeId}/{userId}")
//    public void addRecipeToUser (@PathVariable("recipeId") Long recipeId, @PathVariable("userId") Long userId) {
//        userOwnershipService.addRecipeToUser(recipeId, userId);
//    }
//
//    @GetMapping("/recipe/user/{userId}")
//    public void listUserRecipes (@PathVariable("userId") Long userId) {
//        userOwnershipService.listUserRecipes(userId);
//    }
//
//    @PostMapping ("/ingredient/recipe/{ingredientId}/{recipeId}")
//    public void addIngredientToRecipe(@RequestBody Ingredient ingredient, @PathVariable("ingredientId") Long ingredientId, @PathVariable("recipeId") Long recipeId) {
//        recipeIngredientService.addIngredientToRecipe(recipeId,ingredientId);
//    }
//
//


}