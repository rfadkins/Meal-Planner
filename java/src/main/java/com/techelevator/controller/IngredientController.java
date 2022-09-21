package com.techelevator.controller;

import com.techelevator.business.IngredientService;
import com.techelevator.business.UserService;
import com.techelevator.model.Ingredient;
import com.techelevator.security.jwt.JWTFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/ingredient")
//@PreAuthorize("isAuthenticated()")
public class IngredientController extends IngredientService{
    //This controller handles the Ingredient table

    UserService userService;
    @Autowired
    IngredientService ingredientService;


    @Autowired
    public IngredientController(UserService userService, IngredientService ingredientService) {
        this.userService = userService;
        this.ingredientService = ingredientService;
    }


    /*--------------------
    createIngredient()
    POST
    PATH: /ingredient/
    --------------------*/
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping ("/")
    public Ingredient createIngredient(@RequestBody Ingredient ingredient) {
        this.ingredientService = ingredientService;
        return this.ingredientService.createIngredient(ingredient.getIngredientName(), ingredient.getIngredientCategory());
    }


    /*--------------------
    editIngredient()
    PUT
    PATH: /ingredient/{ingredient_id}
    --------------------*/
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping ("/{ingredientId}")
    public void editIngredient(@PathVariable("ingredientId") Long ingredientId, @RequestBody Ingredient ingredient) {
        //Ingredient ingredient = mapper.mapIngredientDTOToEntity(ingredientDTO);
        ingredientService.editIngredient(ingredientId, ingredient.getIngredientName(), ingredient.getIngredientCategory());
    }


//    /*--------------------
//    deleteIngredient()
//    DELETE
//    PATH: /ingredient/{ingredient_id}
//    --------------------*/
    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping ("/{ingredientId}")
    public void deleteIngredient(@PathVariable("ingredientId") Long ingredientId) {
        ingredientService.deleteIngredient(ingredientId);
    }

//    /*--------------------
//    getIngredient()
//    GET
//    PATH: /Ingredient/{Ingredient_id}
//    --------------------*/
    @GetMapping("/{ingredientId}")
    public com.techelevator.model.Ingredient getIngredient(@PathVariable("ingredientId") Long ingredientId) {
        return ingredientService.getIngredientById(ingredientId);
    }

//    /*--------------------
//    List listIngredients()
//    GET
//    PATH: /Ingredient/
//    --------------------*/
    @GetMapping("/")
    public List<Ingredient> listIngredients() {

        return ingredientService.getAllIngredients();

    }






}




//old code - may still be needed :)


//        HttpHeaders httpHeaders = new HttpHeaders();
//        //httpHeaders.add(JWTFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);
//
//        httpHeaders.add("Access-Control-Allow-Origin:","*");
//        return new ResponseEntity<List<Ingredient>>(ingredientService.getAllIngredients(), httpHeaders, HttpStatus.OK);





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


