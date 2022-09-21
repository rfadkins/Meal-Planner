//package com.techelevator.business.test;
//
//import com.techelevator.business.RecipeService;
//import com.techelevator.exceptions.IngredientNotFoundException;
//import com.techelevator.model.Ingredient;
//import com.techelevator.repository.IngredientRepository;
//import com.techelevator.repository.RecipeRepository;
//import com.techelevator.repository.UserRepository;
//import com.techelevator.util.BasicLogger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class IngredientService {
//
//    @Autowired
//    private UserRepository userRepository;
//    @Autowired
//    IngredientRepository ingredientRepository;
//    @Autowired
//    private RecipeRepository recipeRepository;
//    @Autowired
//    private RecipeService recipeService;
//
//
//
//    public Ingredient createIngredient(String name, String category) {
//        Ingredient ingredient = new Ingredient();
//
//        ingredient.setIngredientName(name);
//        ingredient.setIngredientCategory(category);
//
//        ingredientRepository.saveAndFlush(ingredient);
//
//        return ingredient;
//    }
//
//    public Ingredient editIngredient(Long ingredientId, String newName, String newCategory) {
//        Ingredient ingredient = ingredientRepository.findByIngredientId(ingredientId);
//        ingredient.setIngredientName(newName);
//        ingredient.setIngredientCategory(newCategory);
//        ingredientRepository.saveAndFlush(ingredient);
//        return ingredient;
//    }
//
//    public void deleteIngredient(Long ingredientId) {
//        Ingredient ingredient = ingredientRepository.findByIngredientId(ingredientId);
//        try {
//            if (ingredient == null) {
//                throw new IngredientNotFoundException();
//            } else {
//                ingredientRepository.deleteById(ingredientId);
//            }
//        } catch (Exception e) {
//            BasicLogger.log(e.getMessage());
//        }
//    }
//
//    public Ingredient getIngredientById (Long ingredientId) {
//        Ingredient ingredient = ingredientRepository.findByIngredientId(ingredientId);
//        try {
//            if (ingredient == null) {
//                throw new IngredientNotFoundException();
//            }
//        } catch (Exception e) {
//            BasicLogger.log(e.getMessage());
//        }
//        return ingredient;
//    }
//
//    public List<Ingredient> getAllIngredients() {
//        return ingredientRepository.findAll();
//    }
//
//
//
//
//
//    //TODO grocery list logic...
//
//    //TODO test listIngredientsInRecipe
//}
