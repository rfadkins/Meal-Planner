package com.techelevator.exceptions;

public class UserSavedRecipeNotFoundException extends Exception {
    public UserSavedRecipeNotFoundException() {
        super("User saved recipe not found");
    }

}
