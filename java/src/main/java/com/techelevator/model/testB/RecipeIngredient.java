//package com.techelevator.model;
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.NoArgsConstructor;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.util.Objects;
//
//@Entity
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//public class RecipeIngredient {
//
//    @EmbeddedId
//    private RecipeIngredientId recipeIngredientId = new RecipeIngredientId();
//
//    @ManyToOne
//    //@MapsId("recipeId")
//    @JoinColumn(name = "recipe_id", insertable = false, updatable = false)
//    private Recipe recipe;
//
//    @ManyToOne
//    //@MapsId("ingredientId")
//    @JoinColumn(name = "ingredient_id", insertable = false, updatable = false)
//    private Ingredient ingredient;
//
//    @Column(name="count")
//    private String count;
//
//    @Autowired
//    public RecipeIngredient(Recipe recipe, Ingredient ingredient, String count) {
//
//        //create PK from FKs
//        this.recipeIngredientId = new RecipeIngredientId(recipe.getRecipeId(), ingredient.getIngredientId());
//
//        // initialize attributes
//        this.recipe = recipe;
//        this.ingredient = ingredient;
//        this.count = count;
//
//        recipe.getIngredientsInRecipe().add(this);
//       ingredient.getRecipesWithIngredient().add(this);
//
//    }
//
////    public RecipeIngredient(RecipeIngredientId recipeIngredientId, Recipe recipe, Ingredient ingredient, Long count) {
////        this.recipeIngredientId = recipeIngredientId;
////        this.recipe = recipe;
////        this.ingredient = ingredient;
////        this.count = count;
////    }
//
//    public RecipeIngredientId getRecipeIngredientId() {
//        return recipeIngredientId;
//    }
//
//    public void setRecipeIngredientId(RecipeIngredientId recipeIngredientId) {
//        this.recipeIngredientId = recipeIngredientId;
//    }
//
//    public Recipe getRecipe() {
//        return recipe;
//    }
//
//    public void setRecipe(Recipe recipe) {
//        this.recipe = recipe;
//    }
//
//    public Ingredient getIngredient() {
//        return ingredient;
//    }
//
//    public void setIngredient(Ingredient ingredient) {
//        this.ingredient = ingredient;
//    }
//
//    public String getCount() {
//        return count;
//    }
//
//    public void setCount(String count) {
//        this.count = count;
//    }
//
//
//
//
//}
///*
// RecipeIngredientId that = (RecipeIngredientId) o;
//            return recipeId.equals(that.recipeId) && ingredientId.equals(that.ingredientId);
// */