package com.techelevator.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="user_saved_recipes")
public class UserSavedRecipes {

    @Id
    Long userSavedRecipesId;

    String recipeNotes;

    @ManyToOne
    @JoinColumn(name="recipe_id")
    Recipe recipe;

    @ManyToOne
    @JoinColumn(name="user_id")
    User user;

    public UserSavedRecipes() {
    }

    public UserSavedRecipes(Long userSavedRecipesId, String recipeNotes, Recipe recipe, User user) {
        this.userSavedRecipesId = userSavedRecipesId;
        this.recipeNotes = recipeNotes;
        this.recipe = recipe;
        this.user = user;
    }

    public Long getUserSavedRecipesId() {
        return userSavedRecipesId;
    }

    public void setUserSavedRecipesId(Long userSavedRecipesId) {
        this.userSavedRecipesId = userSavedRecipesId;
    }

    public String getRecipeNotes() {
        return recipeNotes;
    }

    public void setRecipeNotes(String recipeNotes) {
        this.recipeNotes = recipeNotes;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
