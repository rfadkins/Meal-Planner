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
@PreAuthorize("isAuthenticated()")
public class MealController {



    UserService userService;
    @Autowired
    MealService mealService;


    @Autowired
    public MealController(UserService userService, MealService mealService) {
        this.userService = userService;
        this.mealService = mealService;
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/meal/")
    public Meal createMeal(@RequestBody Meal meal) {
        return mealService.createMeal(meal.getMealName());
    }

    @GetMapping ("/meal/")
    public List<Meal> displayAllMeals() {
        return this.mealService.displayAllMeals();
    }


    @GetMapping ("/meal/{mealId}")
    public Meal displayMeal(@PathVariable("mealId") Long mealId) {
        return this.mealService.displayMeal(mealId);
    }


    @PutMapping ("/meal/{mealId}")
    public void editMeal(@PathVariable("mealId") Long mealId,
                        @RequestBody Meal meal) {
        mealService.editMeal(mealId, meal.getMealName());
    }


    @DeleteMapping ("/meal/{mealId}")
    public String deleteMeal(@PathVariable("mealId") Long mealId) {
        return this.mealService.deleteMeal(mealId);
    }







}