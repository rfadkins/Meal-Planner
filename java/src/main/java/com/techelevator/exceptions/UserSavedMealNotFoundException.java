package com.techelevator.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserSavedMealNotFoundException extends Exception {
    public UserSavedMealNotFoundException() {
        super("User saved meal not found");
    }

}
