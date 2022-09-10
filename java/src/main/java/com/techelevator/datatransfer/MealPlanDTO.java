package com.techelevator.datatransfer;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MealPlanDTO {

    @JsonProperty("mealPlanId")
    private Long mealPlanId;

    @JsonProperty("mealPlanName")
    private String mealPlanName;

    public Long getMealPlanId() {
        return mealPlanId;
    }

    public void setMealPlanId(Long mealPlanId) {
        this.mealPlanId = mealPlanId;
    }

    public String getMealPlanName() {
        return mealPlanName;
    }

    public void setMealPlanName(String mealPlanName) {
        this.mealPlanName = mealPlanName;
    }
}
