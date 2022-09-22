package com.techelevator.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserSavedRecipeNotFoundException extends Exception {
    public UserSavedRecipeNotFoundException() {
        super("User saved recipe not found");
    }

}
