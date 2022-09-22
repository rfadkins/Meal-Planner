package com.techelevator.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "recipe")
public class Recipe {

    @Id
    @Column(name = "recipe_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "mp_recipe_id")
    private Long recipeId;

    @Column(name = "recipe_name", nullable = false)
    private String recipeName;

    @Column(name="category" )
    private String category;

    @Column(name="recipe_instructions")
    private String recipeInstructions;

    /*     *** Ingredients In Recipe***
     */
    @JsonIgnore
    @OneToMany(mappedBy = "recipe", fetch = FetchType.LAZY)
    private Set<IngredientsInRecipe> ingredientsInRecipe;
    /*     *** Recipes In Meal***
     */
    @JsonIgnore
    @OneToMany(mappedBy = "recipe", fetch = FetchType.LAZY)
    private Set<RecipesInMeal>  recipesInMeal;
    /*     *** User Saved Recipes***
     */
    @JsonIgnore
    @OneToMany(mappedBy = "recipe", fetch = FetchType.LAZY)
    private Set<UserSavedRecipes> userSavedRecipes;


    public Recipe() {
    }

    public Recipe(Long recipeId, String recipeName, String category, String recipeInstructions,
                    Set<UserSavedRecipes> userSavedRecipes, Set<RecipesInMeal> recipesInMeal,
                    Set<IngredientsInRecipe> ingredientsInRecipe) {
        this.recipeId = recipeId;
        this.recipeName = recipeName;
        this.category = category;
        this.recipeInstructions = recipeInstructions;
        this.userSavedRecipes = userSavedRecipes;
        this.recipesInMeal = recipesInMeal;
        this.ingredientsInRecipe = ingredientsInRecipe;
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

    public Set<UserSavedRecipes> getUserSavedRecipes() {
        return userSavedRecipes;
    }

    public void setUserSavedRecipes(Set<UserSavedRecipes> userSavedRecipes) {
        this.userSavedRecipes = userSavedRecipes;
    }

    public Set<RecipesInMeal> getRecipesInMeal() {
        return recipesInMeal;
    }

    public void setRecipesInMeal(Set<RecipesInMeal> recipesInMeal) {
        this.recipesInMeal = recipesInMeal;
    }

    public Set<IngredientsInRecipe> getIngredientsInRecipe() {
        return ingredientsInRecipe;
    }

    public void setIngredientsInRecipe(Set<IngredientsInRecipe> ingredientsInRecipe) {
        this.ingredientsInRecipe = ingredientsInRecipe;
    }
}
