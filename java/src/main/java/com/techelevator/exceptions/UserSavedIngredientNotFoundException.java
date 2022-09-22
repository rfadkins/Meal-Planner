package com.techelevator.exceptions;

public class UserSavedIngredientNotFoundException extends Exception {
    public UserSavedIngredientNotFoundException() {
        super("User saved ingredient not found");
    }
}
