package com.techelevator.repository;

import com.techelevator.model.UserSavedMealPlans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSavedMealPlansRepository extends JpaRepository<UserSavedMealPlans, Long> {

}
