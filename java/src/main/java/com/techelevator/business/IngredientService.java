package com.techelevator.business;

import com.techelevator.exceptions.IngredientNotFoundException;
import com.techelevator.exceptions.UserNotFoundException;
import com.techelevator.model.Ingredient;
import com.techelevator.model.User;
import com.techelevator.repository.IngredientRepository;
import com.techelevator.repository.UserRepository;
import com.techelevator.util.BasicLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class IngredientService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private IngredientRepository ingredientRepository;
    private final RestTemplate restTemplate = new RestTemplate();
    private String authToken;

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }



    public Ingredient createIngredient(String name, String category) {
        Ingredient ingredient = new Ingredient();

        ingredient.setIngredientName(name);
        ingredient.setIngredientCategory(category);

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

    public Map<Long, Ingredient> addIngredientToUserPantry(Long userId, Long ingredientId) {
        Map<Long, Ingredient> pantry = new HashMap<>();
        try {
            if (userRepository.findByUserId(userId) == null) {
                throw new UserNotFoundException();
            } else if (ingredientRepository.findByIngredientId(ingredientId) == null) {
                throw new IngredientNotFoundException();
            } else {
                User user = userRepository.findByUserId(userId);
                Ingredient ingredient = ingredientRepository.findByIngredientId(ingredientId);

                pantry.put(user.getUserId(), ingredient);

                user.setUserPantry(pantry);
                userRepository.save(user);
            }
        } catch (Exception e) {
            BasicLogger.log(e.getMessage());
        }
        return pantry;
    }

    public Map<Long, Ingredient> deleteIngredientFromUserPantry(Long userId, Long ingredientId) {
        Map<Long, Ingredient> pantry = new HashMap<>();
        try {
            if (userRepository.findByUserId(userId) == null) {
                throw new UserNotFoundException();
            } else if (ingredientRepository.findByIngredientId(ingredientId) == null) {
                throw new IngredientNotFoundException();
            } else {
                User user = userRepository.findByUserId(userId);
                Ingredient ingredient = ingredientRepository.findByIngredientId(ingredientId);

                pantry = user.getUserPantry();
                pantry.remove(user.getUserId(), ingredient);

                user.setUserPantry(pantry);
                userRepository.save(user);

                return pantry;
            }
        } catch (Exception e) {
            BasicLogger.log(e.getMessage());
        }
        return pantry;
    }
}
