package com.techelevator.business;

import com.techelevator.exceptions.MealNotFoundException;
import com.techelevator.exceptions.MealPlanNotFoundException;
import com.techelevator.model.Meal;
import com.techelevator.model.MealPlan;
import com.techelevator.model.MealsInMealPlan;
import com.techelevator.repository.MealPlanRepository;
import com.techelevator.repository.MealRepository;
import com.techelevator.repository.MealsInMealPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MealPlanMealService {

    @Autowired
    MealRepository mealRepository;
    @Autowired
    MealPlanRepository mealPlanRepository;
    @Autowired
    MealsInMealPlanRepository mealsInMealPlanRepository;

    public MealsInMealPlan addMealToMealPlan(Long mealId,
                                            Long mealPlanId,
                                            int mealOrder) {

        MealsInMealPlan mealsInMealPlan = new MealsInMealPlan();
        try {
            Meal meal = mealRepository.findByMealId(mealId);
            MealPlan mealPlan = mealPlanRepository.findByMealPlanId(mealPlanId);

            if (mealPlan == null) {
                throw new MealPlanNotFoundException();
            } else if (meal == null) {
                throw new MealNotFoundException();
            } else {
                mealsInMealPlan.setMealPlan(mealPlan);
                mealsInMealPlan.setMeal(meal);
                mealsInMealPlan.setMealOrder(mealOrder);
                mealsInMealPlan.setMealName(meal.getMealName());
                mealsInMealPlan.setMealPlanName(mealPlan.getMealPlanName());
                mealsInMealPlanRepository.saveAndFlush(mealsInMealPlan);
                return mealsInMealPlan;
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
            //System.out.println(e.getMessage());
        }
        return mealsInMealPlan;
    }


    public List<MealsInMealPlan> displayMealsInMealPlan(Long mealPlanId) {
        MealPlan mealPlan = mealPlanRepository.findByMealPlanId(mealPlanId);
        try {
            if (mealPlan == null) {
                throw new MealPlanNotFoundException();
            } else {
                List<MealsInMealPlan> mealsInMealPlan = mealsInMealPlanRepository.findAllByMealPlan(mealPlan);
                return mealsInMealPlan;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return null;
    }


    public String deleteMealFromMealPlan(Long mealsInMealPlanId) {
        try {
            MealsInMealPlan mealsInMealPlan = mealsInMealPlanRepository.findByMealsInMealPlanId(mealsInMealPlanId);
            if (mealsInMealPlan == null) {
                throw new MealPlanNotFoundException();
            } else {
                String mealName = mealsInMealPlan.getMeal().getMealName();
                mealsInMealPlanRepository.delete(mealsInMealPlan);
                return (mealName + " has been deleted from this meal plan.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return "Meal not deleted.";
    }


}
