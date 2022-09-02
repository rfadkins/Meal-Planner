package com.techelevator.business;

import com.techelevator.model.Meal;
import com.techelevator.repository.IngredientRepository;
import com.techelevator.repository.MealRepository;
import com.techelevator.repository.RecipeRepository;
import com.techelevator.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
