package com.techelevator.model;
import lombok.*;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
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

//    @ManyToMany(mappedBy="userPantry")
//    private User user;
//
//    @ManyToMany(mappedBy="recipeIngredients")
//    private Recipe recipe;





}
