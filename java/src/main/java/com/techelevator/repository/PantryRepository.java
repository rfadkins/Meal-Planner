package com.techelevator.repository;
import com.techelevator.model.Pantry;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PantryRepository extends JpaRepository<Pantry, Long> {

    Pantry findByUserId(Long userId);

    Pantry findByPantryId(Long pantryId);
}
