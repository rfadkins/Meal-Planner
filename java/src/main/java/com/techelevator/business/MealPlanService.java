package com.techelevator.business;

import com.techelevator.model.Meal;
import com.techelevator.model.MealPlan;
import com.techelevator.repository.*;
import com.techelevator.util.BasicLogger;
import lombok.Builder;
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


    public MealPlan createMealPlan(String name ){
        MealPlan mealPlan = new MealPlan();
        try {
            if (mealPlan == null) {
                throw new MealPlanNotFoundException();
            } else {
                mealPlan.setMealPlanName(name);
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
    public String deleteMealPlan(Long mealPlanId) {
        try {
            MealPlan mealPlan = mealPlanRepository.findByMealPlanId(mealPlanId);
            if (mealPlan == null) {
                throw new MealPlanNotFoundException();
            } else {
                String name = mealPlan.getMealPlanName();
                mealPlanRepository.delete(mealPlan);
                return (name + " has been deleted");
            }
        } catch (MealPlanNotFoundException e) {
            BasicLogger.log("Meal Plan ID cannot be null");
        }
        return "Meal Plan has not been deleted";
    }

    //TODO Test
    public MealPlan displayMealPlan(Long mealPlanId) {

        MealPlan mealPlan = mealPlanRepository.findByMealPlanId(mealPlanId);
        try {
            if (mealPlan == null) {
                throw new MealPlanNotFoundException();
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


}
