package com.techelevator.business;

import com.techelevator.repository.*;
import org.springframework.beans.factory.annotation.Autowired;

public class MealRecipeService {
    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private MealRepository mealRepository;


}
