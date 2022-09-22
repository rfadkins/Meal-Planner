package com.techelevator.business;

import com.techelevator.exceptions.IngredientNotFoundException;
import com.techelevator.exceptions.RecipeNotFoundException;
import com.techelevator.model.Ingredient;
import com.techelevator.model.IngredientsInRecipe;
import com.techelevator.model.Recipe;
//import com.techelevator.model.RecipeIngredient;
import com.techelevator.repository.*;
import com.techelevator.util.BasicLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RecipeIngredientService {

    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private IngredientRepository ingredientRepository;
    @Autowired
    private IngredientsInRecipeRepository ingredientsInRecipeRepository;


// TODO test addIngToRec  remIngFromRec
//    @Transactional
//    public RecipeIngredient createRecipeIngredient(Long recipeId, Long ingredientId) {
//



    public IngredientsInRecipe addIngredientToRecipe (Long recipeId, Long ingredientId,  String ingredientQuantity, String ingredientMeasurement) {

        IngredientsInRecipe ingredientInRecipe = new IngredientsInRecipe();
        try {
            Recipe recipe = recipeRepository.findByRecipeId(recipeId);
            Ingredient ingredient = ingredientRepository.findByIngredientId(ingredientId);
            if (recipe == null) {
                throw new RecipeNotFoundException();
            } else if (ingredient == null) {
                throw new IngredientNotFoundException();
            } else {
                ingredientInRecipe.setRecipe(recipe);
                ingredientInRecipe.setIngredient(ingredient);
                ingredientInRecipe.setRecipeName(recipe.getRecipeName());
                ingredientInRecipe.setIngredientName(ingredient.getIngredientName());
                ingredientInRecipe.setIngredientQuantity(ingredientQuantity);
                ingredientInRecipe.setIngredientMeasurement(ingredientMeasurement);
                ingredientsInRecipeRepository.saveAndFlush(ingredientInRecipe);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return ingredientInRecipe;
    }

    public List<IngredientsInRecipe> listIngredientsInRecipe(Long recipeId) {

        List<IngredientsInRecipe> ingredientsInRecipe = new ArrayList<>();
        try {
            Recipe recipe = recipeRepository.findByRecipeId(recipeId);
            if (recipe == null) {
                throw new RecipeNotFoundException();
            } else {
                ingredientsInRecipe = ingredientsInRecipeRepository.findAllByRecipe(recipe);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return ingredientsInRecipe;
    }


    public String deleteIngredientFromRecipe(Long ingredientsInRecipeId) {
        try {
            IngredientsInRecipe ingredientInRecipe = ingredientsInRecipeRepository.findByIngredientsInRecipeId(ingredientsInRecipeId);
            if (ingredientInRecipe == null) {
                throw new IngredientNotFoundException();
            } else {
                String name = ingredientInRecipe.getIngredient().getIngredientName();
                ingredientsInRecipeRepository.delete(ingredientInRecipe);
                return (name + "Ingredient deleted from recipe");
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return "Ingredient was not deleted";
    }



}
