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

    public MealsInMealPlan addMealToMealPlan(Long mealId, Long mealPlanId, int mealOrder) {
        MealsInMealPlan mealsInMealPlan = new MealsInMealPlan();

        try {
            Meal meal = mealRepository.findByMealId(mealId);
            MealPlan mealPlan = mealPlanRepository.findByMealPlanId(mealPlanId);

            if (mealPlan == null) {
                throw new MealPlanNotFoundException();
            } else if (meal == null) {
                throw new MealNotFoundException();
            } else {
                // create parent entities FIRST
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
            System.out.println(e.getMessage());
        }
        return mealsInMealPlan;
    }


//        Set<Meal> mealsInMealPlan = new HashSet<>();
//        String[] mealOrderArray = new String[30];
//        try {
//            if (mealPlan == null) {
//                throw new MealPlanNotFoundException();
//            } else if (meal == null) {
//                throw new MealNotFoundException();
//            } else {
//
//                mealPlanRepository.saveAndFlush(mealPlan);
//            }
//        } catch (Exception e) {
//        }
//        return mealPlan;
//    }


//    public MealPlan removeMealsFromMealPlan (Long mealPlanId, Long mealId) {
//        Set <Meal> mealsInMealPlan = new HashSet<>();
//        MealPlan mealPlan = mealPlanRepository.findByMealPlanId(mealPlanId);
//        Meal meal = mealRepository.findByMealId(mealId);
//        try {
//            if(mealPlan == null) {
//                throw new MealPlanNotFoundException();
//            } else if (meal == null) {
//                throw new MealNotFoundException();
//            } else {
//                mealsInMealPlan = mealPlan.getMealsInMealPlan();
//                mealsInMealPlan.remove(meal);
//                mealPlan.setMealsInMealPlan(mealsInMealPlan);
//
//                mealPlanRepository.saveAndFlush(mealPlan);
//            }
//
//        } catch (Exception e) {
//
//        }
//        return mealPlan;
//    }

//    public List<Meal> displayMealsInMealPlan(Long mealPlanId) {
//        MealPlan mealPlan = mealPlanRepository.findByMealPlanId(mealPlanId);
//        List<Meal> mealsInMealPlan = new ArrayList<>();
//        try {
//            if (mealPlan == null) {
//                throw new MealPlanNotFoundException();
//            } else {
//                mealsInMealPlan = mealPlanRepository.findAllMealsByMealPlanId(mealPlanId);
//            }
//        } catch (Exception e) {
//
//        }
//        return mealsInMealPlan;
//    }
   // }
}
