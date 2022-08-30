package com.techelevator.repository;
import com.techelevator.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    Ingredient findByIngredientId(Long ingredientId);

    Ingredient findByIngredientName(String ingredientName);

    List<Ingredient> findAllByMealPlanId(Long mealPlanId);

    List<Ingredient> findAllByRecipeId(Long recipeId);

    List<Ingredient> findAllByMealId(Long mealId);

    List<Ingredient> findAllByPantryId(Long pantryId);

    List<Ingredient> findAllByIngredientCategory(String ingredientCategory);

}

