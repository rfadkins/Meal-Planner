package com.techelevator.controller;

import com.techelevator.business.IngredientService;
import com.techelevator.business.MealService;
import com.techelevator.business.UserService;
import com.techelevator.datatransfer.IngredientDTO;
import com.techelevator.datatransfer.MealDTO;
import com.techelevator.model.Ingredient;
import com.techelevator.model.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import com.techelevator.datatransfer.Mapper;
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
    Mapper mapper;

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
    public void createIngredient(@RequestBody MealDTO mealDTO) {
        Meal meal = mapper.mapMealDTOToEntity(mealDTO);
        mealService.createMeal(mealDTO.getMealName());
    }


    /*--------------------
    editMeal()
    PUT
    Path: /meal/{id}
    --------------------*/
    @PutMapping ("/meal/{mealId}")
    public String editMeal(@PathVariable("mealId") Long mealId, @RequestBody MealDTO mealDTO) {
        Meal meal = mapper.mapMealDTOToEntity(mealDTO);
        // mealService.editMeal(Meal); Did not ask for Meal ID?
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