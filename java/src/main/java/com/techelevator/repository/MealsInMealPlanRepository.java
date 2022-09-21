package com.techelevator.repository;

import com.techelevator.model.MealsInMealPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealsInMealPlanRepository extends JpaRepository<MealsInMealPlan, Long> {


}
