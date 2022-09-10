package com.techelevator.exceptions;

public class MealPlanNotFoundException extends Exception {
    public MealPlanNotFoundException() {
        super("Meal Plan not found");
    }
}

