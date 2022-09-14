package com.techelevator.business;

import com.techelevator.exceptions.MealNotFoundException;
import com.techelevator.exceptions.RecipeNotFoundException;
import com.techelevator.model.Meal;
import com.techelevator.model.Recipe;
import com.techelevator.repository.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public class MealRecipeService {
    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private MealRepository mealRepository;


    public Meal addRecipeToMeal(Long mealId, Long recipeId) {
        Meal meal = mealRepository.findByMealId(mealId);
        Recipe recipe = recipeRepository.findByRecipeId(recipeId);
        Set<Recipe> recipesInMeal = new HashSet<>();
        try {
            if ( meal == null) {
                throw new MealNotFoundException();
            } else if (recipe == null) {
                throw new RecipeNotFoundException();
            } else {
                recipesInMeal = meal.getRecipesInMeal();
                recipesInMeal.add(recipe);
                meal.setRecipesInMeal(recipesInMeal);

                mealRepository.saveAndFlush(meal);
            }
        } catch (Exception e ) {

        }
        return meal;
    }

    public Meal removeRecipeFromMeal(Long mealId, Long recipeId) {
        Set<Recipe> recipesInMeal = new HashSet<>();
        Meal meal = mealRepository.findByMealId(mealId);
        Recipe recipe = recipeRepository.findByRecipeId(recipeId);
        try {
            if ( meal == null) {
                throw new MealNotFoundException();
            } else if (recipe == null) {
                throw new RecipeNotFoundException();
            } else {
                recipesInMeal = meal.getRecipesInMeal();
                recipesInMeal.remove(recipe);
                meal.setRecipesInMeal(recipesInMeal);

                mealRepository.saveAndFlush(meal);
            }
        } catch (Exception e ) {

        }
        return meal;
    }


}
