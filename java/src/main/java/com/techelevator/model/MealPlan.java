package com.techelevator.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "meal-plan")
public class MealPlan {

    @Id
    @Column(name = "meal-plan-id", nullable = false) // confirm column name
    private Long id;

    @JsonIgnore
    @OneToOne
    private User user;

    @JsonIgnore
    @OneToMany
    private Meal meal;

}
