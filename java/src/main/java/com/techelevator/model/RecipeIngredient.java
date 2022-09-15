package com.techelevator.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class RecipeIngredient {

    @EmbeddedId
    private RecipeIngredientId recipeIngredientId;

    @ManyToOne
    @JoinColumn(name = "recipe_id", insertable = false, updatable = false)
    private Recipe recipe;

    @ManyToOne
    @JoinColumn(name = "ingredient_id", insertable = false, updatable = false)
    private Ingredient ingredient;

    @Column(name="count")
    private Long count;

    public RecipeIngredient(Recipe recipe, Ingredient ingredient, Long count) {

        //create PK from FKs
        this.recipeIngredientId = new RecipeIngredientId(recipe.getRecipeId(), ingredient.getIngredientId());

        // initialize attributes
        this.recipe = recipe;
        this.ingredient = ingredient;
        this.count = count;

        recipe.getIngredientsInRecipe().add(this);
        ingredient.getRecipesWithIngredient().add(this);

    }

    public RecipeIngredientId getRecipeIngredientId() {
        return recipeIngredientId;
    }

    public void setRecipeIngredientId(RecipeIngredientId recipeIngredientId) {
        this.recipeIngredientId = recipeIngredientId;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    @Embeddable
    public static class RecipeIngredientId implements Serializable {
        @Column(name="recipe_id")
        private Long recipeId;

        @Column(name="ingredient_id")
        private Long ingredientId;

        public RecipeIngredientId(Long recipeId, Long ingredientId) {
            this.recipeId = recipeId;
            this.ingredientId = ingredientId;
        }

        @Override
        public int hashCode() {
            return Objects.hash(recipeId, ingredientId);
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            RecipeIngredientId other = (RecipeIngredientId) obj;

            if (recipeId == null) {
                if (other.recipeId != null)
                    return false;
            } else if (!recipeId.equals(other.recipeId))
                return false;

            if (ingredientId == null) {
                if (other.ingredientId != null)
                    return false;
            } else if (!ingredientId.equals(other.ingredientId))
                return false;

            return true;
        }

    }


}
/*
 RecipeIngredientId that = (RecipeIngredientId) o;
            return recipeId.equals(that.recipeId) && ingredientId.equals(that.ingredientId);
 */