package com.techelevator.repository;

import com.techelevator.model.RecipesInMeal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipesInMealRepository extends JpaRepository<RecipesInMeal, Long> {

    RecipesInMeal findByMealMealId(Long mealId);

    List<RecipesInMeal> findAllByMealMealId(Long mealId);

    List<RecipesInMeal> findAllByRecipeRecipeId(Long recipeId);

}
