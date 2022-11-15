package com.techelevator.repository;

import com.techelevator.model.User;
import com.techelevator.model.UserSavedMealPlans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserSavedMealPlansRepository extends JpaRepository<UserSavedMealPlans, Long> {

    UserSavedMealPlans findByUserSavedMealPlansId(Long userSavedMealPlanId);
    List<UserSavedMealPlans> findAllByUser(User user);
    UserSavedMealPlans findByUserAndMealPlan_mealPlanId(User user, Long mealPlanId);
}
