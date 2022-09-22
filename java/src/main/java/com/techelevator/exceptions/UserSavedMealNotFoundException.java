package com.techelevator.exceptions;

public class UserSavedMealNotFoundException extends Exception {
    public UserSavedMealNotFoundException() {
        super("User saved meal not found");
    }

}
