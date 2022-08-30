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

    @Id
    @Column(name = "id", nullable = false)
    private Long mealId;

    @Column(name="recipe-id")
    private Long recipeId;

    @Column(name="meal-plan-id")  // confirm column name
    private Long mealPlanId;

    private List<Recipe> userRecipeList;

}
