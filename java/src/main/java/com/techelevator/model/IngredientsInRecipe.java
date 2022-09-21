package com.techelevator.model;

import lombok.*;

import javax.persistence.*;
@AllArgsConstructor
@NoArgsConstructor
//@RequiredArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name="ingredients_in_recipe")
public class IngredientsInRecipe {

    @Id
    Long ingredientsInRecipeId;

    @ManyToOne
    @JoinColumn(name="ingredient_id")
    Ingredient ingredient;

    @ManyToOne
    @JoinColumn(name="recipe_id")
    Recipe recipe;

    @Column(name="ingredient_quantity")
    Integer ingredientQuantity;

    @Column(name="ingredient_measurement")
    String ingredientMeasurement;


}
