package com.techelevator.model;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "ingredient")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingredient_id", nullable = false)
    private Long ingredientId;

    @Column(name = "ingredient_name", nullable = false)
    private String ingredientName;

    @Column(name = "category")
    private String ingredientCategory;

/*     *** RECIPE--INGREDIENTS ***
*/
    @ManyToMany(mappedBy = "ingredientsInRecipe")
    Set<RecipeIngredient> RecipesWithIngredient = new HashSet<>();

/*     *** USER--RECIPE ***
*/
    @ManyToMany(mappedBy = "userPantry")
    Set<User> UsersWithIngredient = new HashSet<>();


/*     ##### GETTERS AND SETTERS #####
 */

    public Long getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Long ingredientId) {
        this.ingredientId = ingredientId;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public String getIngredientCategory() {
        return ingredientCategory;
    }

    public void setIngredientCategory(String ingredientCategory) {
        this.ingredientCategory = ingredientCategory;
    }

    public Set<RecipeIngredient> getRecipesWithIngredient() {
        return RecipesWithIngredient;
    }

    public void setRecipesWithIngredient(Set<RecipeIngredient> recipesWithIngredient) {
        RecipesWithIngredient = recipesWithIngredient;
    }

    public Set<User> getUsersWithIngredient() {
        return UsersWithIngredient;
    }

    public void setUsersWithIngredient(Set<User> usersWithIngredient) {
        UsersWithIngredient = usersWithIngredient;
    }

/*     ##### EQUALS AND HASHCODE #####
*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Ingredient that = (Ingredient) o;
        return ingredientId != null && Objects.equals(ingredientId, that.ingredientId);
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
                "ingredientId = " + ingredientId + ", " +
                "ingredientName = " + ingredientName + ", " +
                "ingredientCategory = " + ingredientCategory + ")";
    }
}
