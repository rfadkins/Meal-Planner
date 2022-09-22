package com.techelevator.exceptions;

public class UserSavedMealPlanNotFoundException extends Exception {
    public UserSavedMealPlanNotFoundException() {
        super("User saved meal plan not found");
    }

}
