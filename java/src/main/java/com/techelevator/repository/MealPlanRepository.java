package com.techelevator.repository;

import com.techelevator.model.Meal;
import com.techelevator.model.MealPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MealPlanRepository extends JpaRepository<MealPlan, Long> {

    MealPlan findByMealPlanId(Long mealPlanId);

    MealPlan findByUserId(Long userId);

}
