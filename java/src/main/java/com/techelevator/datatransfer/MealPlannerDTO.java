package com.techelevator.datatransfer;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;
import java.util.Map;

@JsonFormat(shape = JsonFormat.Shape.ARRAY)
@JsonPropertyOrder({"recipe", "ingredient"})
public abstract class MealPlannerDTO {
    private Map<String, List<Map <String, String>>> mealPlannerDTO;

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    @JsonProperty("ingredient")
    IngredientDTO ingredientDTO;
    private Long ingredientId;
    private String ingredientName;
    private String ingredientCategory;

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    @JsonProperty("recipe")
    RecipeDTO recipeDTO;
    private Long recipeId;
    private String recipeName;
    private String recipeCategory;
    private String recipeInstructions;

    MealDTO mealDTO;
    private Long mealId;
    private String mealName;

    MealPlanDTO mealPlanDTO;
    private Long mealPlanId;
    private String mealPlanName;




    public IngredientDTO getIngredientDTO() {
        return ingredientDTO;
    }

    public void setIngredientDTO(IngredientDTO ingredientDTO) {
        this.ingredientDTO = ingredientDTO;
    }

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

    public RecipeDTO getRecipeDTO() {
        return recipeDTO;
    }

    public void setRecipeDTO(RecipeDTO recipeDTO) {
        this.recipeDTO = recipeDTO;
    }
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

    public String getRecipeCategory() {
        return recipeCategory;
    }

    public void setRecipeCategory(String recipeCategory) {
        this.recipeCategory = recipeCategory;
    }

    public String getRecipeInstructions() {
        return recipeInstructions;
    }

    public void setRecipeInstructions(String recipeInstructions) {
        this.recipeInstructions = recipeInstructions;
    }

    public MealDTO getMealDTO() {
        return mealDTO;
    }

    public void setMealDTO(MealDTO mealDTO) {
        this.mealDTO = mealDTO;
    }

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

    public MealPlanDTO getMealPlanDTO() {
        return mealPlanDTO;
    }

    public void setMealPlanDTO(MealPlanDTO mealPlanDTO) {
        this.mealPlanDTO = mealPlanDTO;
    }

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
