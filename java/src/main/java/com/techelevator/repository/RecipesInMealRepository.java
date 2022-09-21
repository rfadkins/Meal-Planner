package com.techelevator.repository;

import com.techelevator.model.RecipesInMeal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipesInMealRepository extends JpaRepository<RecipesInMeal, Long> {


}
