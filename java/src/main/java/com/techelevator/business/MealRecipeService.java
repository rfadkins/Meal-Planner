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
        RecipesInMeal recipeInMeal = new RecipesInMeal();

        try {
            Meal meal = mealRepository.findByMealId(mealId);
            Recipe recipe = recipeRepository.findByRecipeId(recipeId);

            if ( meal == null) {
                throw new MealNotFoundException();
            } else if (recipe == null) {
                throw new RecipeNotFoundException();
            }  else {
                //create parent entities FIRST
                recipeInMeal.setMeal(meal);
                recipeInMeal.setRecipe(recipe);
                recipeInMeal.setMealName(meal.getMealName());
                recipeInMeal.setRecipeName(recipe.getRecipeName());
                recipesInMealRepository.saveAndFlush(recipeInMeal);
                return recipeInMeal;
            }
        } catch (Exception e ) {
            e.printStackTrace();
            System.out.println(e.getMessage());
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
