package com.techelevator.controller;

import com.techelevator.business.IngredientService;
import com.techelevator.business.MealService;
import com.techelevator.business.UserService;
import com.techelevator.model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@PreAuthorize("isAuthenticated()")
public class MealPlanController {
    //This controller handles the meal_plan table

    //Uncomment when mealPlanService exists.
    /*  UserService userService;
    MealPlanService mealPlanService;

    @Autowired
    public MealPlanController(UserService userService, MealPlanService mealPlanService) {
        this.userService = userService;
        this.mealPlanService = mealPlanService;
    }*/

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
