package com.techelevator.repository;

import com.techelevator.model.Meal;
import com.techelevator.model.Recipe;
import com.techelevator.model.RecipesInMeal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipesInMealRepository extends JpaRepository<RecipesInMeal, Long> {

    RecipesInMeal findByRecipesInMealId(Long recipesInMealId);

    List<RecipesInMeal> findAllByMeal(Meal meal);

    List<RecipesInMeal> findAllByRecipe(Recipe recipe);

}
