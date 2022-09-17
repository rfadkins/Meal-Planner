package com.techelevator.controller;

import com.techelevator.business.MealPlanService;
import com.techelevator.business.UserService;

import com.techelevator.model.MealPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


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

    /*--------------------
    createMealPlan()
    POST
    Path: /mealplan/
    --------------------*/
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping ("/mealplan/")
    public void createMealPlan(@RequestBody MealPlan mealPlan) {
        this.mealPlanService.createMealPlan(mealPlan.getMealPlanName());
    }

    /*--------------------
    editMealPlan()
    PUT
    Path: /mealplan/{meal_plan_id}
    --------------------*/
    @PutMapping ("/mealplan/{mealplanId}")
    public void editeMealPlan(@PathVariable("mealplanId") Long mealplanID, @RequestBody MealPlan mealPlan) {
        //MealPlan mealPlan = mapper.mapMealPlanDTOToEntity(mealPlanDTO);
        mealPlanService.editMealPlan(mealplanID, mealPlan.getMealPlanName());
    }

    /*--------------------
    deleteMealPlan()
    DELETE
    Path: /mealplan/{meal_plan_id}
    --------------------*/
    @DeleteMapping ("/mealplan/{mealplanId}")
    public void editMealPlan(@PathVariable("mealplanId") Long mealplanID) {
        mealPlanService.deleteMealPlan(mealplanID);
    }

    /*--------------------
    displayMealPlan()
    GET
    Path: /mealplan/{meal_plan_id}
    --------------------*/
    @GetMapping ("/mealplan/{mealplanId}")
    public MealPlan displayMealPlan(@PathVariable("mealplanId") Long mealplanID) {
        return mealPlanService.displayMealPlan(mealplanID);
    }


}
