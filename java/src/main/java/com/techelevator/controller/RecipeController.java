package com.techelevator.controller;


import com.techelevator.business.RecipeService;
import com.techelevator.business.UserService;
import com.techelevator.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
//@RequestMapping("/recipe")
@PreAuthorize("isAuthenticated()")
public class RecipeController{
//This controller handles the recipe table

    UserService userService;
    @Autowired
    RecipeService recipeService;

    @Autowired
    public RecipeController(UserService userService, RecipeService recipeService) {
        this.userService = userService;
        this.recipeService = recipeService;
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/recipe/")
    public Recipe createRecipe(@RequestBody Recipe recipe) {
        return recipeService.createRecipe(recipe.getRecipeName(), recipe.getRecipeInstructions(), recipe.getCategory());
    }


    @GetMapping("/recipe/{recipeId}")
    public Recipe displayRecipe(@PathVariable("recipeId") Long recipeId) {
        return recipeService.getRecipeById(recipeId);
    }


    @GetMapping("/recipe/")
    public List<Recipe> displayAllRecipes() {
        return recipeService.displayAllRecipes();
    }


    @GetMapping("/recipe/category/{category}")
    @ResponseBody
    public List<Recipe> displayAllRecipesByCategory(@PathVariable String category) {
        return recipeService.getRecipesByCategory(category);
    }


    @PutMapping("/recipe/{recipeId}")
    public void editRecipe(@PathVariable("recipeId") Long recipeId,
                            @RequestBody Recipe recipe) {
        recipeService.editRecipe(recipeId, recipe.getRecipeName(), recipe.getRecipeInstructions(), recipe.getCategory());
    }


    @DeleteMapping("/recipe/{recipeId}")
    public void deleteRecipe(@PathVariable("recipeId") Long recipeId) {
        recipeService.deleteRecipe(recipeId);
    }

}