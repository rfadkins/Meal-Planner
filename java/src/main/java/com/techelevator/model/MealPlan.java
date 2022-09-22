package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;
//import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "meal_plan")
public class MealPlan {

    @Id
    @Column(name = "meal_plan_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "mp_meal_plan_id")
    private Long mealPlanId;

    @Column(name="meal_plan_name", nullable = false)
    private String mealPlanName;


/*     *** Meals In Meal Plan***
*/
@JsonIgnore
@OneToMany(mappedBy = "mealPlan", fetch = FetchType.LAZY)
private Set<MealsInMealPlan> mealPlanMeals = new HashSet<>();

/*    *** User Saved Meal Plans ***
*/
@JsonIgnore
@OneToMany(mappedBy = "mealPlan", fetch = FetchType.LAZY)
private Set<UserSavedMealPlans> userSavedMealPlans = new HashSet<>();






    /*     ##### EQUALS AND HASHCODE #####
*/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        MealPlan mealPlan = (MealPlan) o;
        return mealPlanId != null && Objects.equals(mealPlanId, mealPlan.mealPlanId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

/*     ##### TO STRING #####
*/
    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "mealPlanId = " + mealPlanId + ", " +
                "mealPlanName = " + mealPlanName + ")";
    }

    public MealPlan() {
    }

    public MealPlan(Long mealPlanId, String mealPlanName, Set<MealsInMealPlan> mealPlanMeals,
                    Set<UserSavedMealPlans> userSavedMealPlans) {
        this.mealPlanId = mealPlanId;
        this.mealPlanName = mealPlanName;
        this.mealPlanMeals = mealPlanMeals;
        this.userSavedMealPlans = userSavedMealPlans;
    }

    public Long getMealPlanId() {
        return mealPlanId;
    }

    public void setMealPlanId(Long mealPlanId) {
        this.mealPlanId = mealPlanId;
    }

    public String getMealPlanName() {
        return mealPlanName;
    }

    public void setMealPlanName(String mealPlanName) {
        this.mealPlanName = mealPlanName;
    }

    public Set<MealsInMealPlan> getMealPlanMeals() {
        return mealPlanMeals;
    }

    public void setMealPlanMeals(Set<MealsInMealPlan> mealPlanMeals) {
        this.mealPlanMeals = mealPlanMeals;
    }

    public Set<UserSavedMealPlans> getUserSavedMealPlans() {
        return userSavedMealPlans;
    }

    public void setUserSavedMealPlans(Set<UserSavedMealPlans> userSavedMealPlans) {
        this.userSavedMealPlans = userSavedMealPlans;
    }
}
