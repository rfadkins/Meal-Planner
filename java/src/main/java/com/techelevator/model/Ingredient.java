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
@Table(name = "ingredient")
public class Ingredient {

    @Id
    @Column(name = "ingredient_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "mp_ingredient_id")
    private Long ingredientId;

    @Column(name = "ingredient_name", nullable = false)
    private String ingredientName;

    @Column(name = "category")
    private String ingredientCategory;

    @JsonIgnore
    @OneToMany(mappedBy="ingredient", fetch = FetchType.LAZY)
    private Set<IngredientsInRecipe> ingredientsInRecipe;

    @JsonIgnore
    @OneToMany(mappedBy="ingredient", fetch = FetchType.LAZY)
    private Set<UserSavedIngredients> userSavedIngredients;


}
