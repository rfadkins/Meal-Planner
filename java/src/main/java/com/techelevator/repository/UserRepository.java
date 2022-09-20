package com.techelevator.repository;
import com.techelevator.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    User findByUserId(Long id);

    List<Ingredient> findUserPantryByUserId(Long userId);

    List<Recipe> findUserRecipesByUserId(Long userId);

    List<Meal> findUserMealsByUserId(Long userId);

    List<MealPlan> findUserMealPlansByUserId(Long userId);

    List<User> findAll();

}
