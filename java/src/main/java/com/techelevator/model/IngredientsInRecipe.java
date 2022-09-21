package com.techelevator.model.test;

import lombok.*;

import javax.persistence.*;
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Builder
@Entity
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
    int ingredientQuantity;

    @Column(name="ingredient_measurement")
    String ingredientMeasurement;


}
