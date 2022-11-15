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
public class IngredientController{
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


    @ResponseStatus(HttpStatus.OK)
    @PostMapping ("/")
    public ResponseEntity<Ingredient> createIngredient(@RequestBody Ingredient ingredient) {
        try {
            if (ingredient == null) {
                throw new IngredientNotFoundException();
            } else {
                return ResponseEntity.ok(ingredientService.createIngredient(ingredient.getIngredientName(), ingredient.getIngredientCategory()));
            }
        } catch(Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{ingredientId}")
    public ResponseEntity<Ingredient> getIngredient(@PathVariable("ingredientId") Long ingredientId) {
        try {
            Ingredient newIngredient = ingredientRepository.findByIngredientId(ingredientId);
            if (newIngredient == null) {
                throw new IngredientNotFoundException();
            }
            return ResponseEntity.ok(newIngredient);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/")
    public ResponseEntity<List<Ingredient>> listIngredients() {
        return ResponseEntity.ok(ingredientService.getAllIngredients());
    }


    @ResponseStatus(HttpStatus.OK)
    @PutMapping ("/{ingredientId}")
    public ResponseEntity<Ingredient> editIngredient(@PathVariable("ingredientId") Long ingredientId,
                                @RequestBody Ingredient ingredient) {
        try {
            Ingredient editedIngredient = ingredientRepository.findByIngredientId(ingredientId);
            if (editedIngredient == null) {
                throw new IngredientNotFoundException();
            } else if (ingredient == null) {
                throw new IngredientNotFoundException();
            } else {
                return ResponseEntity.ok(ingredientService.editIngredient(ingredientId,
                                                        ingredient.getIngredientName(),
                                                        ingredient.getIngredientCategory()));
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }


    @ResponseStatus(HttpStatus.OK)
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
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ingredient not found");
        }
        ingredientService.deleteIngredient(ingredientId);
    }
}



