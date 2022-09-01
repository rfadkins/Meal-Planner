package com.techelevator.repository;
import com.techelevator.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    Recipe findByRecipeId(Long recipeId);

    //Recipe findByRecipeName(String recipeName);

//    List<Recipe> findAllByMealId(Long mealId);

//    List<Recipe> findAllByIngredient(String ingredient);

//    List<Recipe> findAllByIngredientCategory(String ingredientCategory);

    //List<Recipe> findAllByRecipeCategory(String recipeCategory);

}
