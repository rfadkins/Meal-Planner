package com.techelevator.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserSavedMealPlanNotFoundException extends Exception {
    public UserSavedMealPlanNotFoundException() {
        super("User saved meal plan not found");
    }

}
