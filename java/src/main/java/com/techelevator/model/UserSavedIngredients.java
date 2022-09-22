package com.techelevator.model;


import lombok.*;

import javax.persistence.*;

@Builder
@Entity
@Table(name="user_saved_ingredients")
public class UserSavedIngredients {
    private Long userSavedIngredientsId;
    private Ingredient ingredient;
    private User user;

    //String ingredientNotes;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "mp_user_saved_ingredients_id")
    @Column(name = "user_saved_ingredients_id", nullable = false)
    public Long getUserSavedIngredientsId() {
        return userSavedIngredientsId;
    }

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="ingredient_id")
    public Ingredient getIngredient() {
        return ingredient;
    }
    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="user_id")
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public UserSavedIngredients() {
    }

    public UserSavedIngredients(Long userSavedIngredientsId, Ingredient ingredient, User user) {
        this.userSavedIngredientsId = userSavedIngredientsId;
        this.ingredient = ingredient;
        this.user = user;
    }

    public void setUserSavedIngredientsId(Long userSavedIngredientsId) {
        this.userSavedIngredientsId = userSavedIngredientsId;
    }

//    public String getIngredientNotes() {
//        return ingredientNotes;
//    }
//
//    public void setIngredientNotes(String ingredientNotes) {
//        this.ingredientNotes = ingredientNotes;
//    }


}
