package com.techelevator.model;


import lombok.*;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "meal")
public class Meal {

    @Id
    @Column(name = "meal_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "mp_meal_id")
    private Long mealId;

    @Column(name = "meal_name", nullable = false)
    private String mealName;

    @OneToMany(mappedBy = "meal")
    private Set<MealsInMealPlan> mealsInMealPlan = new HashSet<>();

    @OneToMany(mappedBy = "meal")
    private Set<UserSavedMeals> userSavedMeals = new HashSet<>();

    @OneToMany(mappedBy = "meal")
    private Set<RecipesInMeal> recipesInMeal = new HashSet<>();



}
