package com.techelevator.model;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="user_saved_meals")
public class UserSavedMeals {
    private Long userSavedMealsId;
    private Meal meal;
    private User user;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "mp_user_saved_meals_id")
    @Column(name = "user_saved_meals_id", nullable = false)
    public Long getUserSavedMealsId() {
        return userSavedMealsId;
    }

    String mealNotes;

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="meal_id")
    public Meal getMeal() {
        return meal;
    }
    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="user_id")
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }


    public UserSavedMeals() {
    }

    public UserSavedMeals(Long userSavedMealsId, String mealNotes, Meal meal, User user) {
        this.userSavedMealsId = userSavedMealsId;
        this.mealNotes = mealNotes;
        this.meal = meal;
        this.user = user;
    }



    public void setUserSavedMealsId(Long userSavedMealsId) {
        this.userSavedMealsId = userSavedMealsId;
    }

//    public String getMealNotes() {
//        return mealNotes;
//    }
//
//    public void setMealNotes(String mealNotes) {
//        this.mealNotes = mealNotes;
//    }
}



