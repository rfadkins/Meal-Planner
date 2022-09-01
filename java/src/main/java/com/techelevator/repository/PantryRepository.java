package com.techelevator.repository;
import com.techelevator.model.Pantry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PantryRepository extends JpaRepository<Pantry, Long> {

    Pantry findByPantryId(Long pantryId);
}
