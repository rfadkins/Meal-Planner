package com.techelevator.controller;

import com.techelevator.business.IngredientService;
import com.techelevator.business.MealService;
import com.techelevator.business.UserOwnershipService;
import com.techelevator.business.UserService;
import com.techelevator.model.*;
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

    //------------------------------USER STUFF------------------------------

    @GetMapping("/user/{userId}")
    public User getUserById(@PathVariable("userId") Long userId) {
        return userService.findByUserId(userId);
    }

    @GetMapping("/user/{userName}")
    public User getUserByUsername(@PathVariable("userName") String userName) {
        return userService.findByUsername(userName);
    }

    @GetMapping("/user")
    public List<User> getAllUsers() {
        return userService.listAllUsers();
    }



    //------------------------------INGREDIENT /  PANTRY------------------------------


    @PostMapping ("/user/pantry/{userId}/{ingredientId}")
    public UserSavedIngredients addIngredientToPantry(@PathVariable ("userId") Long userId,
                                                        @PathVariable ("ingredientId") Long ingredientId) {
        return this.userOwnershipService.addIngredientToUserPantry(userId,ingredientId);
    }

    @DeleteMapping ("/user/pantry/{userSavedIngredientsId}")
    public String deleteIngredientFromUserPantry(@PathVariable ("userSavedIngredientsId") Long userSavedIngredientsId) {
        return this.userOwnershipService.deleteIngredientFromUserPantry(userSavedIngredientsId);
    }

    @GetMapping ("/user/pantry/{userId}")
    public List<UserSavedIngredients> listUserPantry(@PathVariable ("userId") Long userId) {
        return this.userOwnershipService.displayUserPantry(userId);
    }



    //------------------------------RECIPE------------------------------


    @PostMapping ("/user/recipe/{userId}/{recipeId}")
    public UserSavedRecipes addRecipeToUser(@PathVariable ("userId") Long userId,
                                            @PathVariable ("recipeId") Long recipeId) {
        return this.userOwnershipService.addRecipeToUser(userId,recipeId);
    }

    @DeleteMapping ("/user/recipe/{userSavedRecipesId}")
    public String deleteRecipeFromUser(@PathVariable ("userSavedRecipesId") Long userSavedRecipesId) {
        return this.userOwnershipService.deleteUserSavedRecipe(userSavedRecipesId);
    }

    @GetMapping ("/user/recipe/{userId}")
    public List<UserSavedRecipes> listUserRecipes(@PathVariable ("userId") Long userId) {
        return this.userOwnershipService.displayUserSavedRecipes(userId);
    }



    //------------------------------MEAL------------------------------


    @PostMapping ("/user/meal/{userId}/{mealId}")
    public UserSavedMeals addMealToUser(@PathVariable("userId") Long userId,
                                        @PathVariable("mealId") Long mealId) {
        return this.userOwnershipService.addMealToUser(userId, mealId);
    }

    @DeleteMapping ("/meal/user/{userId}/{mealId}")
    public void removeMealFromUser(@PathVariable("userSavedMealId") Long userSavedMealId) {
        userOwnershipService.deleteUserSavedMeal(userSavedMealId);
    }

    @GetMapping ("/meal/user/{userId}")
    public List<UserSavedMeals> displayMyMeals(@PathVariable ("userId") Long userId) {
        return userOwnershipService.displayUserSavedMeals(userId);
    }



    //------------------------------MEAL PLAN------------------------------


    @PostMapping ("/user/mealplan/{userId}/{mealplanId}")
    public UserSavedMealPlans addUserToMealPlan(@PathVariable("userId") Long userId,
                                                @PathVariable("mealplanId") Long mealPlanId) {
        return this.userOwnershipService.addMealPlanToUser(userId,mealPlanId);
    }

    @DeleteMapping ("/mealplan/user/{userSavedMealPlansId}")
    public String removeMealPlanFromUser(@PathVariable("userSavedMealPlansId") Long userSavedMealPlansId) {
        return this.userOwnershipService.removeMealPlanFromUser(userSavedMealPlansId);
    }

    @GetMapping ("/mealplan/user/{userId}")
    public List<UserSavedMealPlans> displayMyMealPlans(@PathVariable ("userId") Long userId) {
        return userOwnershipService.displayUserSavedMealPlans(userId);
    }


}