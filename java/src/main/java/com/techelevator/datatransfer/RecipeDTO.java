package com.techelevator.datatransfer;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RecipeDTO {

    @JsonProperty("recipe_id")
    private Long recipeId;

    @JsonProperty("recipe_name")
    private String recipeName;

    @JsonProperty("category")
    private String category;

    @JsonProperty("recipe_instructions")
    private String recipeInstructions;

    public Long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRecipeInstructions() {
        return recipeInstructions;
    }

    public void setRecipeInstructions(String recipeInstructions) {
        this.recipeInstructions = recipeInstructions;
    }
}
