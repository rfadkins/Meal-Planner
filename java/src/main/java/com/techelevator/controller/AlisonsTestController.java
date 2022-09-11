package com.techelevator.controller;

import com.techelevator.datatransfer.IngredientDTO;
import com.techelevator.datatransfer.RecipeDTO;
import com.techelevator.model.*;
import com.techelevator.business.*;
import com.techelevator.datatransfer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class AlisonsTestController {

    UserService userService;
    @Autowired
    IngredientService ingredientService;
    @Autowired
    RecipeService recipeService;
    @Autowired
    MealService mealService;
    @Autowired
    MealPlanService mealPlanService;
    @Autowired
    Mapper mapper;

    /*
    Status 200 = OK
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/alisontest/ingredient")
    public void createIngredient(@RequestBody IngredientDTO ingredientDTO) {
        Ingredient ingredient = mapper.mapIngredientDTOToEntity(ingredientDTO);
        this.ingredientService = ingredientService;
        this.ingredientService.createIngredient(ingredient.getIngredientName(), ingredient.getIngredientCategory());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/alisontest/recipe")
    public void createRecipe(@RequestBody RecipeDTO recipeDTO) {
        Recipe recipe = mapper.mapRecipeDTOToEntity(recipeDTO);
        recipeService.createRecipe(recipe.getRecipeName(), recipe.getRecipeInstructions(), recipe.getCategory());


    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "alisontest/recipe/{recipe_id}/ingredient/{ingredient_id}")
    public void addIngredientToRecipe(@PathVariable("ingredientId") Long ingredientId, @PathVariable("recipeId") Long recipeId) {
        recipeService.addIngredientToRecipe(ingredientId, recipeId);

    }
}
