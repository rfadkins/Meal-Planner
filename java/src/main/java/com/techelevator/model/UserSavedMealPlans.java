package com.techelevator.model;

import lombok.*;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@NoArgsConstructor
//@RequiredArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name="user_saved_meal_plans")
public class UserSavedMealPlans {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_saved_meal_plan_id", nullable = false)
     Long userSavedMealPlansId;

    @ManyToOne
    @JoinColumn(name="user_id")
    User user;

    @ManyToOne
    @JoinColumn(name="meal_plan_id")
    MealPlan mealPlan;
}
