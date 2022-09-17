package com.techelevator.business;

import com.techelevator.exceptions.IngredientNotFoundException;
import com.techelevator.exceptions.RecipeNotFoundException;
import com.techelevator.model.Ingredient;
import com.techelevator.model.Recipe;
//import com.techelevator.model.RecipeIngredient;
import com.techelevator.repository.*;
import com.techelevator.util.BasicLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service
public class RecipeIngredientService {

    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private IngredientRepository ingredientRepository;
//    @Autowired
//    private RecipeIngredientRepository recipeIngredientRepository;

// TODO test addIngToRec  remIngFromRec
//    @Transactional
//    public RecipeIngredient createRecipeIngredient(Long recipeId, Long ingredientId) {
//
//        Recipe recipe = recipeRepository.findByRecipeId(recipeId);
//        recipe.setRecipeName(recipe.getRecipeName());
//        recipe.setRecipeInstructions(recipe.getRecipeInstructions());
//        recipe.setCategory(recipe.getCategory());
//        recipeRepository.saveAndFlush(recipe);
//
//        Ingredient ingredient = ingredientRepository.findByIngredientId(ingredientId);
//        ingredient.setIngredientName(ingredient.getIngredientName());
//        ingredient.setIngredientCategory(ingredient.getIngredientCategory());
//        ingredientRepository.saveAndFlush(ingredient);
//
//        RecipeIngredient recipeIngredient = new RecipeIngredient();
//        recipeIngredient.setRecipe(recipe);
//        recipeIngredient.setIngredient(ingredient);
//        recipeIngredient.setCount(count);
//
//        recipe.getIngredientsInRecipe().add(recipeIngredient);
//        ingredient.getRecipesWithIngredient().add(recipeIngredient);
//
//        recipeRepository.saveAndFlush(recipe);
//        ingredientRepository.saveAndFlush(ingredient);
//        recipeIngredientRepository.saveAndFlush(recipeIngredient);
//
//        return recipeIngredient;
//    }
//
//
//    public RecipeIngredient addIngredientToRecipe(Long recipeId, Long ingredientId, String count) {
//        Set<RecipeIngredient> ingredientsInRecipe = new HashSet<>();
//        Ingredient ingredient = ingredientRepository.findByIngredientId(ingredientId);
//        Recipe recipe = recipeRepository.findByRecipeId(recipeId);
//        ingredientRepository.saveAndFlush(ingredient);
//        recipeRepository.saveAndFlush(recipe);
//        try {
//            if (recipe == null) {
//                throw new RecipeNotFoundException();
//            } else if (ingredient == null) {
//                throw new IngredientNotFoundException();
//            } else {
//                RecipeIngredient recipeIngredient = new RecipeIngredient(recipe, ingredient, count);
//                ingredientsInRecipe = recipe.getIngredientsInRecipe();
//                ingredientsInRecipe.add(recipeIngredient);
//                recipe.setIngredientsInRecipe(ingredientsInRecipe);
//
//                recipeRepository.saveAndFlush(recipe);
//            }
//        } catch (Exception e) {
//            BasicLogger.log(e.getMessage());
//        }
//        return RecipeIngredient.builder().build();
//    }
//
//    public Recipe removeIngredientFromRecipe(Long recipeId, Long ingredientId) {
//        Set<RecipeIngredient> ingredientsInRecipe = new HashSet<>();
//        Ingredient ingredient = ingredientRepository.findByIngredientId(ingredientId);
//        Recipe recipe = recipeRepository.findByRecipeId(recipeId);
//        try {
//            if (recipe == null) {
//                throw new RecipeNotFoundException();
//            } else if (ingredient == null) {
//                throw new IngredientNotFoundException();
//            } else {
//                ingredientsInRecipe = recipe.getIngredientsInRecipe();
//                ingredientsInRecipe.remove(ingredient);
//                recipe.setIngredientsInRecipe(ingredientsInRecipe);
//
//                recipeRepository.saveAndFlush(recipe);
//            }
//        } catch (Exception e) {
//            BasicLogger.log(e.getMessage());
//        }
//        return recipe;
//    }

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
