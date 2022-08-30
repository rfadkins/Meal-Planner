package com.techelevator.repository;
import com.techelevator.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MealRepository extends JpaRepository<Meal, Long> {

    Meal findByMealId(Long mealId);

    List<Meal> findAllByMealPlanId(Long mealPlanId);

    List<Meal> findAllByRecipeCategory(String recipeCategory);

    List<Meal> findAllByIngredientCategory(String ingredientCategory);

}

