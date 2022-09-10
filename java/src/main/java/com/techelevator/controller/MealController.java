package com.techelevator.controller;

import com.techelevator.business.IngredientService;
import com.techelevator.business.MealService;
import com.techelevator.business.UserService;
import com.techelevator.model.Ingredient;
import com.techelevator.model.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//@PreAuthorize("isAuthenticated()")
public class MealController {
    //This controller handles the meal table

    UserService userService;
    MealService mealService;

    @Autowired
    public MealController(UserService userService, MealService mealService) {
        this.userService = userService;
        this.mealService = mealService;
    }

    /*--------------------
    createMeal()
    POST
    Path: /meal/
    --------------------*/
    @PostMapping("/meal/")
    public void createIngredient(@RequestBody Meal meal) {
        mealService.createMeal(meal.getMealName());
    }

    /*--------------------
    editMeal()
    PUT
    Path: /meal/{id}
    --------------------*/
    @PutMapping ("/meal/{mealId}")
    public String editMeal(@PathVariable("mealId") Long mealId) {
        //Need put / edit by meal ID in service
        return ("I have received a Put/Edit request for meal ID " + mealId + " but that is not implemented yet.");
    }

    /*--------------------
    deleteMeal()
    DELETE
    Path: /meal/{meal_id}
    --------------------*/
    @DeleteMapping ("/meal/{mealId}")
    public void createIngredient(@PathVariable("mealId") Long mealId) {
        mealService.deleteMeal(mealId);
    }

    /*--------------------
    displayMeal()
    GET
    Path: /meal/{meal_id}
    --------------------*/
    @GetMapping ("/meal/{mealId}")
    public String displayMeal(@PathVariable("mealId") Long mealId) {
        //Need Get by meal ID in service
        return ("I have received a get request for meal ID " + mealId + " but that is not implemented yet.");
    }


    /*--------------------
    List displayAllMeals()
    GET
    Path: /meal/
    --------------------*/
    @GetMapping ("/meal/")
    public String displayAllMeals() {
        //Need Get by meal ID in service
        return ("I have received a get request for all meals, but that is not implemented yet.");
    }




}