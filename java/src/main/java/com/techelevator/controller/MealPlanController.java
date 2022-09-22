package com.techelevator.controller;

import com.techelevator.business.MealPlanService;
import com.techelevator.business.UserService;

import com.techelevator.model.MealPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
        return mealPlanService.displayMealPlan(mealplanID);
    }


    @GetMapping ("/mealplan/")
    public List<MealPlan> displayAllMealPlans() {
        return mealPlanService.displayAllMealPlans();
    }


    @PutMapping ("/mealplan/{mealplanId}")
    public MealPlan editMealPlan(@PathVariable("mealplanId") Long mealplanID,
                                @RequestBody MealPlan mealPlan) {
        return this.mealPlanService.editMealPlan(mealplanID, mealPlan.getMealPlanName());
    }


    @DeleteMapping ("/mealplan/{mealplanId}")
    public String editMealPlan(@PathVariable("mealplanId") Long mealplanID) {
        return this.mealPlanService.deleteMealPlan(mealplanID);
    }




}
