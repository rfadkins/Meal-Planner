package com.techelevator.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "meal")
public class Meal {

    @Id
    @Column(name = "meal_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "mp_meal_id")
    private Long mealId;

    @Column(name = "meal_name", nullable = false)
    private String mealName;


    /*     *** Recipes In Meal***
     */
    @JsonIgnore
    @OneToMany(mappedBy = "meal", fetch = FetchType.LAZY)
    private Set<RecipesInMeal> recipesInMeal = new HashSet<>();
    /*     *** Meals In Meal Plan***
     */
    @JsonIgnore
    @OneToMany(mappedBy = "meal", fetch = FetchType.LAZY)
    private Set<MealsInMealPlan> mealsInMealPlan = new HashSet<>();
    /*     *** User Saved Meals***
     */
    @JsonIgnore
    @OneToMany(mappedBy = "meal", fetch = FetchType.LAZY)
    private Set<UserSavedMeals> userSavedMeals = new HashSet<>();

    public Meal() {
    }

    public Meal(Long mealId, String mealName, Set<MealsInMealPlan> mealsInMealPlan,
                Set<UserSavedMeals> userSavedMeals, Set<RecipesInMeal> recipesInMeal) {
        this.mealId = mealId;
        this.mealName = mealName;
        this.mealsInMealPlan = mealsInMealPlan;
        this.userSavedMeals = userSavedMeals;
        this.recipesInMeal = recipesInMeal;
    }

    public Long getMealId() {
        return mealId;
    }

    public void setMealId(Long mealId) {
        this.mealId = mealId;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public Set<MealsInMealPlan> getMealsInMealPlan() {
        return mealsInMealPlan;
    }

    public void setMealsInMealPlan(Set<MealsInMealPlan> mealsInMealPlan) {
        this.mealsInMealPlan = mealsInMealPlan;
    }

    public Set<UserSavedMeals> getUserSavedMeals() {
        return userSavedMeals;
    }

    public void setUserSavedMeals(Set<UserSavedMeals> userSavedMeals) {
        this.userSavedMeals = userSavedMeals;
    }

    public Set<RecipesInMeal> getRecipesInMeal() {
        return recipesInMeal;
    }

    public void setRecipesInMeal(Set<RecipesInMeal> recipesInMeal) {
        this.recipesInMeal = recipesInMeal;
    }
}
