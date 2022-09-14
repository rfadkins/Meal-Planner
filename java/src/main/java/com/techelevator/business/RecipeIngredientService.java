package com.techelevator.business;

import com.techelevator.exceptions.IngredientNotFoundException;
import com.techelevator.exceptions.RecipeNotFoundException;
import com.techelevator.model.Ingredient;
import com.techelevator.model.Recipe;
import com.techelevator.repository.*;
import com.techelevator.util.BasicLogger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public class RecipeIngredientService {

    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private IngredientRepository ingredientRepository;

// TODO test addIngToRec  remIngFromRec

    public Recipe addIngredientToRecipe(Long recipeId, Long ingredientId) {
        Set<Ingredient> ingredientsInRecipe = new HashSet<>();
        Ingredient ingredient = ingredientRepository.findByIngredientId(ingredientId);
        Recipe recipe = recipeRepository.findByRecipeId(recipeId);
        try {
            if (recipe == null) {
                throw new RecipeNotFoundException();
            } else if (ingredient == null) {
                throw new IngredientNotFoundException();
            } else {
                ingredientsInRecipe = recipe.getIngredientsInRecipe();
                ingredientsInRecipe.add(ingredient);
                recipe.setIngredientsInRecipe(ingredientsInRecipe);

                recipeRepository.saveAndFlush(recipe);
            }
        } catch (Exception e) {
            BasicLogger.log(e.getMessage());
        }
        return recipe;
    }

    public Recipe removeIngredientFromRecipe(Long recipeId, Long ingredientId) {
        Set<Ingredient> ingredientsInRecipe = new HashSet<>();
        Ingredient ingredient = ingredientRepository.findByIngredientId(ingredientId);
        Recipe recipe = recipeRepository.findByRecipeId(recipeId);
        try {
            if (recipe == null) {
                throw new RecipeNotFoundException();
            } else if (ingredient == null) {
                throw new IngredientNotFoundException();
            } else {
                ingredientsInRecipe = recipe.getIngredientsInRecipe();
                ingredientsInRecipe.remove(ingredient);
                recipe.setIngredientsInRecipe(ingredientsInRecipe);

                recipeRepository.saveAndFlush(recipe);
            }
        } catch (Exception e) {
            BasicLogger.log(e.getMessage());
        }
        return recipe;
    }





}
