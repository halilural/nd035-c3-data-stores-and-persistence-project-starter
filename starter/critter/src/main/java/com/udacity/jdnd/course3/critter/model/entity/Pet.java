package com.udacity.jdnd.course3.critter.model.entity;

import com.udacity.jdnd.course3.critter.model.pet.PetType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * It is managed with pure NamedParameterJDBCTemplate
 * <p>
 * The associated tables
 * 1. Customer-Pet Table (one to many)
 * 2. Schedule-Pet Table (many to many)
 **/
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pet")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private PetType type;
    private String name;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "customer_id")
    private Customer customer;
    private LocalDate birthDate;
    private String notes;

    public Pet(Long id) {
        this.id = id;
    }
}
