//package com.techelevator.model;
//
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.Column;
//import javax.persistence.Embeddable;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import java.io.Serializable;
//import java.util.Objects;
//
//
//
//@Embeddable
//@Getter
//@Setter
//@NoArgsConstructor
//public class RecipeIngredientId implements Serializable {
//
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name="recipe_id")
//    private Long recipeId;
//
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name="ingredient_id")
//    private Long ingredientId;
//
//    public RecipeIngredientId(Long recipeId, Long ingredientId) {
//        this.recipeId = recipeId;
//        this.ingredientId = ingredientId;
//        }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(recipeId, ingredientId);
//    }
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//
//        RecipeIngredientId other = (RecipeIngredientId) obj;
//
//        return  Objects.equals(
//                    getIngredientId(),
//                    other.getIngredientId())
//                &&
//                Objects.equals(
//                    getRecipeId(),
//                    other.getRecipeId());
//        }
//
//
//
//
//}
//
