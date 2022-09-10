package com.techelevator.datatransfer;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IngredientDTO {

    @JsonProperty("ingredientId")
    private Long ingredientId;

    @JsonProperty("ingredientName")
    private String ingredientName;

    @JsonProperty("ingredientCategory")
    private String ingredientCategory;




    public Long getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Long ingredientId) {
        this.ingredientId = ingredientId;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public String getIngredientCategory() {
        return ingredientCategory;
    }

    public void setIngredientCategory(String ingredientCategory) {
        this.ingredientCategory = ingredientCategory;
    }
}
