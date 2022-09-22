package com.techelevator.controller;

import com.techelevator.business.IngredientService;
import com.techelevator.business.MealService;
import com.techelevator.business.UserOwnershipService;
import com.techelevator.business.UserService;
import com.techelevator.exceptions.UserNotFoundException;
import com.techelevator.exceptions.UserSavedIngredientNotFoundException;
import com.techelevator.model.*;
import com.techelevator.repository.UserSavedIngredientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class userOwnershipController{


    @Autowired
    UserService userService;
    @Autowired
    UserOwnershipService userOwnershipService;
    @Autowired
    UserSavedIngredientsRepository userSavedIngredientsRepository;



    @Autowired
    public void UserOwnershipController (UserService userService, UserOwnershipService userOwnershipService) {
        this.userService = userService;
        this.userOwnershipService = userOwnershipService;
    }

    //------------------------------USER STUFF------------------------------

    @GetMapping("/user/id/{userId}")
    public User getUserById(@PathVariable("userId") Long userId) {
        return userService.findByUserId(userId);
    }

    @GetMapping("/user/username/{userName}")
    public User getUserByUsername(@PathVariable("userName") String userName) {
        return userService.findByUsername(userName);
    }

    @GetMapping("/user")
    public List<User> getAllUsers() {
        return userService.listAllUsers();
    }



    //------------------------------INGREDIENT /  PANTRY------------------------------

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping ("/user/pantry/{userId}/{ingredientId}")
    public UserSavedIngredients addIngredientToPantry(@PathVariable ("userId") Long userId,
                                                        @PathVariable ("ingredientId") Long ingredientId) {
        try {
            User user = userService.findByUserId(userId);
            if (user == null){
                throw new UserNotFoundException();
            } else {
                return userOwnershipService.addIngredientToUserPantry(userId, ingredientId);
            }
        } catch (Exception e) {

            e.getMessage();
            return null;
        }

    }

    @DeleteMapping ("/user/pantry/{userSavedIngredientsId}")
    public String deleteIngredientFromUserPantry(@PathVariable ("userSavedIngredientsId") Long userSavedIngredientsId) {
        return this.userOwnershipService.deleteIngredientFromUserPantry(userSavedIngredientsId);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping ("/user/pantry/{userId}")
    public List<UserSavedIngredients> listUserPantry(@PathVariable ("userId") Long userId) {
        try {
            List<UserSavedIngredients> userSavedIngredients = userSavedIngredientsRepository.findAllByUser
                                                                        (userService.findByUserId(userId));
            if (userSavedIngredients == null){
                throw new UserSavedIngredientNotFoundException();
            } else {
                return this.userOwnershipService.displayUserPantry(userId);
            }
        } catch(Exception e) {
            e.getMessage();
            return null;
        }
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

    @DeleteMapping ("/user/meal/{userId}/{mealId}")
    public String removeMealFromUser(@PathVariable("userSavedMealId") Long userSavedMealId) {
        return this.userOwnershipService.deleteUserSavedMeal(userSavedMealId);
    }

    @GetMapping ("/user/meal/{userId}")
    public List<UserSavedMeals> displayMyMeals(@PathVariable ("userId") Long userId) {
        return userOwnershipService.displayUserSavedMeals(userId);
    }



    //------------------------------MEAL PLAN------------------------------


    @PostMapping ("/user/mealplan/{userId}/{mealplanId}")
    public UserSavedMealPlans addUserToMealPlan(@PathVariable("userId") Long userId,
                                                @PathVariable("mealplanId") Long mealPlanId) {
        return this.userOwnershipService.addMealPlanToUser(userId,mealPlanId);
    }

    @DeleteMapping ("/user/mealplan/{userSavedMealPlansId}")
    public String removeMealPlanFromUser(@PathVariable("userSavedMealPlansId") Long userSavedMealPlansId) {
        return this.userOwnershipService.removeMealPlanFromUser(userSavedMealPlansId);
    }

    @GetMapping ("/user/mealplan/{userId}")
    public List<UserSavedMealPlans> displayMyMealPlans(@PathVariable ("userId") Long userId) {
        return userOwnershipService.displayUserSavedMealPlans(userId);
    }


}