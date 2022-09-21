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
@Table(name="meals_in_meal_plan")
public class MealsInMealPlan {

    @Id
    Long mealsInMealPlanId;

    @ManyToOne
    @JoinColumn(name="meal_id")
    Meal meal;

    @ManyToOne
    @JoinColumn(name="meal_plan_id")
    MealPlan mealPlan;

    @Column(name="meal_order")
    int mealOrder;


}
