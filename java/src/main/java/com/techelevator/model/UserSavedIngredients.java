package com.techelevator.model;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="user_saved_ingredients")
public class UserSavedIngredients {

    @Id
    Long userSavedIngredientsId;

    String ingredientNotes;

    @ManyToOne
    @JoinColumn(name="ingredient_id")
    Ingredient ingredient;

    @ManyToOne
    @JoinColumn(name="user_id")
    User user;

    public UserSavedIngredients() {
    }

    public UserSavedIngredients(Long userSavedIngredientsId, String ingredientNotes, Ingredient ingredient, User user) {
        this.userSavedIngredientsId = userSavedIngredientsId;
        this.ingredientNotes = ingredientNotes;
        this.ingredient = ingredient;
        this.user = user;
    }

    public Long getUserSavedIngredientsId() {
        return userSavedIngredientsId;
    }

    public void setUserSavedIngredientsId(Long userSavedIngredientsId) {
        this.userSavedIngredientsId = userSavedIngredientsId;
    }

    public String getIngredientNotes() {
        return ingredientNotes;
    }

    public void setIngredientNotes(String ingredientNotes) {
        this.ingredientNotes = ingredientNotes;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
