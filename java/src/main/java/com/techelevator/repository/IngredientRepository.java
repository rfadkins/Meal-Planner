package com.techelevator.repository;
import com.techelevator.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    Ingredient findByIngredientId(Long ingredientId);

    Ingredient findByIngredientName(String ingredientName);

 //   List<Ingredient> findAllByFkUserUserId(Long userId);



    List<Ingredient> findAll();

}

