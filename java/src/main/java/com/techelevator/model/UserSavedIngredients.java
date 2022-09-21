package com.techelevator.model.test;


import lombok.*;

import javax.persistence.*;
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class UserSavedIngredients {

    @Id
    Long userSavedIngredientsId;

    String ingredientNotes;

    @ManyToOne
    @JoinColumn(name="ingredient_id")
    Ingredient ingredient;

    @ManyToOne
    @JoinColumn(name="user_id")
    User user;
}
