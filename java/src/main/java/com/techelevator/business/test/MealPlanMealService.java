package com.techelevator.business.test;//package com.techelevator.business;
//
//import com.techelevator.exceptions.MealNotFoundException;
//import com.techelevator.exceptions.MealPlanNotFoundException;
//import com.techelevator.model.Meal;
//import com.techelevator.model.MealPlan;
//import com.techelevator.repository.MealPlanRepository;
//import com.techelevator.repository.MealRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//@Service
//public class MealPlanMealService {
//
//    @Autowired
//    MealRepository mealRepository;
//    @Autowired
//    MealPlanRepository mealPlanRepository;
//
//    public MealPlan addMealToMealPlan(byte mealOrder,  Long mealId, Long mealPlanId) {
//        MealPlan mealPlan = mealPlanRepository.findByMealPlanId(mealPlanId);
//        Meal meal = mealRepository.findByMealId(mealId);
//
//        Set<Meal> mealsInMealPlan = new HashSet<>();
//        String[] mealOrderArray = new String[30];
//        try {
//            if (mealPlan == null) {
//                throw new MealPlanNotFoundException();
//            } else if (meal == null) {
//                throw new MealNotFoundException();
//            } else {
//                if (mealOrder > 0) {
//                    mealOrderArray[mealOrder] = mealId.toString();
//                    mealPlan.setMealOrder(mealOrderArray);
//                }
//
//                mealsInMealPlan = mealPlan.getMealsInMealPlan();
//                mealsInMealPlan.add(meal);
//                mealPlan.setMealsInMealPlan(mealsInMealPlan);
//
//                mealPlanRepository.saveAndFlush(mealPlan);
//            }
//        } catch (Exception e) {
//        }
//        return mealPlan;
//    }
//
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
//
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
//}
