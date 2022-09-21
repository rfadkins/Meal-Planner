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
@Table(name="recipes_in_meal")
public class RecipesInMeal {

    @Id
    Long recipesInMealId;

    @ManyToOne
    @JoinColumn(name="recipe_id")
    Recipe recipe;

    @ManyToOne
    @JoinColumn(name="meal_id")
    Meal meal;


}
