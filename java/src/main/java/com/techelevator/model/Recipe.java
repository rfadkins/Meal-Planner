package com.techelevator.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name="recipe")
public class Recipe {

    @Id
    @Column(name = "recipe_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "mp_recipe_id")
    private Long recipeId;

    @Column(name = "recipe_name", nullable = false)
    private String recipeName;

    @Column(name="category" )
    private String category;

    @Column(name="recipe_instructions")
    private String recipeInstructions;

    /*
     **** RECIPE-INGREDIENTS ****
     */
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "recipe_ingredients",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
    Map<Long, Ingredient> recipeIngredients = new HashMap<>();

//    @ManyToMany(mappedBy = "userRecipes")
//    private User user;
//
//    @ManyToMany(mappedBy = "mealRecipes")
//    private Meal meal;

}

/*
    @ManyToMany
    @JoinTable(name="recipe_ingredient",
            joinColumns =
            @JoinColumn(name="recipe_id"),
            inverseJoinColumns =
            @JoinColumn(name="ingredient_id"))
    //Map<recipeId, Ingredient>
    private Map<Long, Ingredient> recipeIngredients;
 */
