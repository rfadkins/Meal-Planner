package com.techelevator.business;

import com.techelevator.model.MealPlan;
import com.techelevator.repository.*;
import com.techelevator.util.BasicLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.techelevator.exceptions.MealPlanNotFoundException;

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

    public MealPlan createMealPlan(Long mealPlanId){
        MealPlan mealPlan = new MealPlan();
        try {
            if (mealPlanId == null) {
                throw new MealPlanNotFoundException();
            } else {
                mealPlan = mealPlanRepository.findByMealPlanId(mealPlanId);
                mealPlanRepository.saveAndFlush(mealPlan);
            }

        } catch (MealPlanNotFoundException e) {
            BasicLogger.log("Meal Plan ID cannot be null");
        }
            return mealPlan;
    }
    /*--------------------
    createMealPlan()
    POST
    Path: /mealplan/
    --------------------*/


    /*--------------------
    editMealPlan()
    PUT
    Path: /mealplan/{meal_plan_id}
    --------------------*/


    /*--------------------
    deleteMealPlan()
    DELETE
    Path: /mealplan/{meal_plan_id}
    --------------------*/


    /*--------------------
    displayMealPlan()
    GET
    Path: /mealplan/{meal_plan_id}
    --------------------*/
}
