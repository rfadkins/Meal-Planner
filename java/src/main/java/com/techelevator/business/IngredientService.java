package com.techelevator.business;

import com.techelevator.exceptions.*;
import com.techelevator.model.*;
import com.techelevator.repository.*;
import com.techelevator.util.BasicLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IngredientService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    IngredientRepository ingredientRepository;
    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private RecipeService recipeService;



    public Ingredient createIngredient(String name, String category) {
        Ingredient ingredient = new Ingredient();
        try {
            if (name == null) {
                throw new IngredientNotFoundException();
            } else {
                ingredient.setIngredientName(name);
                ingredient.setIngredientCategory(category);
                ingredientRepository.saveAndFlush(ingredient);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ingredient;
    }


    public Ingredient getIngredientById (Long ingredientId) {
        Ingredient ingredient = ingredientRepository.findByIngredientId(ingredientId);
        try {
            if (ingredient == null) {
                throw new IngredientNotFoundException();
            }
        } catch (Exception e) {
            BasicLogger.log(e.getMessage());
        }
        return ingredient;
    }


    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }


    public Ingredient editIngredient(Long ingredientId, String newName, String newCategory) {
        Ingredient ingredient = ingredientRepository.findByIngredientId(ingredientId);
        ingredient.setIngredientName(newName);
        ingredient.setIngredientCategory(newCategory);
        ingredientRepository.saveAndFlush(ingredient);
        return ingredient;
    }


    public void deleteIngredient(Long ingredientId) {
        Ingredient ingredient = ingredientRepository.findByIngredientId(ingredientId);
        try {
            if (ingredient == null) {
                throw new IngredientNotFoundException();
            } else {
                ingredientRepository.deleteById(ingredientId);
            }
        } catch (Exception e) {
            BasicLogger.log(e.getMessage());
        }
    }


    //TODO grocery list logic...

}
