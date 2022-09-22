package com.techelevator.model;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="use_saved_meals")
public class UserSavedMeals {

    @Id
    Long userSavedMealsId;

    String mealNotes;

    @ManyToOne
    @JoinColumn(name="meal_id")
    Meal meal;

    @ManyToOne
    @JoinColumn(name="user_id")
    User user;

    public UserSavedMeals() {
    }

    public UserSavedMeals(Long userSavedMealsId, String mealNotes, Meal meal, User user) {
        this.userSavedMealsId = userSavedMealsId;
        this.mealNotes = mealNotes;
        this.meal = meal;
        this.user = user;
    }

    public Long getUserSavedMealsId() {
        return userSavedMealsId;
    }

    public void setUserSavedMealsId(Long userSavedMealsId) {
        this.userSavedMealsId = userSavedMealsId;
    }

    public String getMealNotes() {
        return mealNotes;
    }

    public void setMealNotes(String mealNotes) {
        this.mealNotes = mealNotes;
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
