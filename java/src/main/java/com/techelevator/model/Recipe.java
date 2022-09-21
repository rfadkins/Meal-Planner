package com.techelevator.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "recipe")
public class Recipe {

    @Id
    @Column(name = "recipe_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "mp_recipe_id")
    private Long recipeId;

    @Column(name = "recipe_name", nullable = false)
    private String recipeName;

    @Column(name="category" )
    private String category;

    @Column(name="recipe_instructions")
    private String recipeInstructions;

    @JsonIgnore
    @OneToMany(mappedBy = "recipe", fetch = FetchType.LAZY)
    private Set<UserSavedRecipes> userSavedRecipes;

    @JsonIgnore
    @OneToMany(mappedBy = "recipe", fetch = FetchType.LAZY)
    private Set<RecipesInMeal>  recipesInMeal;

    @JsonIgnore
    @OneToMany(mappedBy = "recipe", fetch = FetchType.LAZY)
    private Set<IngredientsInRecipe> ingredientsInRecipe;


}
