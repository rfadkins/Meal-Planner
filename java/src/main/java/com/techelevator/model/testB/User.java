//package com.techelevator.model;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import lombok.*;
//import javax.persistence.*;
//import java.util.*;
//
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//@Builder
//@Entity
//@Table(name="users")
//public class User {
//
//   @Id
//   @GeneratedValue(strategy = GenerationType.IDENTITY)
//   @Column(name = "user_id", nullable = false)
//   private Long userId;
//
//   @Column(name = "USERNAME", nullable = false, unique = true)
//   private String username;
//
//   @Column(name = "PASSWORD", nullable = false)
//   @JsonIgnore
//   private String password;
//
//   @Column(name = "ROLE", nullable = false)
//   private String role;
//
//   @JsonIgnore
//   @Transient
//   private boolean activated = true;
//
//   @Transient
//   private Set<Authority> authorities = new HashSet<>();
//
//   public User (Long userID, String username, String password, String role) {
//       this.userId = userID;
//       this.username = username;
//       this.password = password;
//       this.role = role;
//   }
//   public User(Long userId, String username, String password, Set<Authority> authorities) {
//      this.userId = userId;
//      this.username = username;
//      this.password = password;
//      this.authorities = authorities;
//      this.activated = true;
//   }
//
//   public boolean isActivated() {
//      return activated;
//   }
//
//
//   /*
//   ##### JOINS  #####
//   */
//   /*
//   **** USER-PANTRY ****
//    */
//   @JsonIgnore
//   @ManyToMany(cascade = CascadeType.ALL)
//   @JoinTable(name = "user_pantry",
//         joinColumns = @JoinColumn(name = "user_id"),
//         inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
//   private Set<Ingredient> userPantry = new HashSet<>();
//
//   /*
//    **** USER-RECIPES ****
//    */
//   @JsonIgnore
//   @ManyToMany(cascade = CascadeType.ALL)
//   @JoinTable(name = "user_recipe",
//         joinColumns = @JoinColumn(name = "user_id"),
//         inverseJoinColumns = @JoinColumn(name = "recipe_id"))
//   private Set<Recipe> userRecipes = new HashSet<>();
//
//   /*
//    **** USER-MEALS ****
//    */
//   @JsonIgnore
//   @ManyToMany(cascade = CascadeType.ALL)
//   @JoinTable(name = "user_meals",
//         joinColumns = @JoinColumn(name = "user_id"),
//         inverseJoinColumns = @JoinColumn(name = "meal_id"))
//   private Set<Meal> userMeals = new HashSet<>();
//
//   /*
//    **** USER-MEAL PLANS ****
//    */
//   @JsonIgnore
//   @ManyToMany(cascade = CascadeType.ALL)
//   @JoinTable(name = "user_meal_plan",
//         joinColumns = @JoinColumn(name = "user_id"),
//         inverseJoinColumns = @JoinColumn(name = "meal_plan_id"))
//   private Set<MealPlan> userMealPlans = new HashSet<>();
//
////   public void setAuthorities(String authorities) {
////      String[] roles = authorities.split(",");
////      for(String role : roles) {
////         this.authorities.add(new Authority("ROLE_" + role));
////         String authority = role.contains("ROLE_") ? role : "ROLE_" + role;
////         this.authorities.add(new Authority(authority));
////         setAuthorities(authorities);
////      }
////
////   }
//
//   public Set<Authority> addRoleToAuthorities(String role) {
//      this.authorities.add(new Authority("ROLE_" + role));
//      setAuthorities(authorities);
//      return authorities;
//   }
//
//   @Override
//   public boolean equals(Object o) {
//      if (this == o) return true;
//      if (o == null || getClass() != o.getClass()) return false;
//      User user = (User) o;
//      return userId == user.userId &&
//               activated == user.activated &&
//               Objects.equals(username, user.username) &&
//               Objects.equals(password, user.password) &&
//               Objects.equals(authorities, user.authorities);
//   }
//
//   @Override
//   public int hashCode() {
//      return Objects.hash(userId, username, password, activated, authorities);
//   }
//
//   @Override
//   public String toString() {
//      return "User{" +
//               "id=" + userId +
//               ", username='" + username + '\'' +
//               ", activated=" + activated +
//               ", authorities=" + authorities +
//               '}';
//   }
//
///*
//##### GETTERS AND SETTERS #####
// */
//   public void setActivated(boolean activated) {
//      this.activated = activated;
//   }
//
//   public Set<Authority> getAuthorities() {
//      return authorities;
//   }
//
//   public Long getUserId() {
//      return userId;
//   }
//
//   public void setUserId(Long userId) {
//      this.userId = userId;
//   }
//
//   public String getUsername() {
//      return username;
//   }
//
//   public void setUsername(String username) {
//      this.username = username;
//   }
//
//   public String getPassword() {
//      return password;
//   }
//
//   public void setPassword(String password) {
//      this.password = password;
//   }
//
//   public Set<Ingredient> getUserPantry() {
//      return userPantry;
//   }
//
//   public void setUserPantry(Set<Ingredient> userPantry) {
//      this.userPantry = userPantry;
//   }
//
//   public Set<Recipe> getUserRecipes() {
//      return userRecipes;
//   }
//
//   public void setUserRecipes(Set<Recipe> userRecipes) {
//      this.userRecipes = userRecipes;
//   }
//
//   public Set<Meal> getUserMeals() {
//      return userMeals;
//   }
//
//   public void setUserMeals(Set<Meal> userMeals) {
//      this.userMeals = userMeals;
//   }
//
//   public Set<MealPlan> getUserMealPlans() {
//      return userMealPlans;
//   }
//
//   public void setUserMealPlans(Set<MealPlan> userMealPlans) {
//      this.userMealPlans = userMealPlans;
//   }
//
//   public void setAuthorities(Set<Authority> authorities) {
//      this.authorities = authorities;
//   }
//
//   public String getRole() {
//      return role;
//   }
//
//   public void setRole(String role) {
//      this.role = role;
//   }
//
//
//}
