package com.techelevator.business;

import com.techelevator.exceptions.IngredientNotFoundException;
import com.techelevator.exceptions.UserNotFoundException;
import com.techelevator.model.Ingredient;
import com.techelevator.model.User;
import com.techelevator.repository.IngredientRepository;
import com.techelevator.repository.UserRepository;
import com.techelevator.util.BasicLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserPantryService {

    @Autowired
    IngredientRepository ingredientRepository;

    @Autowired
    UserRepository userRepository;


    public Map<Long, Ingredient> addIngredientToUserPantry(Long userId, Long ingredientId) {
        Map<Long, Ingredient> userPantryStock = new HashMap<>();
        try {
            if (ingredientRepository.findByIngredientId(ingredientId) == null) {
                throw new IngredientNotFoundException();
            } else {
                userPantryStock.put(ingredientId, ingredientRepository.findByIngredientId(ingredientId));
            }
        } catch (Exception e) {
            BasicLogger.log(e.getMessage());
        }
        return userPantryStock;
    }


/*
**** DID NOT TEST - GET
 */
//    public Map<Long, Ingredient> getIngredientsInUserPantry(Long userId) {
//        Map<Long, Ingredient> userPantryStock = new HashMap<>();
//
//        try {
//            if(userRepository.findByUserId(userId) == null) {
//                throw new UserNotFoundException();
//            } else {
//                userPantryStock = ingredientRepository.findAllByUserId(userId);
//            }
//        } catch (Exception e) {
//            BasicLogger.log(e.getMessage());
//        }
//        return userPantryStock;
//    }



}
