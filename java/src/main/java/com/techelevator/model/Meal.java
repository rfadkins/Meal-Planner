package com.techelevator.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "meal")
public class Meal {
// add join table for meal and recipe
    @Id
    @Column(name = "meal_id", nullable = false)
    private Long mealId;

    @Column(name="recipe_id")
    private Long recipeId;

    @Column(name="meal_plan_id")  // confirm column name
    private Long mealPlanId;

    @JsonIgnore
    @Transient
    private List<Recipe> userRecipeList;

}
