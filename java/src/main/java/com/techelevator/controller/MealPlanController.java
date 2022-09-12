package com.techelevator.controller;

import com.techelevator.business.IngredientService;
import com.techelevator.business.MealPlanService;
import com.techelevator.business.MealService;
import com.techelevator.business.UserService;
import com.techelevator.datatransfer.IngredientDTO;
import com.techelevator.datatransfer.MealPlanDTO;
import com.techelevator.model.Ingredient;
import com.techelevator.model.MealPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.techelevator.datatransfer.Mapper;

@RestController
@CrossOrigin
//@PreAuthorize("isAuthenticated()")
public class MealPlanController {
    //This controller handles the meal_plan table

    //Uncomment when mealPlanService exists.
    UserService userService;
    @Autowired
    MealPlanService mealPlanService;
    @Autowired
    Mapper mapper;

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
    public void createMealPlan(@RequestBody MealPlanDTO mealPlanDTO) {
        MealPlan mealPlan = mapper.mapMealPlanDTOToEntity(mealPlanDTO);
        this.mealPlanService = mealPlanService;
        this.mealPlanService.createMealPlan(mealPlanDTO.getMealPlanName());
    }

    /*--------------------
    editMealPlan()
    PUT
    Path: /mealplan/{meal_plan_id}
    --------------------*/
    @PutMapping ("/mealplan/{mealplanId}")
    public void editeMealPlan(@PathVariable("mealplanId") Long mealplanID, @RequestBody MealPlanDTO mealPlanDTO) {
        MealPlan mealPlan = mapper.mapMealPlanDTOToEntity(mealPlanDTO);
        this.mealPlanService = mealPlanService;
        //Edit meal plan is not in service
    }

    /*--------------------
    deleteMealPlan()
    DELETE
    Path: /mealplan/{meal_plan_id}
    --------------------*/
    @DeleteMapping ("/mealplan/{mealplanId}")
    public void editMealPlan(@PathVariable("mealplanId") Long mealplanID) {
        this.mealPlanService = mealPlanService;
        //meal plan service delete is not in place
    }

    /*--------------------
    displayMealPlan()
    GET
    Path: /mealplan/{meal_plan_id}
    --------------------*/
    @GetMapping ("/mealplan/{mealplanId}")
    public void displayMealPlan(@PathVariable("mealplanId") Long mealplanID) {
        this.mealPlanService = mealPlanService;
        // get meal plan by ID is not in service
    }


}
