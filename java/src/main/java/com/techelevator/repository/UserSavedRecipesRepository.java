package com.techelevator.repository;

import com.techelevator.model.User;
import com.techelevator.model.UserSavedRecipes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserSavedRecipesRepository extends JpaRepository<UserSavedRecipes, Long> {

    UserSavedRecipes findByUserSavedRecipesId(Long userSavedRecipeId);
    List<UserSavedRecipes> findAllByUser(User user);
    UserSavedRecipes findByUserAndRecipe_recipeId(User user, Long recipeId);

}

