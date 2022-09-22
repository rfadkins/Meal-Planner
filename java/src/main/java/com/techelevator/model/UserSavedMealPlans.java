package com.techelevator.model;

import lombok.*;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


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

    public UserSavedMealPlans() {
    }

    public UserSavedMealPlans(Long userSavedMealPlansId, User user, MealPlan mealPlan) {
        this.userSavedMealPlansId = userSavedMealPlansId;
        this.user = user;
        this.mealPlan = mealPlan;
    }

    public Long getUserSavedMealPlansId() {
        return userSavedMealPlansId;
    }

    public void setUserSavedMealPlansId(Long userSavedMealPlansId) {
        this.userSavedMealPlansId = userSavedMealPlansId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public MealPlan getMealPlan() {
        return mealPlan;
    }

    public void setMealPlan(MealPlan mealPlan) {
        this.mealPlan = mealPlan;
    }
}
