package com.techelevator.repository;

import com.techelevator.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeRepository extends JpaRepository<RecipeRepository, Long> {

    Recipe findByRecipeId(Long recipeId);

    Recipe findByRecipeName(String recipeName);

    List<Recipe> findAllByMealId(Long mealId);

    List<Recipe> findAllByIngredient(String ingredient);

    List<Recipe> findAllByIngredientCategory(String ingredientCategory);

    List<Recipe> findAllByRecipeCategory(String recipeCategory);

    List<Recipe> findAllByMealPlanId(Long mealPlanId);
}
