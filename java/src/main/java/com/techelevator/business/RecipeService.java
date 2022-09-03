package com.techelevator.business;

import com.techelevator.model.Ingredient;
import com.techelevator.model.Meal;
import com.techelevator.model.Recipe;
import com.techelevator.model.User;
import com.techelevator.repository.IngredientRepository;
import com.techelevator.repository.MealRepository;
import com.techelevator.repository.RecipeRepository;
import com.techelevator.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

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

    public Recipe createRecipe (String name, String instructions, String category) {

        Recipe recipe = new Recipe();

        recipe.setRecipeName(name);
        recipe.setRecipeInstructions(instructions);
        recipe.setCategory(category);

        recipeRepository.saveAndFlush(recipe);

        return recipe;
    }

    //TODO delete recipe
    public Long deleteRecipe (Long recipeId) {
        recipeRepository.delete(recipeRepository.findByRecipeId(recipeId));
        return recipeId;
    }

    public Map<Long, Ingredient> addRecipeIngredient(Long recipeId, Long ingredientId) {

        Recipe recipe = recipeRepository.findByRecipeId(recipeId);
        Ingredient ingredient = ingredientRepository.findByIngredientId(ingredientId);

        Map<Long, Ingredient> recipeIngredients = new HashMap<>();
        recipeIngredients.put(recipe.getRecipeId(), ingredient);

        recipe.setRecipeIngredients(recipeIngredients);
        recipeRepository.save(recipe);

        return recipeIngredients;
    }

    public Map<Long, Recipe> addUserRecipe(Long userId, Long recipeId) {

        User user = userRepository.findByUserId(userId);
        Recipe recipe = recipeRepository.findByRecipeId(recipeId);

        Map<Long, Recipe> userRecipes = new HashMap<>();
        userRecipes.put(user.getUserId(), recipe);

        user.setUserRecipes(userRecipes);
        userRepository.save(user);

        return userRecipes;
    }

    public Map<Long, Recipe> addMealRecipe(Long mealId, Long recipeId) {

        Meal meal = mealRepository.findByMealId(mealId);
        Recipe recipe = recipeRepository.findByRecipeId(recipeId);

        Map<Long, Recipe> mealRecipes = new HashMap<>();
        mealRecipes.put(meal.getMealId(), recipe);

        meal.setMealRecipes(mealRecipes);
        mealRepository.save(meal);

        return mealRecipes;
    }





}
