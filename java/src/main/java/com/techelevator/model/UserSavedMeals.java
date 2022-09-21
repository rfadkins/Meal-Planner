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
public class UserSavedMeals {

    @Id
    Long userSavedMealsId;

    String mealNotes;

    @ManyToOne
    @JoinColumn(name="meal_id")
    Meal meal;

    @ManyToOne
    @JoinColumn(name="user_id")
    User user;

}
