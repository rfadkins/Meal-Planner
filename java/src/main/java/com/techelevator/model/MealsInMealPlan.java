package com.techelevator.model;

import lombok.*;

import javax.persistence.*;

@Builder
@Entity
@Table(name="meals_in_meal_plan")
public class MealsInMealPlan {
    private Long mealsInMealPlanId;
    private Meal meal;
    private MealPlan mealPlan;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "mp_meals_in_meal_plan_id")
    @Column(name = "meals_in_meal_plan_id", nullable = false)
    public Long getMealsInMealPlanId() {
        return mealsInMealPlanId;
    }


    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="meal_id")
    public Meal getMeal() {;
        return meal;
    }
    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="meal_plan_id")
    public MealPlan getMealPlan() {
        return mealPlan;
    }
    public void setMealPlan(MealPlan mealPlan) {
        this.mealPlan = mealPlan;
    }

    @Column(name="meal_order")
    private int mealOrder;

    @Column(name="meal_name")
    private String mealName;

    @Column(name="meal_plan_name")
    private String mealPlanName;

    public MealsInMealPlan() {
    }

    public MealsInMealPlan(Long mealsInMealPlanId, Meal meal, MealPlan mealPlan, int mealOrder, String mealName,
                            String mealPlanName) {
        this.mealsInMealPlanId = mealsInMealPlanId;
        this.meal = meal;
        this.mealPlan = mealPlan;
        this.mealOrder = mealOrder;
        this.mealName = mealName;
        this.mealPlanName = mealPlanName;
    }

    public void setMealsInMealPlanId(Long mealsInMealPlanId) {
        this.mealsInMealPlanId = mealsInMealPlanId;
    }
    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public String getMealPlanName() {
        return mealPlanName;
    }

    public void setMealPlanName(String mealPlanName) {
        this.mealPlanName = mealPlanName;
    }

    public int getMealOrder() {
        return mealOrder;
    }

    public void setMealOrder(int mealOrder) {
        this.mealOrder = mealOrder;
    }
}
