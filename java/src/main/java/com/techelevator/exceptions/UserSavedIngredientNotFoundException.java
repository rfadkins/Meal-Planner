package com.techelevator.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
public class UserSavedIngredientNotFoundException extends Exception {
    public UserSavedIngredientNotFoundException() {
        super("User saved ingredient not found");
    }
}
