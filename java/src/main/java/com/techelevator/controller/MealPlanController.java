package com.techelevator.controller;

import com.techelevator.business.MealPlanService;
import com.techelevator.business.UserService;

import com.techelevator.exceptions.IngredientNotFoundException;
import com.techelevator.exceptions.MealNotFoundException;
import com.techelevator.exceptions.MealPlanNotFoundException;
import com.techelevator.model.Ingredient;
import com.techelevator.model.MealPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
@CrossOrigin
//@PreAuthorize("isAuthenticated()")
public class MealPlanController {
    //This controller handles the meal_plan table

    //Uncomment when mealPlanService exists.
    @Autowired
    UserService userService;
    @Autowired
    MealPlanService mealPlanService;


    @Autowired
    public MealPlanController(UserService userService, MealPlanService mealPlanService) {
        this.userService = userService;
        this.mealPlanService = mealPlanService;
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping ("/mealplan/")
    public MealPlan createMealPlan(@RequestParam String mealPlanName) {
        return this.mealPlanService.createMealPlan(mealPlanName);
    }


    @GetMapping ("/mealplan/{mealplanId}")
    public MealPlan displayMealPlan(@PathVariable("mealplanId") Long mealplanID) {
        try {
            MealPlan mealPlan = mealPlanService.displayMealPlan(mealplanID);
            if (mealPlan == null) {
                throw new MealPlanNotFoundException();
            }
            return mealPlanService.displayMealPlan(mealplanID);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Meal Plan not found", e);
        }
    }


    @GetMapping ("/mealplan/")
    public List<MealPlan> displayAllMealPlans() {
        return mealPlanService.displayAllMealPlans();
    }


    @PutMapping ("/mealplan/{mealplanId}")
    public MealPlan editMealPlan(@PathVariable("mealplanId") Long mealplanID,
                                @RequestBody MealPlan mealPlan) {
        try {
            MealPlan editedMealPlan = mealPlanService.displayMealPlan(mealplanID);
            if (editedMealPlan == null) {
                throw new IngredientNotFoundException();
            } else if (mealPlan == null) {
                throw new IngredientNotFoundException();
            } else {
                return this.mealPlanService.editMealPlan(mealplanID, mealPlan.getMealPlanName());
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Meal Plan not found", e);
        }

    }


    @DeleteMapping ("/mealplan/{mealplanId}")
    public void deleteMealPlan(@PathVariable("mealplanId") Long mealplanId) {
        //return this.mealPlanService.deleteMealPlan(mealplanID);
        try {
            MealPlan deletedMealPlan = mealPlanService.displayMealPlan(mealplanId);
            if (deletedMealPlan == null) {
                throw new MealNotFoundException();
            } else {
                mealPlanService.deleteMealPlan(mealplanId);
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Meal Plan not found", e);
        }
    }




}
