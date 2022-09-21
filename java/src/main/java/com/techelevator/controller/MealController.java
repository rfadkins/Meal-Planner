package com.techelevator.controller;

import com.techelevator.business.MealService;
import com.techelevator.business.UserService;

import com.techelevator.model.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
//@PreAuthorize("isAuthenticated()")
public class MealController {
    //This controller handles the meal table

    UserService userService;
    @Autowired
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
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/meal/")
    public Meal createMeal(@RequestBody Meal meal) {
        //Meal meal = mapper.mapMealDTOToEntity(mealDTO);
        return mealService.createMeal(meal.getMealName());
    }


    /*--------------------
    editMeal()
    PUT
    Path: /meal/{id}
    --------------------*/
    @PutMapping ("/meal/{mealId}")
    public void editMeal(@PathVariable("mealId") Long mealId, @RequestBody Meal meal) {
        //Meal meal = mapper.mapMealDTOToEntity(mealDTO);
        mealService.editMeal(mealId, meal.getMealName());
    }

    /*--------------------
    deleteMeal()
    DELETE
    Path: /meal/{meal_id}
    --------------------*/
    @DeleteMapping ("/meal/{mealId}")
    public void deleteMeal(@PathVariable("mealId") Long mealId) {
        mealService.deleteMeal(mealId);
    }

    /*--------------------
    displayMeal()
    GET
    Path: /meal/{meal_id}
    --------------------*/
    @GetMapping ("/meal/{mealId}")
    public Meal displayMeal(@PathVariable("mealId") Long mealId) {
        return mealService.displayMeal(mealId);
    }


    /*--------------------
    List displayAllMeals()
    GET
    Path: /meal/
    --------------------*/
    @GetMapping ("/meal/")
    public List<Meal> displayAllMeals() {
        return mealService.displayAllMeals();
    }


}