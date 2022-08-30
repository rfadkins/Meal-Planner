package com.techelevator.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long recipeId;

    @Column(name = "name", nullable = false)
    private String recipeName;

    @Column(name = "category")
    private String recipeCategory;

    @Column(name = "meal_id")
    private Long mealId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "meal_id")
    private Meal meal;

    private String ingredient;

    private List<Ingredient> ingredientsList;

}
