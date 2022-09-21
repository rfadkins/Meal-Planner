package com.techelevator.repository;

import com.techelevator.model.UserSavedRecipes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSavedRecipesRepository extends JpaRepository<UserSavedRecipes, Long> {
}

