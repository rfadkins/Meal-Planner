//package com.techelevator.business.test;
//
//import com.techelevator.exceptions.IngredientNotFoundException;
//import com.techelevator.exceptions.RecipeNotFoundException;
//import com.techelevator.model.Ingredient;
//import com.techelevator.model.Recipe;
//import com.techelevator.repository.IngredientRepository;
//import com.techelevator.repository.RecipeRepository;
//import com.techelevator.util.BasicLogger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@Service
//public class RecipeIngredientService {
//
//    @Autowired
//    private RecipeRepository recipeRepository;
//    @Autowired
//    private IngredientRepository ingredientRepository;
//
//
//// TODO test addIngToRec  remIngFromRec
////    @Transactional
////    public RecipeIngredient createRecipeIngredient(Long recipeId, Long ingredientId) {
////
//
//
//    public Set<Ingredient> addIngredientToRecipe(Long recipeId, Long ingredientId) {
//        Set<Ingredient> ingredientsInRecipe = new HashSet<>();
//        Ingredient ingredient = ingredientRepository.findByIngredientId(ingredientId);
//        Recipe recipe = recipeRepository.findByRecipeId(recipeId);
//        try {
//            if (recipe == null) {
//                throw new RecipeNotFoundException();
//            } else if (ingredient == null) {
//                throw new IngredientNotFoundException();
//            } else {
//                ingredientsInRecipe = recipe.getIngredientsInRecipe();
//                ingredientsInRecipe.add(ingredient);
//                recipe.setIngredientsInRecipe(ingredientsInRecipe);
//
//                recipeRepository.saveAndFlush(recipe);
//            }
//        } catch (Exception e) {
//            BasicLogger.log(e.getMessage());
//        }
//        return ingredientsInRecipe;
//    }
//
//    public Recipe removeIngredientFromRecipe(Long recipeId, Long ingredientId) {
//        Set<Ingredient> ingredientsInRecipe = new HashSet<>();
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
//
//
//
//
//
//}
