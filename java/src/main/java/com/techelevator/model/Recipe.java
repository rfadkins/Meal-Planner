package com.techelevator.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="recipe")
public class Recipe {

    @Id
    @Column(name = "recipe_id", nullable = false)
    private Long recipeId;

    @Column(name = "recipe_name", nullable = false)
    private String recipeName;

    @Column(name="category" )
    private String category;

    @Column(name = "meal_id")
    private Long mealId;

    @ManyToMany
    @JoinTable(name="recipe_ingredient",
            joinColumns =
            @JoinColumn(name="recipe_id"),
            inverseJoinColumns =
            @JoinColumn(name="ingredient_id"))
    //Map<recipeId, Ingredient>
    private Map<Long, Ingredient> recipeIngredients;

}
