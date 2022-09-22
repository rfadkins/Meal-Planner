package com.techelevator.business;

import com.techelevator.exceptions.MealNotFoundException;
import com.techelevator.exceptions.RecipeNotFoundException;
import com.techelevator.model.Meal;
import com.techelevator.model.Recipe;
import com.techelevator.model.RecipesInMeal;
import com.techelevator.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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


    public List<Recipe> getRecipesInMeal(Long mealId) {

        List<Recipe> recipesInMeal = new ArrayList<>();
        try {
            Meal meal = mealRepository.findByMealId(mealId);
            if (meal == null) {
                throw new MealNotFoundException();
            } else {
                List<RecipesInMeal> recipesInMealList = recipesInMealRepository.findAllByMeal(meal);
                for (RecipesInMeal recipeInMeal : recipesInMealList) {
                    recipesInMeal.add(recipeInMeal.getRecipe());
                }
                return recipesInMeal;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return recipesInMeal;
    }

    public String deleteRecipeInMeal(Long recipesInMealId) {
        try {
            RecipesInMeal recipeInMeal = recipesInMealRepository.findByRecipesInMealId(recipesInMealId);
            if (recipeInMeal == null) {
                throw new RecipeNotFoundException();
            } else {
                String name = recipeInMeal.getMeal().getMealName();
                recipesInMealRepository.delete(recipeInMeal);
                return (name + " Recipe deleted from meal");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return "Recipe not deleted from meal";
    }

}
