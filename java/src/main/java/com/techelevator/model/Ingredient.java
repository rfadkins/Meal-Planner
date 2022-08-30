package com.techelevator.model;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "ingredient")
public class Ingredient {
    @Id
    @Column(name = "id", nullable = false)
    private Long ingredientId;

    @Column(name = "name", nullable = false)
    private String ingredientName;

    @Column(name = "category")
    private String ingredientCategory;



}
