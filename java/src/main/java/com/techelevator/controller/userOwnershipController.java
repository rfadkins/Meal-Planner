package com.techelevator.controller;

import com.techelevator.business.IngredientService;
import com.techelevator.business.MealService;
import com.techelevator.business.UserOwnershipService;
import com.techelevator.business.UserService;
import com.techelevator.model.Ingredient;
import com.techelevator.model.Meal;
import com.techelevator.model.MealPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin
//@PreAuthorize("isAuthenticated()")
public class userOwnershipController{
    //This controller handles join tables related to user ownership

    @Autowired
    UserService userService;
    @Autowired
    UserOwnershipService userOwnershipService;

    @Autowired
    public void UserOwnershipController (UserService userService, UserOwnershipService userOwnershipService) {
        this.userService = userService;
        this.userOwnershipService = userOwnershipService;
    }

    //------------------------------PANTRY------------------------------


//    /*--------------------
//    addIngredientToPantry()
//    POST
//    /pantry/{user_id}/{ingredient_id}
//    --------------------*/
//
//    //This was not working when tested
//    @PostMapping ("/pantry/{userId}/{ingredientId}")
//    public void addIngredientToPantry(@PathVariable ("userId") Long userId, @PathVariable ("ingredientId") Long ingredientId) {
//       userOwnershipService.addIngredientToUserPantry(userId,ingredientId);
//    }
//
//    /*--------------------
//    removeIngredientFromPantry()
//    DELETE
//    pantry/recipe/{user_id}/{ingredient_id}
//    --------------------*/
//
//    @DeleteMapping ("/pantry/{userId}/{ingredientId}")
//    public void removeIngredientFromPantry(@PathVariable ("userId") Long userId, @PathVariable ("ingredientId") Long ingredientId) {
//        userOwnershipService.removeIngredientFromUserPantry(userId,ingredientId);
//    }
//
//    /*--------------------
//    List listUserPantry()
//    GET
//    pantry/user/{user_id}
//    --------------------*/
////    @GetMapping ("/pantry/user/{userId}")
////    public Set<Ingredient> listUserPantry(@PathVariable ("userId") Long userId) {
////        return userOwnershipService.listUserPantry(userId);
////    }
//
//
//    //------------------------------MEAL------------------------------
//
//
//    /*--------------------
//    addMealToUser()
//    POST
//    /meal/user/{user_id}/{meal_id}
//    --------------------*/
//    @PostMapping ("/meal/user/{userId}/{mealId}")
//    public void addMealToUser(@PathVariable("userId") Long userId, @PathVariable("mealId") Long mealId) {
//       userOwnershipService.addMealToUser(userId, mealId);
//
//    }
//
//
//    /*--------------------
//    removeMealFromUser()
//    DELETE
//    meal/user/{user_id}/{meal_id}
//    --------------------*/
//    @DeleteMapping ("/meal/user/{userId}/{mealId}")
//    public void removeMealFromUser(@PathVariable("userId") Long userId, @PathVariable("mealId") Long mealId) {
//        userOwnershipService.removeMealFromUser(userId,mealId);
//    }
//
//    /*--------------------
//    LIST displayMyMeals
//    GET
//    /meal/user/{user_id}
//    --------------------*/
//    @GetMapping ("/meal/user/{userId}")
//    public Set<Meal> displayMyMeals(@PathVariable ("userId") Long userId) {
//        return userOwnershipService.listUserMeals(userId);
//    }
//
//
//    //------------------------------MEAL PLAN------------------------------
//
//    /*--------------------
//    addUserToMealPlan()
//    PUT
//    mealplan/user/{user_id}/{meal_plan_id}
//    --------------------*/
//    @PostMapping ("/mealplan/user/{userId}/{mealplanId}")
//    public void addUserToMealPlan(@PathVariable("userId") Long userId, @PathVariable("mealplanId") Long mealPlanId) {
//        userOwnershipService.addMealPlanToUser(userId,mealPlanId);
//    }
//
//
//    /*--------------------
//    removeUserFromMealPlan()
//    DELETE
//    mealplan/user/{meal_plan_id}/{user_id}
//    --------------------*/
//    @DeleteMapping ("/mealplan/user/{userId}/{mealplanId}")
//    public void removeUserFromMealPlan(@PathVariable("userId") Long userId, @PathVariable("mealplanId") Long mealPlanId) {
//        userOwnershipService.removeMealPlanFromUser(userId,mealPlanId);
//    }
//
//    /*--------------------
//    LIST displayMyMealPlans()
//    GET
//    /mealplan/user/{user_id}
//    --------------------*/
//    @GetMapping ("/mealplan/user/{userId}")
//    public Set<MealPlan> displayMyMealPlans(@PathVariable ("userId") Long userId) {
//        return userOwnershipService.listUserMealPlans(userId);
//
//    }
//
//





}