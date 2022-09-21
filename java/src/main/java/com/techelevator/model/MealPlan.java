package com.techelevator.model;

import lombok.*;
//import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
//@RequiredArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "meal_plan")
public class MealPlan {

    @Id
    @Column(name = "meal_plan_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "mp_meal_plan_id")
    Long mealPlanId;

    @Column(name="meal_plan_name", nullable = false)
    String mealPlanName;

<<<<<<< HEAD
    @OneToMany(mappedBy = "mealPlan")
    private Set<MealsInMealPlan> mealPlanMeals = new HashSet<>();
=======

>>>>>>> 959155426f649e571e7271b7008b7d87d991a09e

    @OneToMany(mappedBy = "mealPlan")
    private Set<UserSavedMealPlans> userSavedMealPlans = new HashSet<>();

<<<<<<< HEAD
=======

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
>>>>>>> 959155426f649e571e7271b7008b7d87d991a09e
}
