package com.techelevator.model;

import lombok.*;

import javax.persistence.*;

@Builder
@Entity
@Table(name="user_saved_recipes")
public class UserSavedRecipes {
    private Long userSavedRecipesId;
    private Recipe recipe;
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "mp_user_saved_recipes_id")
    @Column(name = "user_saved_recipes_id", nullable = false)
    public Long getUserSavedRecipesId() {
        return userSavedRecipesId;
    }

    //String recipeNotes;

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="recipe_id")
    public Recipe getRecipe() {
        return recipe;
    }
    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="user_id")
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public UserSavedRecipes() {
    }
    public UserSavedRecipes(Long userSavedRecipesId, Recipe recipe, User user) {
        this.userSavedRecipesId = userSavedRecipesId;
        this.recipe = recipe;
        this.user = user;
    }

    public void setUserSavedRecipesId(Long userSavedRecipesId) {
        this.userSavedRecipesId = userSavedRecipesId;
    }
//
//    public String getRecipeNotes() {
//        return recipeNotes;
//    }
//
//    public void setRecipeNotes(String recipeNotes) {
//        this.recipeNotes = recipeNotes;
//    }




}
