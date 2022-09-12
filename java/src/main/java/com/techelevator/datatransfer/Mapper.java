package com.techelevator.datatransfer;

import com.techelevator.model.Ingredient;
import com.techelevator.model.Meal;
import com.techelevator.model.MealPlan;
import com.techelevator.model.Recipe;
import org.springframework.stereotype.Component;

@Component
public class Mapper extends MealPlannerDTO {

    /*
    #####  Entity to DTO  #####
     */

    public IngredientDTO mapIngredientEntityToDTO(Ingredient ingredient) {
        IngredientDTO dto = new IngredientDTO();
        dto.setIngredientId(ingredient.getIngredientId());
        dto.setIngredientName(ingredient.getIngredientName());
        dto.setIngredientCategory(ingredient.getIngredientCategory());
        return dto;
    }

    public RecipeDTO mapRecipeEntityToDTO(Recipe recipe) {
        RecipeDTO dto = new RecipeDTO();
        dto.setRecipeId(recipe.getRecipeId());
        dto.setRecipeName(recipe.getRecipeName());
        dto.setCategory(recipe.getCategory());
        dto.setRecipeInstructions(recipe.getRecipeInstructions());
        return dto;
    }

    public MealDTO mapMealEntityToDTO(Meal meal) {
        MealDTO dto = new MealDTO();
        dto.setMealId(meal.getMealId());
        dto.setMealName(meal.getMealName());
        return dto;
    }

    public MealPlanDTO mapMealPlanEntityToDTO(MealPlan mealPlan) {
        MealPlanDTO dto = new MealPlanDTO();
        dto.setMealPlanId(mealPlan.getMealPlanId());
        dto.setMealPlanName(mealPlan.getMealPlanName());
        return dto;
    }




            /*
    #####  DTO to Entity #####
     */



    public Ingredient mapIngredientDTOToEntity(MealPlannerDTO dto) {
        Ingredient ingredient = new Ingredient();
        ingredient.setIngredientId(dto.getIngredientId());
        ingredient.setIngredientName(dto.getIngredientName());
        ingredient.setIngredientCategory(dto.getIngredientCategory());
        return ingredient;
    }

    // "Cannot invoke \"com.techelevator.datatransfer.RecipeDTO.getRecipeId()\" because \"dto\" is null",
    public Recipe mapRecipeDTOToEntity(MealPlannerDTO dto) {
        Recipe recipe = new Recipe();
        recipe.setRecipeId(dto.getRecipeId());
        recipe.setRecipeName(dto.getRecipeName());
        recipe.setCategory(dto.getRecipeCategory());
        recipe.setRecipeInstructions(dto.getRecipeInstructions());
        return recipe;
    }

    public Meal mapMealDTOToEntity(MealPlannerDTO dto) {
        Meal meal = new Meal();
        meal.setMealId(dto.getMealId());
        meal.setMealName(dto.getMealName());
        return meal;
    }

    public MealPlan mapMealPlanDTOToEntity(MealPlannerDTO dto) {
        MealPlan mealPlan = new MealPlan();
        mealPlan.setMealPlanId(dto.getMealPlanId());
        mealPlan.setMealPlanName(dto.getMealPlanName());
        return mealPlan;
    }
    // Break down IngREc DTO to parts
    public Ingredient ingredientRecipeDTOtoIngredientEntity (MealPlannerDTO mealPlannerDTO) {
        Ingredient ingredient = new Ingredient();
        ingredient.setIngredientId(mealPlannerDTO.getIngredientDTO().getIngredientId());
        ingredient.setIngredientName(mealPlannerDTO.getIngredientDTO().getIngredientName());
        ingredient.setIngredientCategory(mealPlannerDTO.getIngredientDTO().getIngredientCategory());
        return ingredient;

    }











}
