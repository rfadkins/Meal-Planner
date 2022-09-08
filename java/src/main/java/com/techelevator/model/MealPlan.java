package com.techelevator.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "meal_plan")
public class MealPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "meal_plan_id", nullable = false)
    private Long mealPlanId;

    @Column(name = "meal_plan_name", nullable = false)
    private String mealPlanName;

//    @ManyToMany(mappedBy="userMealPlans")
//    private User user;

    /*
     **** MEAL PLAN-MEAL ****
     */
    @ManyToMany
    @JoinTable(name="meal_plan_meal",
            joinColumns =
            @JoinColumn(name="meal_plan_id"),
            inverseJoinColumns =
            @JoinColumn(name="meal_id"))
    private Map<Long, Meal> mealsForMealPlan;



}
