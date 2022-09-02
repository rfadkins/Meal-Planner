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
    @Column(name = "meal_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "mp_meal_id")
    private Long mealId;

    @Column(name="recipe_id", insertable = false, updatable = false)
    private Long recipeId;

    @Column(name="meal_plan_id")  // confirm column name
    private Long mealPlanId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "recipe_id", nullable = false)
    private Recipe recipe;

    @JsonIgnore
    @Transient
    private List<Recipe> mealDetails;

}
