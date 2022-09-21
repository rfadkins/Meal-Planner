//package com.techelevator.model;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import lombok.*;
//import org.hibernate.Hibernate;
//
//import javax.persistence.*;
//import java.util.HashSet;
//import java.util.Objects;
//import java.util.Set;
//
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//@Entity
//@Table(name = "meal")
//public class Meal {
//
//    public enum mealOrder {
//
//    }
//
//    @Id
//    @Column(name = "meal_id", nullable = false)
//    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "mp_meal_id")
//    private Long mealId;
//
//    @Column(name = "meal_name", nullable = false)
//    private String mealName;
//
//
//
//
//    /*     *** MEAL--RECIPE ***
//     */  @JsonIgnore
//    @ManyToMany
//    @JoinTable(name="meal_recipe",
//            joinColumns = @JoinColumn(name="meal_id"),
//            inverseJoinColumns = @JoinColumn(name="recipe_id"))
//    private Set<Recipe> recipesInMeal = new HashSet<>();
//
//
//    //Set<Meal> mealsWithRecipe = new HashSet<>();
//
//    /*     *** MEAL.PLAN--MEAL ***
//     */
////    @JsonIgnore
//    @ManyToMany(mappedBy = "mealsInMealPlan", cascade = CascadeType.ALL)
//    private Set<MealPlan> mealPlansWithMeal = new HashSet<>();
//
//    /*     *** USER--MEAL ***
//     */
////@JsonIgnore
//    @ManyToMany(mappedBy = "userMeals", cascade = CascadeType.ALL)
//    private Set<User> usersWithMeal = new HashSet<>();
//
//
//    /*     ##### GETTERS AND SETTERS #####
//     */
//
//    public Long getMealId() {
//        return mealId;
//    }
//
//    public void setMealId(Long mealId) {
//        this.mealId = mealId;
//    }
//
//    public String getMealName() {
//        return mealName;
//    }
//
//    public void setMealName(String mealName) {
//        this.mealName = mealName;
//    }
//
//    public Set<Recipe> getRecipesInMeal() {
//        return recipesInMeal;
//    }
//
//    public void setRecipesInMeal(Set<Recipe> recipesInMeal) {
//        this.recipesInMeal = recipesInMeal;
//    }
//
//    public Set<MealPlan> getMealPlansWithMeal() {
//        return mealPlansWithMeal;
//    }
//
//    public void setMealPlansWithMeal(Set<MealPlan> mealPlansWithMeal) {
//        this.mealPlansWithMeal = mealPlansWithMeal;
//    }
//
//    public Set<User> getUsersWithMeal() {
//        return usersWithMeal;
//    }
//
//    public void setUsersWithMeal(Set<User> usersWithMeal) {
//        this.usersWithMeal = usersWithMeal;
//    }
//
//
//
//    /*     ##### EQUALS AND HASHCODE #####
//     */
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
//        Meal meal = (Meal) o;
//        return mealId != null && Objects.equals(mealId, meal.mealId);
//    }
//
//    @Override
//    public int hashCode() {
//        return getClass().hashCode();
//    }
//
//    /*     ##### TO STRING #####
//     */
//
//    @Override
//    public String toString() {
//        return getClass().getSimpleName() + "(" +
//                "mealId = " + mealId + ", " +
//                "mealName = " + mealName + ")";
//    }
//}


