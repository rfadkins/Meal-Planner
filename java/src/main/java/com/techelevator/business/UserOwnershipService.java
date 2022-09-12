package com.techelevator.business;

import com.techelevator.exceptions.IngredientNotFoundException;
import com.techelevator.exceptions.UserNotFoundException;
import com.techelevator.model.Ingredient;
import com.techelevator.model.User;
import com.techelevator.repository.*;
import com.techelevator.util.BasicLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserOwnershipService {
    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private IngredientRepository ingredientRepository;
    @Autowired
    private MealRepository mealRepository;
    @Autowired
    private MealPlanRepository mealPlanRepository;


    //TODO test
    public Set<Ingredient> addIngredientToUserPantry(Long userId, Long ingredientId) {
        Set<Ingredient> pantry = new HashSet<>();
        User user = userRepository.findByUserId(userId);
        try {
            if (userRepository.findByUserId(userId) == null) {
                throw new UserNotFoundException();
            } else if (ingredientRepository.findByIngredientId(ingredientId) == null) {
                throw new IngredientNotFoundException();
            } else {
                user = userRepository.findByUserId(userId);
                Ingredient ingredient = ingredientRepository.findByIngredientId(ingredientId);

                pantry.add(ingredient);
                user.setUserPantry(pantry);

                userRepository.saveAndFlush(user);
            }
        } catch (Exception e) {
            BasicLogger.log(e.getMessage());
        }
        return pantry;
    }


    //TODO remove ing from pan
    public Set<Ingredient> removeIngredientFromUserPantry(Long userId, Long ingredientId) {
        Set<Ingredient> pantry = new HashSet<>();
        User user = userRepository.findByUserId(userId);
        try {
            if (userRepository.findByUserId(userId) == null) {
                throw new UserNotFoundException();
            } else if (ingredientRepository.findByIngredientId(ingredientId) == null) {
                throw new IngredientNotFoundException();
            } else {
                user = userRepository.findByUserId(userId);
                Ingredient ingredient = ingredientRepository.findByIngredientId(ingredientId);

                pantry.remove(ingredient);
                user.setUserPantry(pantry);

                userRepository.saveAndFlush(user);
            }
        } catch (Exception e) {
            BasicLogger.log(e.getMessage());
        }
        return pantry;
    }

    //todo list pantry
    Set<Ingredient> listUserPantry(Long userId) {
        Set<Ingredient> pantry = new HashSet<>();
        User user = userRepository.findByUserId(userId);
        try {
            if (userRepository.findByUserId(userId) == null) {
                throw new UserNotFoundException();
            } else {
                user = userRepository.findByUserId(userId);
                pantry = user.getUserPantry();
            }
        } catch (Exception e) {
            BasicLogger.log(e.getMessage());
        }
        return pantry;
    }

    //todo add user to meal

    //todo remove user from meal

    //todo display users meals

    //todo add user to meal plan

    //todo remove user from meal plan

    //todo list/display meal plan


}
