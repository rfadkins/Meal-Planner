package com.techelevator.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MealPlanNotFoundException extends Exception {
    public MealPlanNotFoundException() {
        super("Meal Plan not found");
    }
}

