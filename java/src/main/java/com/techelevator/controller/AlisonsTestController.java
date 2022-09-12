package com.techelevator.controller;

import com.techelevator.datatransfer.IngredientDTO;
import com.techelevator.datatransfer.MealPlannerDTO;
import com.techelevator.datatransfer.RecipeDTO;
import com.techelevator.model.*;
import com.techelevator.business.*;
import com.techelevator.datatransfer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    /*
Status 200 = OK
 */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/alisontest/recipe")
    public void createRecipe(@RequestBody RecipeDTO recipeDTO) {
        Recipe recipe = mapper.mapRecipeDTOToEntity(recipeDTO);
        recipeService.createRecipe(recipe.getRecipeName(), recipe.getRecipeInstructions(), recipe.getCategory());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "alisontest/recipe/ingredient")
    public void addIngredientToRecipe(@RequestBody List<MealPlannerDTO> masterDTO) {
        RecipeDTO recipeDTO = masterDTO.get(0).getRecipeDTO();
        IngredientDTO ingredientDTO = masterDTO.get(0).getIngredientDTO();



//        List<Map<String, String>> ingredientsInRecipeDTO = masterDTO.get("MealPlannerDTO");
//        Map<String, String> recipeParts = ingredientsInRecipeDTO.get(0);
//        Map<String, String> ingredientParts = ingredientsInRecipeDTO.get(1);
//        Long recipeId = Long.parseLong(recipeParts.get("recipeId"));

//        Recipe recipe = mapper.mapRecipeDTOToEntity(ingredientsInRecipeDTO);
//
//        MealPlannerDTO ingredientDTO = mealPlannerDTO.get(1);
//        Ingredient ingredient = mapper.mapIngredientDTOToEntity(ingredientDTO);
        recipeService.addIngredientToRecipe(recipeDTO.getRecipeId(), ingredientDTO.getIngredientId());
 //       recipeService.addIngredientToRecipe(Long.parseLong(recipeParts.get("recipeId")), Long.parseLong(recipeParts.get("ingredientId")));
    }
    /*
    Status 200 = OK
     */
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/alisontest/recipe/{recipeId}")
    public Recipe getRecipeById(@PathVariable("recipeId") Long recipeId) {
        Recipe recipe = recipeService.displayRecipe(recipeId);
        return recipe;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/alisontest/ingredient/{ingredientId}")
    public Ingredient getIngredientById(@PathVariable("ingredientId") Long ingredientId) {
        Ingredient ingredient = ingredientService.getIngredientById(ingredientId);
        return ingredient;
    }

}
//    public void addIngredientToRecipe(@PathVariable("ingredientId") Long ingredientId, @PathVariable("recipeId") Long recipeId) {
//        recipeService.addIngredientToRecipe(ingredientId, recipeId);
//
//    }
//}
