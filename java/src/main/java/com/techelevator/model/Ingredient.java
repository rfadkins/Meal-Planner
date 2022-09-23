package com.techelevator.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ingredient")
public class Ingredient {

    @Id
    @Column(name = "ingredient_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "mp_ingredient_id")
    private Long ingredientId;

    @Column(name = "ingredient_name", nullable = false)
    private String ingredientName;

    @Column(name = "category")
    private String ingredientCategory;

    /*     *** Ingredients In Recipe ***
     */
    @JsonIgnore
    @OneToMany(mappedBy="ingredient", fetch = FetchType.LAZY)
    private Set<IngredientsInRecipe> ingredientsInRecipe;
    /*     *** User Saved Ingredients***
     */
    @JsonIgnore
    @OneToMany(mappedBy="ingredient", fetch = FetchType.LAZY)
    private Set<UserSavedIngredients> userSavedIngredients;

    public Ingredient() {
    }

    public Ingredient(Long ingredientId,
                        String ingredientName,
                        String ingredientCategory,
                        Set<IngredientsInRecipe> ingredientsInRecipe,
                        Set<UserSavedIngredients> userSavedIngredients) {
        this.ingredientId = ingredientId;
        this.ingredientName = ingredientName;
        this.ingredientCategory = ingredientCategory;
        this.ingredientsInRecipe = ingredientsInRecipe;
        this.userSavedIngredients = userSavedIngredients;
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

    public Set<IngredientsInRecipe> getIngredientsInRecipe() {
        return ingredientsInRecipe;
    }

    public void setIngredientsInRecipe(Set<IngredientsInRecipe> ingredientsInRecipe) {
        this.ingredientsInRecipe = ingredientsInRecipe;
    }

    public Set<UserSavedIngredients> getUserSavedIngredients() {
        return userSavedIngredients;
    }

    public void setUserSavedIngredients(Set<UserSavedIngredients> userSavedIngredients) {
        this.userSavedIngredients = userSavedIngredients;
    }
}
