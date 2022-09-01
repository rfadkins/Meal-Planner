package com.techelevator.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "meal_plan")
public class MealPlan {

    @Id
    @Column(name = "meal_plan_id", nullable = false) // confirm column name
    private Long mealPlanId;

    @JsonIgnore
    @OneToOne
    private User user;

    @JsonIgnore
    @OneToOne
    private Meal meal;

}
