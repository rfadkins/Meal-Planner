package com.techelevator.repository;

import com.techelevator.model.User;
import com.techelevator.model.UserSavedIngredients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserSavedIngredientsRepository extends JpaRepository<UserSavedIngredients, Long> {

    UserSavedIngredients findByUserSavedIngredientsId(Long userSavedIngredientsId);
    List<UserSavedIngredients> findAllByUser(User user);
    UserSavedIngredients findByUserAndIngredient_ingredientId(User user, Long ingredientId);

}
