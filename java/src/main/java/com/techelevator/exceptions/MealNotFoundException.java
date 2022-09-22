package com.techelevator.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MealNotFoundException extends Exception {

    public MealNotFoundException() {
        super("Meal not found");
    }
}
