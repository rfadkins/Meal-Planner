package com.techelevator.model;


import lombok.*;

import javax.persistence.*;

@Builder
@Entity
@Table(name="recipes_in_meal")
public class RecipesInMeal {
    private Long recipesInMealId;
    private Recipe recipe;
    private Meal meal;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "mp_recipe_in_meal_id")
    @Column(name = "recipes_in_meal_id", nullable = false)
    public Long getRecipesInMealId() {
        return recipesInMealId;
    }

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="recipe_id")
    public Recipe getRecipe() {
        return recipe;
    }
    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="meal_id")
    public Meal getMeal() {
        return meal;
    }
    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    @Column(name = "recipe_name")
    private String recipeName;

    @Column(name = "meal_name")
    private String mealName;



    public RecipesInMeal() {
    }

    public RecipesInMeal(Long recipesInMealId,
                        Recipe recipe,
                        Meal meal,
                        String recipeName,
                        String mealName) {
        this.recipesInMealId = recipesInMealId;
        this.recipe = recipe;
        this.meal = meal;
        this.recipeName = recipeName;
        this.mealName = mealName;
    }

    public void setRecipesInMealId(Long recipesInMealId) {
        this.recipesInMealId = recipesInMealId;
    }


    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }
}
