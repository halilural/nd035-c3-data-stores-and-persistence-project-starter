package com.udacity.jdnd.course3.critter.model.entity;

import com.udacity.jdnd.course3.critter.model.pet.PetType;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

/**
 * It is managed with pure NamedParameterJDBCTemplate
 * <p>
 * The associated tables
 * 1. Customer-Pet Table (one to many)
 * 2. Schedule-Pet Table (many to many)
 **/
@Data
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private PetType type;
    private String name;
    private Long ownerId;
    private LocalDate birthDate;
    private String notes;

}
