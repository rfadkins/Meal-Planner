package com.techelevator.repository;

import com.techelevator.model.Meal;
import com.techelevator.model.MealPlan;
import com.techelevator.model.MealsInMealPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealsInMealPlanRepository extends JpaRepository<MealsInMealPlan, Long> {

    MealsInMealPlan findByMealsInMealPlanId(Long mealsInMealPlanId);

    List<MealsInMealPlan> findAllByMealPlan(MealPlan mealPlan);

    List<MealsInMealPlan> findAllByMeal(Meal meal);

}
