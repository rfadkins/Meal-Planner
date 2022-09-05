package com.techelevator.controller;

import com.techelevator.business.IngredientService;
import com.techelevator.business.UserService;
import com.techelevator.model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IngredientController {
    //This controller handles the Indredient table

    /*--------------------
    createIngredient()
    POST
    PATH: /ingredient/
    --------------------*/


    /*--------------------
    editIngredient()
    PUT
    PATH: /ingredient/{ingredient_id}
    --------------------*/


    /*--------------------
    deleteIngredient()
    DELETE
    PATH: /ingredient/{ingredient_id}
    --------------------*/


    /*--------------------
    getIngredient()
    GET
    PATH: /Ingredient/{Ingredient_id}
    --------------------*/


    /*--------------------
    List listIngredients()
    GET
    PATH: /Ingredient/
    --------------------*/



}




    //old code - may still be needed :)

    /*UserService userService;
    IngredientService ingredientService;

    @Autowired
    public IngredientController(UserService userService, IngredientService ingredientService) {
        this.userService = userService;
        this.ingredientService = ingredientService;
    }

    //Creats an infgredient

    @PostMapping("/ingredient")
    public Ingredient createIngredient(String name, String category) {
        return ingredientService.createIngredient(name, category);
    }*/

    //Edit an ingredient

    //Remove an ingredient


