package com.techelevator.repository;


import com.techelevator.model.IngredientsInRecipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientsInRecipeRepository extends JpaRepository<IngredientsInRecipe, Long> {


}
