package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MealDTO {

    @JsonProperty("meal_id")
    private Long mealId;

    @JsonProperty("meal_name")
    private String mealName;

    public Long getMealId() {
        return mealId;
    }

    public void setMealId(Long mealId) {
        this.mealId = mealId;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }
}
