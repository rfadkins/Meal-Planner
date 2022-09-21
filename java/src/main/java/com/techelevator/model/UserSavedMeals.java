package com.techelevator.model;


import lombok.*;

import javax.persistence.*;
@AllArgsConstructor
@NoArgsConstructor
//@RequiredArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name="use_saved_meals")
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
