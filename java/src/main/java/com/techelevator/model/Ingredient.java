package com.techelevator.model;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipe_recipe_id")
    private Recipe recipeRecipe;



}
