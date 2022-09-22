package com.techelevator.controller;

import com.techelevator.business.IngredientService;
import com.techelevator.business.MealPlanMealService;
import com.techelevator.business.MealService;
import com.techelevator.business.UserService;
import com.techelevator.model.Ingredient;
import com.techelevator.model.MealPlan;
import com.techelevator.model.MealsInMealPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//@PreAuthorize("isAuthenticated()")
public class mealPlan_MealController{
    //This controller handles join tables related to meals in meal plans

    //Uncomment when MealPlanMealService is implemented
    UserService userService;
    MealPlanMealService mealPlanMealService;

    @Autowired
    public void MealPlanMealController(UserService userService, MealPlanMealService mealPlanMealService) {
        this.userService = userService;
        this.mealPlanMealService = mealPlanMealService;
    }
    /*--------------------
    addMealtoMealPlan()
    POST
    meal/meaplan/{meal_id}/{mealplan_id}
    --------------------*/

    @PostMapping ("/meal/mealplan/{mealId}/{mealPlanId}/")
    public MealsInMealPlan addMealToMealPlan(
                        @PathVariable("mealId") Long mealId,
                        @PathVariable("mealPlanId") Long mealPlanId,
            @RequestParam int mealOrder ) {
        return this.mealPlanMealService.addMealToMealPlan(mealId, mealPlanId, mealOrder );

    }

    /*--------------------
    removeMealFromMealPlan()
    DELETE
    meal/meaplan/{meal_id}/{mealplan_id}
    --------------------*/

//    @DeleteMapping("/meal/mealplan/{mealId}/{mealPlanId}")
//    public void removeMealFromMealPlan(@PathVariable("mealId") Long mealId, @PathVariable("mealPlanId") Long mealPlanId) {
//       mealPlanMealService.removeMealsFromMealPlan(mealPlanId,mealId);
//    }

}