package com.techelevator.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

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

    @JsonIgnore
    private String ingredient;

    @JsonIgnore
    @Transient
    private List<Ingredient> ingredientsList;

}
