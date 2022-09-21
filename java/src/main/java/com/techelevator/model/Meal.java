package com.techelevator.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @OneToMany(mappedBy = "meal", fetch = FetchType.LAZY)
    private Set<MealsInMealPlan> mealsInMealPlan = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "meal", fetch = FetchType.LAZY)
    private Set<UserSavedMeals> userSavedMeals = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "meal", fetch = FetchType.LAZY)
    private Set<RecipesInMeal> recipesInMeal = new HashSet<>();



}
