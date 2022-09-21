package com.techelevator.repository;


import com.techelevator.model.UserSavedMeals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSavedMealsRepository extends JpaRepository<UserSavedMeals, Long> {

}
