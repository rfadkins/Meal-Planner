package com.techelevator.business;

import com.techelevator.exceptions.MealNotFoundException;
import com.techelevator.exceptions.MealPlanNotFoundException;
import com.techelevator.model.Meal;
import com.techelevator.model.MealPlan;
import com.techelevator.repository.MealPlanRepository;
import com.techelevator.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public class MealPlanMealService {

    @Autowired
    MealRepository mealRepository;
    @Autowired
    MealPlanRepository mealPlanRepository;

    public MealPlan addMealToMealPlan(Long mealPlanId, Long mealId) {
        Set<Meal> mealsInMealPlan = new HashSet<>();
        MealPlan mealPlan = mealPlanRepository.findByMealPlanId(mealPlanId);
        Meal meal = mealRepository.findByMealId(mealId);
        try {
            if (mealPlan == null) {
                throw new MealPlanNotFoundException();
            } else if (meal == null) {
                throw new MealNotFoundException();
            } else {
                mealsInMealPlan = mealPlan.getMealsInMealPlan();
                mealsInMealPlan.add(meal);
                mealPlan.setMealsInMealPlan(mealsInMealPlan);

                mealPlanRepository.saveAndFlush(mealPlan);
            }
        } catch (Exception e) {
        }
        return mealPlan;
    }

    public MealPlan removeMealsFromMealPlan (Long mealPlanId, Long mealId) {
        Set <Meal> mealsInMealPlan = new HashSet<>();
        MealPlan mealPlan = mealPlanRepository.findByMealPlanId(mealPlanId);
        Meal meal = mealRepository.findByMealId(mealId);
        try {
            if(mealPlan == null) {
                throw new MealPlanNotFoundException();
            } else if (meal == null) {
                throw new MealNotFoundException();
            } else {
                mealsInMealPlan = mealPlan.getMealsInMealPlan();
                mealsInMealPlan.remove(meal);
                mealPlan.setMealsInMealPlan(mealsInMealPlan);

                mealPlanRepository.saveAndFlush(mealPlan);
            }

        } catch (Exception e) {

        }
        return mealPlan;
    }
}
