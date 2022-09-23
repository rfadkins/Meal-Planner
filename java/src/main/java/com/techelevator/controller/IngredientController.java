package com.techelevator.controller;

import com.techelevator.business.IngredientService;
import com.techelevator.business.UserService;
import com.techelevator.exceptions.IngredientNotFoundException;
import com.techelevator.model.Ingredient;
import com.techelevator.repository.IngredientRepository;
import com.techelevator.security.jwt.JWTFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/ingredient")
@PreAuthorize("isAuthenticated()")
public class IngredientController extends IngredientService{
    //This controller handles the Ingredient table

    UserService userService;
    @Autowired
    IngredientService ingredientService;
    @Autowired
    IngredientRepository ingredientRepository;


    @Autowired
    public IngredientController(
            UserService userService,
            IngredientService ingredientService) {
        this.userService = userService;
        this.ingredientService = ingredientService;
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping ("/")
    public Ingredient createIngredient(@RequestBody Ingredient ingredient) {
        this.ingredientService = ingredientService;
        return this.ingredientService.createIngredient(ingredient.getIngredientName(), ingredient.getIngredientCategory());
    }


    @GetMapping("/{ingredientId}")
    public Ingredient getIngredient(@PathVariable("ingredientId") Long ingredientId) {
        try {
            Ingredient newIngredient = ingredientRepository.findByIngredientId(ingredientId);
            if (newIngredient == null) {
                throw new IngredientNotFoundException();
            }
            return newIngredient;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ingredient not found", e);
        }
    }



    @GetMapping("/")
    public List<Ingredient> listIngredients() {
        return ingredientService.getAllIngredients();
    }


    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping ("/{ingredientId}")
    public Ingredient editIngredient(@PathVariable("ingredientId") Long ingredientId,
                                @RequestBody Ingredient ingredient) {
        try {
            Ingredient editedIngredient = ingredientRepository.findByIngredientId(ingredientId);
            if (editedIngredient == null) {
                throw new IngredientNotFoundException();
            } else if (ingredient == null) {
                throw new IngredientNotFoundException();
            } else {
                return ingredientService.editIngredient(ingredientId,
                                                        ingredient.getIngredientName(),
                                                        ingredient.getIngredientCategory());
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ingredient not found", e);
        }
    }


    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping ("/{ingredientId}")
    public void deleteIngredient(@PathVariable("ingredientId") Long ingredientId) {
        try {
            Ingredient deletedIngredient = ingredientRepository.findByIngredientId(ingredientId);
            if (deletedIngredient == null) {
                throw new IngredientNotFoundException();
            } else {
                ingredientService.deleteIngredient(ingredientId);
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ingredient not found", e);
        }
        ingredientService.deleteIngredient(ingredientId);
    }
}




//old code - may still be needed :)


//        HttpHeaders httpHeaders = new HttpHeaders();
//        //httpHeaders.add(JWTFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);
//
//        httpHeaders.add("Access-Control-Allow-Origin:","*");
//        return new ResponseEntity<List<Ingredient>>(ingredientService.getAllIngredients(), httpHeaders, HttpStatus.OK);




