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
public class UserSavedRecipes {

    @Id
    Long userSavedRecipesId;

    String recipeNotes;

    @ManyToOne
    @JoinColumn(name="recipe_id")
    Recipe recipe;

    @ManyToOne
    @JoinColumn(name="user_id")
    User user;

}
