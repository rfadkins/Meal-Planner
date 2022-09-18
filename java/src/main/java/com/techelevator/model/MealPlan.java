package com.techelevator.model;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "meal_plan")
public class MealPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "meal_plan_id", nullable = false)
    private Long mealPlanId;

    @Column(name = "meal_plan_name", nullable = false)
    private String mealPlanName;



/*     *** MEAL.PLAN--MEAL ***
*/
    @ManyToMany
    @JoinTable(name="meal_plan_meal",
            joinColumns =
            @JoinColumn(name="meal_plan_id"),
            inverseJoinColumns =
            @JoinColumn(name="meal_id"))
    private Set<Meal> mealsInMealPlan = new HashSet<>();

/*    *** USER--MEAL.PLAN ***
*/
    @ManyToMany(mappedBy = "userMealPlans", cascade = CascadeType.ALL)
    private Set<User> usersWithMealPlan = new HashSet<>();



/*     ##### GETTERS AND SETTERS #####
*/
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

    public void setMealsInMealPlan(Set<Meal> mealsInMealPlan) {
        this.mealsInMealPlan = mealsInMealPlan;
    }

    public Set<User> getUsersWithMealPlan() {
        return usersWithMealPlan;
    }

    public void setUsersWithMealPlan(Set<User> usersWithMealPlan) {
        this.usersWithMealPlan = usersWithMealPlan;
    }

    public Set<Meal> getMealsInMealPlan() {
        return mealsInMealPlan;
    }

    public void addMealToMealPlan(Meal meal) {
        mealsInMealPlan.add(meal);
    }




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
}
