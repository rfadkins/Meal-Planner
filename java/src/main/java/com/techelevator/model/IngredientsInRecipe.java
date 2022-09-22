package com.techelevator.model;

import lombok.*;

import javax.persistence.*;

@Builder
@Entity
@Table(name="ingredients_in_recipe")
public class IngredientsInRecipe {
    private Long ingredientsInRecipeId;
    private Ingredient ingredient;
    private Recipe recipe;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "mp_ingredient_in_recipe_id")
    @Column(name = "ingredients_in_recipe_id", nullable = false)
    public Long getIngredientsInRecipeId(){
        return ingredientsInRecipeId;
    }


    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="ingredient_id")
    public Ingredient getIngredient() {
        return ingredient;
    }
    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    @Column(name = "ingredient_name")
    String ingredientName;

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="recipe_id")
    public Recipe getRecipe() {
        return recipe;
    }
    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    @Column(name = "recipe_name")
    private String recipeName;

    @Column(name="ingredient_quantity")
    private String ingredientQuantity;

    @Column(name="ingredient_measurement")
    private String ingredientMeasurement;


    public IngredientsInRecipe(Long ingredientsInRecipeId,
                                Ingredient ingredient,
                                Recipe recipe,
                                String ingredientName,
                                String recipeName,
                                String ingredientQuantity,
                                String ingredientMeasurement) {
        this.ingredientsInRecipeId = ingredientsInRecipeId;
        this.ingredient = ingredient;
        this.recipe = recipe;
        this.ingredientName = ingredientName;
        this.recipeName = recipeName;
        this.ingredientQuantity = ingredientQuantity;
        this.ingredientMeasurement = ingredientMeasurement;
    }
    public IngredientsInRecipe() {
    }

    /*     *** G & S ***
     */
    public void setIngredientsInRecipeId(Long ingredientsInRecipeId) {
        this.ingredientsInRecipeId = ingredientsInRecipeId;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getIngredientQuantity() {
        return ingredientQuantity;
    }

    public void setIngredientQuantity(String ingredientQuantity) {
        this.ingredientQuantity = ingredientQuantity;
    }

    public String getIngredientMeasurement() {
        return ingredientMeasurement;
    }

    public void setIngredientMeasurement(String ingredientMeasurement) {
        this.ingredientMeasurement = ingredientMeasurement;
    }


}
