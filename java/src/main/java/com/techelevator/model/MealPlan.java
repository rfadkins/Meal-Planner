package com.techelevator.model;

import lombok.*;
//import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
//@RequiredArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "meal_plan")
public class MealPlan {

    @Id
    @Column(name = "meal_plan_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "mp_meal_plan_id")
    Long mealPlanId;

    @Column(name="meal_plan_name", nullable = false)
    String mealPlanName;

    @OneToMany(mappedBy = "mealPlan")
    private Set<MealsInMealPlan> mealPlanMeals = new HashSet<>();

    @OneToMany(mappedBy = "mealPlan")
    private Set<UserSavedMealPlans> userSavedMealPlans = new HashSet<>();

}
