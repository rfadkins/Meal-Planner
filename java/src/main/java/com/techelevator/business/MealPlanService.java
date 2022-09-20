package com.techelevator.business;

import com.techelevator.model.MealPlan;
import com.techelevator.repository.*;
import com.techelevator.util.BasicLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.techelevator.exceptions.MealPlanNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MealPlanService {
    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private IngredientRepository ingredientRepository;
    @Autowired
    private MealRepository mealRepository;
    @Autowired
    private MealPlanRepository mealPlanRepository;

    //TODO Test
    //TODO perhaps different exceptions?
    public MealPlan createMealPlan(String name ){
        MealPlan mealPlan = new MealPlan();
        try {
            if (name == null) {
                throw new MealPlanNotFoundException();
            } else {
                mealPlan.setMealPlanName(name);

                Long[] mealOrder = new Long[30];
                fillMealOrderArray(mealOrder);
                mealPlan.setMealOrder(mealOrder);

                mealPlanRepository.saveAndFlush(mealPlan);
            }

        } catch (MealPlanNotFoundException e) {
            BasicLogger.log("Meal Plan ID cannot be null");
        }
            return mealPlan;
    }

    //TODO Test
    public MealPlan editMealPlan(Long mealPlanId, String newName) {
        MealPlan editedMealPlan = new MealPlan();
        try {
            if (mealPlanId == null) {
                throw new MealPlanNotFoundException();
            } else {
                editedMealPlan = mealPlanRepository.findByMealPlanId(mealPlanId);
                editedMealPlan.setMealPlanName(newName);
                mealPlanRepository.saveAndFlush(editedMealPlan);
            }
        } catch (MealPlanNotFoundException e) {
            BasicLogger.log("Meal Plan ID cannot be null");
        }
        return editedMealPlan;
    }

    //TODO Test
    public void deleteMealPlan(Long mealPlanId) {
        try {
            if (mealPlanId == null) {
                throw new MealPlanNotFoundException();
            } else {
                mealPlanRepository.deleteById(mealPlanId);
            }
        } catch (MealPlanNotFoundException e) {
            BasicLogger.log("Meal Plan ID cannot be null");
        }
    }

    //TODO Test
    public MealPlan displayMealPlan(Long mealPlanId) {
        MealPlan mealPlan = new MealPlan();
        try {
            if (mealPlanId == null) {
                throw new MealPlanNotFoundException();
            } else {
                mealPlan = mealPlanRepository.findByMealPlanId(mealPlanId);
            }
        } catch (MealPlanNotFoundException e) {
            BasicLogger.log("Meal Plan ID cannot be null");
        }
        return mealPlan;
    }

    public List<MealPlan> displayAllMealPlans() {
        List<MealPlan> mealPlans = new ArrayList<>();
        try {
            mealPlans = mealPlanRepository.findAll();
        } catch (Exception e) {
            BasicLogger.log("No meal plans found");
        }
        return mealPlans;
    }

//    public List<MealPlan> displayAllMealPlansByUser(Long userId) {
//        List<MealPlan> mealPlans = new ArrayList<>();
//        try {
//            mealPlans = mealPlanRepository.findAllByFkUserUserId(userId);
//        } catch (Exception e) {
//            BasicLogger.log("No meal plans found");
//        }
//        return mealPlans;
//    }


    public Long[] fillMealOrderArray (Long[] mealOrder) {
        for (int i = 1; i < 30; i++) {
            mealOrder[i] = 0L;
        }
        return mealOrder;
    }
    /*--------------------
    displayMealPlan()
    GET
    Path: /mealplan/{meal_plan_id}
    --------------------*/
}
