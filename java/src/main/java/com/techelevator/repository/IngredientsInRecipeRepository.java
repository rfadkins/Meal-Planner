package com.techelevator.repository;


import com.techelevator.model.Ingredient;
import com.techelevator.model.IngredientsInRecipe;
import com.techelevator.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Repository
public interface IngredientsInRecipeRepository extends JpaRepository<IngredientsInRecipe, Long> {

    IngredientsInRecipe findByIngredientsInRecipeId(Long ingredientsInRecipeId);

    List<IngredientsInRecipe> findAllByIngredient(Ingredient ingredient);

    List<IngredientsInRecipe> findAllByRecipe(Recipe recipe);




}
