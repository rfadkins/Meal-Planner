package com.techelevator.business;

import com.techelevator.model.Meal;
import com.techelevator.model.MealPlan;
import com.techelevator.model.User;
import com.techelevator.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MealService {

    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private IngredientRepository ingredientRepository;
    @Autowired
    private MealRepository mealRepository;
    @Autowired
    MealPlanRepository mealPlanRepository;

    //TODO create meal
    public Meal createMeal (String name) {

        Meal meal = new Meal();
        meal.setMealName(name);

        mealRepository.saveAndFlush(meal);

        return meal;
    }

    //TODO delete meal
    public void deleteMeal (Long mealId) {
        mealRepository.delete(mealRepository.findByMealId(mealId));
    }

    //TODO update meal

    //TODO add meal to meal plan

    public MealPlan addMealToMealPlan (Long userId, Long mealId, Long mealPlanId) {
        User user = userRepository.findByUserId(userId);
        Meal meal = mealRepository.findByMealId(mealId);
        MealPlan mealPlan = mealPlanRepository.findByMealPlanId(mealPlanId);

//        mealPlan.put(meal.getMealId(), meal);
//
//        user.setMealPlan(mealPlan);

        //mealPlan.addMeal(meal);
        mealPlanRepository.save(mealPlan);

        return mealPlan;
    }
}
