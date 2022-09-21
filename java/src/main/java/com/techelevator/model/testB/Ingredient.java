//package com.techelevator.model;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import lombok.*;
//import org.hibernate.Hibernate;
//
//import javax.persistence.*;
//import java.util.*;
//
//@NamedNativeQuery(name="findIngredientsInRecipe",
//                    query="SELECT * FROM ingredient " +
//                    "JOIN recipe_ingredients ON ingredient.ingredient_id = recipe_ingredients.ingredient_id " +
//                    "WHERE recipe_ingredients.recipe_id = ?")
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
//@Entity
//@Table(name = "ingredient")
//public class Ingredient {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "ingredient_id", nullable = false)
//    private Long ingredientId;
//
//    @Column(name = "ingredient_name", nullable = false)
//    private String ingredientName;
//
//    @Column(name = "category")
//    private String ingredientCategory;
//
//    @Column(name="count_measure")
//    private String countMeasure;
//
//    @Column(name="unit_measure")
//    private String unitMeasure;
//
//    /*     *** RECIPE--INGREDIENTS ***
//     */
//
//    @ManyToMany(mappedBy = "ingredientsInRecipe")
//    Set<Recipe> RecipesWithIngredient = new HashSet<>();
//
//    /*     *** USER--RECIPE ***
//     */
//
//    @ManyToMany(mappedBy = "userPantry")
//    Set<User> UsersWithIngredient = new HashSet<>();
//
//
//    /*     ##### GETTERS AND SETTERS #####
//     */
//
//    public Long getIngredientId() {
//        return ingredientId;
//    }
//
//    public void setIngredientId(Long ingredientId) {
//        this.ingredientId = ingredientId;
//    }
//
//    public String getIngredientName() {
//        return ingredientName;
//    }
//
//    public void setIngredientName(String ingredientName) {
//        this.ingredientName = ingredientName;
//    }
//
//    public String getIngredientCategory() {
//        return ingredientCategory;
//    }
//
//    public void setIngredientCategory(String ingredientCategory) {
//        this.ingredientCategory = ingredientCategory;
//    }
//
//    public Set<Recipe> getRecipesWithIngredient() {
//        return RecipesWithIngredient;
//    }
//
//    public String getCountMeasure() {
//        return countMeasure;
//    }
//
//    public void setCountMeasure(String countMeasure) {
//        this.countMeasure = countMeasure;
//    }
//
//    public String getUnitMeasure() {
//        return unitMeasure;
//    }
//
//    public void setUnitMeasure(String unitMeasure) {
//        this.unitMeasure = unitMeasure;
//    }
//
//    public Set<User> getUsersWithIngredient() {
//        return UsersWithIngredient;
//    }
//
//    public void setUsersWithIngredient(Set<User> usersWithIngredient) {
//        UsersWithIngredient = usersWithIngredient;
//    }
//
//    public void setRecipesWithIngredient(Set<Recipe> recipesWithIngredient) {
//        RecipesWithIngredient = recipesWithIngredient;
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
//        Ingredient that = (Ingredient) o;
//        return ingredientId != null && Objects.equals(ingredientId, that.ingredientId);
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
//                "ingredientId = " + ingredientId + ", " +
//                "ingredientName = " + ingredientName + ", " +
//                "ingredientCategory = " + ingredientCategory + ")";
//    }
//}
//






//package com.techelevator.model;
//import lombok.*;
//import org.hibernate.Hibernate;
//
//import javax.persistence.*;
//import java.util.*;
//
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
//@Entity
//@Table(name = "ingredient")
//public class Ingredient {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "ingredient_id", nullable = false)
//    private Long ingredientId;
//
//    @Column(name = "ingredient_name", nullable = false)
//    private String ingredientName;
//
//    @Column(name = "category")
//    private String ingredientCategory;
//
///*     *** RECIPE--INGREDIENTS ***
//*/
// //   @ManyToMany(mappedBy = "ingredientsInRecipe")
//   @ManyToMany(mappedBy = "recipe", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
//    Set<RecipeIngredient> recipesWithIngredient = new HashSet<RecipeIngredient>();
//
///*     *** USER--RECIPE ***
//*/
//    @ManyToMany(mappedBy = "userPantry")
//    Set<User> UsersWithIngredient = new HashSet<>();
//
//
///*     ##### GETTERS AND SETTERS #####
// */
//
//    public Long getIngredientId() {
//        return ingredientId;
//    }
//
//    public void setIngredientId(Long ingredientId) {
//        this.ingredientId = ingredientId;
//    }
//
//    public String getIngredientName() {
//        return ingredientName;
//    }
//
//    public void setIngredientName(String ingredientName) {
//        this.ingredientName = ingredientName;
//    }
//
//    public String getIngredientCategory() {
//        return ingredientCategory;
//    }
//
//    public void setIngredientCategory(String ingredientCategory) {
//        this.ingredientCategory = ingredientCategory;
//    }
//
//    public Set<RecipeIngredient> getRecipesWithIngredient() {
//        return recipesWithIngredient;
//    }
//
//    public void setRecipesWithIngredient(Set<RecipeIngredient> recipesWithIngredient) {
//        recipesWithIngredient = recipesWithIngredient;
//    }
//
//    public Set<User> getUsersWithIngredient() {
//        return UsersWithIngredient;
//    }
//
//    public void setUsersWithIngredient(Set<User> usersWithIngredient) {
//        UsersWithIngredient = usersWithIngredient;
//    }
//
///*     ##### EQUALS AND HASHCODE #####
//*/
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
//        Ingredient that = (Ingredient) o;
//        return ingredientId != null && Objects.equals(ingredientId, that.ingredientId);
//    }
//
//    @Override
//    public int hashCode() {
//        return getClass().hashCode();
//    }
//
///*     ##### TO STRING #####
//*/
//
//    @Override
//    public String toString() {
//        return getClass().getSimpleName() + "(" +
//                "ingredientId = " + ingredientId + ", " +
//                "ingredientName = " + ingredientName + ", " +
//                "ingredientCategory = " + ingredientCategory + ")";
//    }
//}
