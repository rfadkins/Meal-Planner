package com.techelevator.business;

import com.techelevator.exceptions.MealNotFoundException;
import com.techelevator.exceptions.RecipeNotFoundException;
import com.techelevator.model.Meal;
import com.techelevator.model.Recipe;
import com.techelevator.model.RecipesInMeal;
import com.techelevator.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class MealRecipeService {
    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private MealRepository mealRepository;
    @Autowired
    private RecipesInMealRepository recipesInMealRepository;


    public RecipesInMeal addRecipeToMeal(Long recipeId, Long mealId) {
        Meal meal = mealRepository.findByMealId(mealId);
        Recipe recipe = recipeRepository.findByRecipeId(recipeId);
        RecipesInMeal recipeInMeal = recipesInMealRepository.findByMealMealId(mealId);
        //Set<Recipe> recipesInMeal = new HashSet<>();
        try {
            if ( meal == null) {
                throw new MealNotFoundException();
            } else if (recipe == null) {
                throw new RecipeNotFoundException();
            } else if (recipeInMeal == null) {
                recipeInMeal = new RecipesInMeal();
            } else {
                recipeInMeal.setMeal(meal);
                recipeInMeal.setRecipe(recipe);
                recipesInMealRepository.saveAndFlush(recipeInMeal);
            }
        } catch (Exception e ) {

        }
        return recipeInMeal;
    }

//    public Meal removeRecipeFromMeal(Long mealId, Long recipeId) {
//        Set<Recipe> recipesInMeal = new HashSet<>();
//        Meal meal = mealRepository.findByMealId(mealId);
//        Recipe recipe = recipeRepository.findByRecipeId(recipeId);
//        try {
//            if ( meal == null) {
//                throw new MealNotFoundException();
//            } else if (recipe == null) {
//                throw new RecipeNotFoundException();
//            } else {
//                recipesInMeal = meal.getRecipesInMeal();
//                recipesInMeal.remove(recipe);
//                meal.setRecipesInMeal(recipesInMeal);
//
//                mealRepository.saveAndFlush(meal);
//            }
//        } catch (Exception e ) {
//
//        }
//        return meal;
//    }


}
