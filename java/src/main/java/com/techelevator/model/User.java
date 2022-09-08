package com.techelevator.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name="users")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "user_id", nullable = false)
   private Long userId;

   @Column(name = "USERNAME", nullable = false, unique = true)
   private String username;

   @Column(name = "PASSWORD", nullable = false)
   @JsonIgnore
   private String password;



   /*
   **** USER-PANTRY ****
    */
   @ManyToMany(cascade = CascadeType.ALL)
   @JoinTable(name = "user_pantry",
         joinColumns = @JoinColumn(name = "user_id"),
         inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
   Map<Long, Ingredient> userPantry = new HashMap<>();

   /*
    **** USER-RECIPES ****
    */
   @ManyToMany(cascade = CascadeType.ALL)
   @JoinTable(name = "user_recipe",
         joinColumns = @JoinColumn(name = "user_id"),
         inverseJoinColumns = @JoinColumn(name = "recipe_id"))
   Map<Long, Recipe> userRecipes = new HashMap<>();

   /*
    **** USER-MEALS ****
    */
   @ManyToMany(cascade = CascadeType.ALL)
   @JoinTable(name = "user_meals",
         joinColumns = @JoinColumn(name = "user_id"),
         inverseJoinColumns = @JoinColumn(name = "meal_id"))
   Map<Long, Meal> userMeals = new HashMap<>();

   /*
    **** USER-MEAL PLANS ****
    */
   @ManyToMany(cascade = CascadeType.ALL)
   @JoinTable(name = "user_meal_plan",
         joinColumns = @JoinColumn(name = "user_id"),
         inverseJoinColumns = @JoinColumn(name = "meal_plan_id"))
   Map<Long, MealPlan> userMealPlans = new HashMap<>();

   @JsonIgnore
   @Transient
   private boolean activated = true;

   @Transient
   private Set<Authority> authorities = new HashSet<>();

   public User(Long userId, String username, String password, Set<Authority> authorities) {
      this.userId = userId;
      this.username = username;
      this.password = password;
      this.authorities = authorities;
      this.activated = true;
   }



   public boolean isActivated() {
      return activated;
   }

   public void setActivated(boolean activated) {
      this.activated = activated;
   }

   public Set<Authority> getAuthorities() {
      return authorities;
   }

   public void setAuthorities(Set<Authority> authorities) {
      this.authorities = authorities;
   }

   public void setAuthorities(String authorities) {
      String[] roles = authorities.split(",");
      for(String role : roles) {
         this.authorities.add(new Authority("ROLE_" + role));
//         String authority = role.contains("ROLE_") ? role : "ROLE_" + role;
//         this.authorities.add(new Authority(authority));
      }
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      User user = (User) o;
      return userId == user.userId &&
               activated == user.activated &&
               Objects.equals(username, user.username) &&
               Objects.equals(password, user.password) &&
               Objects.equals(authorities, user.authorities);
   }

   @Override
   public int hashCode() {
      return Objects.hash(userId, username, password, activated, authorities);
   }

   @Override
   public String toString() {
      return "User{" +
               "id=" + userId +
               ", username='" + username + '\'' +
               ", activated=" + activated +
               ", authorities=" + authorities +
               '}';
   }
}
