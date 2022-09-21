package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;
//import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
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





/*     *** MEAL.PLAN--MEAL ***
*/
@JsonIgnore
@OneToMany(mappedBy = "mealPlan", fetch = FetchType.LAZY)
private Set<MealsInMealPlan> mealPlanMeals = new HashSet<>();

/*    *** USER--MEAL.PLAN ***
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

}
