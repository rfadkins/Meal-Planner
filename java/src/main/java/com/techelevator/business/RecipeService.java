package com.techelevator.business;

import com.techelevator.exceptions.RecipeNotFoundException;
import com.techelevator.model.*;
import com.techelevator.repository.IngredientRepository;
import com.techelevator.repository.MealRepository;
import com.techelevator.repository.RecipeRepository;
import com.techelevator.repository.UserRepository;
import com.techelevator.util.BasicLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.SchemaOutputResolver;
import java.util.*;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private IngredientRepository ingredientRepository;
    @Autowired
    private MealRepository mealRepository;


    public Recipe createRecipe(String name, String instructions, String category) {
        Recipe recipe = new Recipe();
        try {
            if(name == null) {
                throw new RecipeNotFoundException();
            } else {
                recipe.setRecipeName(name);
                recipe.setRecipeInstructions(instructions);
                recipe.setCategory(category);
                recipeRepository.saveAndFlush(recipe);
            }
        } catch (Exception e) {
            BasicLogger.log("Recipe name cannot be null");
        }
        return recipe;
    }


    public Recipe getRecipeById (Long recipeId) {
        Recipe recipe = recipeRepository.findByRecipeId(recipeId);
        try {
            if (recipe == null) {
                throw new RecipeNotFoundException();
            }
        } catch (Exception e) {
            BasicLogger.log(e.getMessage());
        }
        return recipe;
    }


    public List<Recipe> displayAllRecipes () {
        List<Recipe> allRecipes = recipeRepository.findAll();
        return allRecipes;
    }


    public List<Recipe> getRecipesByCategory(String category) {
        List<Recipe> recipes = recipeRepository.findAllByCategoryLike(category);
        try {
            if (recipes == null) {
                throw new RecipeNotFoundException();
            }
        } catch (Exception e) {
            BasicLogger.log(e.getMessage());
        }
        return recipes;
    }


    public Recipe editRecipe(Long recipeId, String newName, String newInstructions, String newCategory) {
        try {
            Recipe recipe = recipeRepository.findByRecipeId(recipeId);
            if (recipe == null) {
                throw new RecipeNotFoundException();
            } else {
                recipe.setRecipeName(newName);
                recipe.setRecipeInstructions(newInstructions);
                recipe.setCategory(newCategory);
                recipeRepository.saveAndFlush(recipe);
                return recipe;
            }

        } catch (Exception e) {
            BasicLogger.log(e.getMessage());
        }
        return null;
    }


    public void deleteRecipe(Long recipeId) {
        try {
            if (recipeRepository.findByRecipeId(recipeId) == null) {
                throw new RecipeNotFoundException();
            } else {
                recipeRepository.delete(recipeRepository.findByRecipeId(recipeId));
            }
        } catch (Exception e) {
            BasicLogger.log(e.getMessage());
        }
    }

//    public Set<RecipeIngredient> addIngredientToRecipe(Long recipeId, Long ingredientId, Long count) {
//
//        Recipe recipe = recipeRepository.findByRecipeId(recipeId);
//        Ingredient ingredient = ingredientRepository.findByIngredientId(ingredientId);
//
//        RecipeIngredient recipeIngredient = new RecipeIngredient(recipe, ingredient, count);
//
//        Set<RecipeIngredient> ingredientsInRecipe = new HashSet<>();
////        ingredientsInRecipe.add(ingredient);
//
//        Set<RecipeIngredient> recipesWithIngredient = new HashSet<>();
////        recipesWithIngredient.add(recipe);
//
////        recipe.setIngredientsInRecipe(ingredientsInRecipe);
////        ingredient.setRecipesWithIngredient(recipesWithIngredient);
//
//        ingredientRepository.saveAndFlush(ingredient);
//        recipeRepository.saveAndFlush(recipe);
//
//        return ingredientsInRecipe;
//    }
//
//    public List<Ingredient> listIngredientsInRecipe(Long recipeId) {
//        List<Ingredient> ingredientsInRecipe = new ArrayList<>();
//        Map<Long, Ingredient> recipeIngredients = new HashMap<>();
//        try {
//            if (recipeRepository.findByRecipeId(recipeId) == null) {
//                throw new RecipeNotFoundException();
//            } else {
//                Recipe recipe = recipeRepository.findByRecipeId(recipeId);
//                if (recipe.getIngredientsInRecipe() == null) {
//                    throw new RecipeIngredientsNotFoundException();
//                } else {
//                    recipeIngredients = recipe.getIngredientsInRecipe();
//                    for (Map.Entry<Long, Ingredient> entry : recipeIngredients.entrySet()) {
//                        ingredientsInRecipe.add(entry.getValue());
//                    }
//                }
//            }
//        } catch (Exception e) {
//            BasicLogger.log(e.getMessage());
//        }
//        return ingredientsInRecipe;
//    }



}





