package com.techelevator.repository;


import com.techelevator.model.IngredientsInRecipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientsInRecipeRepository extends JpaRepository<IngredientsInRecipe, Long> {

    List<IngredientsInRecipe> findAllByRecipeRecipeId(Long recipeId);
    List<IngredientsInRecipe> findAllByIngredientIngredientId(Long ingredientId);



}
