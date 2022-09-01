package com.techelevator.repository;
import com.techelevator.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {

    Meal findByMealId(Long mealId);

    List<Meal> findAllByMealPlanId(Long mealPlanId);


}

