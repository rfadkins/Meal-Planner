package com.techelevator.model;

import lombok.*;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
@Table(name="user_saved_meal_plans")
public class UserSavedMealPlans {
    private Long userSavedMealPlansId;
    private MealPlan mealPlan;
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "mp_user_saved_meal_plans_id")
    @Column(name = "user_saved_meal_plan_id", nullable = false)
    public Long getUserSavedMealPlansId() {
        return userSavedMealPlansId;
    }

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="user_id")
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="meal_plan_id")
    public MealPlan getMealPlan() {
        return mealPlan;
    }
    public void setMealPlan(MealPlan mealPlan) {
        this.mealPlan = mealPlan;
    }

    public UserSavedMealPlans() {
    }
    public UserSavedMealPlans(Long userSavedMealPlansId, User user, MealPlan mealPlan) {
        this.userSavedMealPlansId = userSavedMealPlansId;
        this.user = user;
        this.mealPlan = mealPlan;
    }

    public void setUserSavedMealPlansId(Long userSavedMealPlansId) {
        this.userSavedMealPlansId = userSavedMealPlansId;
    }







}
