package com.techelevator.repository;

import com.techelevator.model.UserSavedIngredients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSavedIngredientsRepository extends JpaRepository<UserSavedIngredients, Long> {


}
