package com.techelevator.controller;

import com.techelevator.business.IngredientService;
import com.techelevator.business.MealService;
import com.techelevator.business.UserOwnershipService;
import com.techelevator.business.UserService;
import com.techelevator.model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//@PreAuthorize("isAuthenticated()")
public class userOwnershipController{
    //This controller handles join tables related to user ownership

    UserService userService;
    UserOwnershipService userOwnershipService;
    MealService mealService;

    @Autowired
    public void UserOwnershipController (UserService userService, UserOwnershipService userOwnershipService, MealService mealService) {
        this.userService = userService;
        this.userOwnershipService = userOwnershipService;
        this.mealService = mealService;
    }

    //------------------------------PANTRY------------------------------


    /*--------------------
    addIngredientToPantry()
    POST
    /pantry/{user_id}/{ingredient_id}
    --------------------*/

    //This was not working when tested
    @PostMapping ("/pantry/{userId}/{ingredientId}")
    public String addIngredientToPantry(@PathVariable ("userId") Long userId, @PathVariable ("ingredientId") Long ingredientId) {
       /* System.out.println(userId + " " + ingredientId);
        userPantryService.addIngredientToUserPantry(userId, ingredientId);*/
        return("Post received for " +userId+"/"+ingredientId + " but addingredienttopantry isn't working right now (exists but didn't work at last test)");
    }

    /*--------------------
    removeIngredientFromPantry()
    DELETE
    pantry/recipe/{user_id}/{ingredient_id}
    --------------------*/

    @DeleteMapping ("/pantry/{userId}/{ingredientId}")
    public String removeIngredientFromPantry(@PathVariable ("userId") Long userId, @PathVariable ("ingredientId") Long ingredientId) {
        return("Delete received for " +userId+"/"+ingredientId + " but removeingredientfrompantry isn't working right now (exists but didn't work at last test)");
    }

    /*--------------------
    List listUserPantry()
    GET
    pantry/user/{user_id}
    --------------------*/
    @GetMapping ("/pantry/user/{userId}")
    public String listUserPantry(@PathVariable ("userId") Long userId) {

        return("Get received for " +userId +" but listuserpantry isn't working right now (exists but didn't work at last test)");
    }


    //------------------------------MEAL------------------------------


    /*--------------------
    addMealToUser()
    POST
    /meal/user/{user_id}
    --------------------*/
    @PostMapping ("/meal/user/{userId}")
    public String addMealToUser(@PathVariable("userId") Long userId) {
        return("Post Received for "+ userId+ " though addmealtouser is not implemented yet.");
    }


    /*--------------------
    removeMealFromUser()
    DELETE
    meal/user/{user_id}/{meal_id}
    --------------------*/
    @DeleteMapping ("/meal/user/{userId}/{mealId}")
    public String removeMealFromUser(@PathVariable("userId") Long userId, @PathVariable("mealId") Long mealId) {
        return("Delete Received for "+ userId+ "/"+mealId+" though removemealfromuser is not implemented yet.");
    }

    /*--------------------
    LIST displayMyMeals
    GET
    /meal/user/{user_id}
    --------------------*/
    @GetMapping ("/meal/user/{userId}")
    public String displayMyMeals(@PathVariable ("userId") Long userId) {
        return("Get received for " +userId +" but displaymyeals isn't working right now (exists but didn't work at last test)");
    }


    //------------------------------MEAL PLAN------------------------------

    /*--------------------
    addUserToMealPlan()
    PUT
    mealplan/user/{user_id}/{meal_plan_id}
    --------------------*/
    @PostMapping ("/mealplan/user/{userId}/{mealplanId}")
    public String addUserToMealPlan(@PathVariable("userId") Long userId, @PathVariable("mealplanId") Long mealPlanId) {
        return("Post Received for "+ userId + "/" + mealPlanId + " though addusertomealplan is not implemented yet.");
    }


    /*--------------------
    removeUserFromMealPlan()
    DELETE
    mealplan/user/{meal_plan_id}/{user_id}
    --------------------*/
    @DeleteMapping ("/mealplan/user/{userId}/{mealplanId}")
    public String removeUserFromMealPlan(@PathVariable("userId") Long userId, @PathVariable("mealplanId") Long mealPlanId) {
        return("Delete Received for "+ userId + "/" + mealPlanId + " though removeuserfrommealplan is not implemented yet.");
    }

    /*--------------------
    LIST displayMyMealPlans()
    GET
    /mealplan/user/{user_id}
    --------------------*/
    @GetMapping ("/mealplan/user/{userId}")
    public String displayMyMealPlans(@PathVariable ("userId") Long userId) {
        return("Get received for " +userId +" but displaymymealplans isn't working right now (exists but didn't work at last test)");
    }








}