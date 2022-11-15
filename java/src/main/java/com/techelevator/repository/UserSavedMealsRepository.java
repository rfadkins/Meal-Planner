package com.techelevator.repository;


import com.techelevator.model.User;
import com.techelevator.model.UserSavedMeals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserSavedMealsRepository extends JpaRepository<UserSavedMeals, Long> {

    UserSavedMeals findByUserSavedMealsId(Long userSavedMealId);
    List<UserSavedMeals> findAllByUser(User user);
    UserSavedMeals findByUserAndMeal_mealId(User user, Long mealId);
}
