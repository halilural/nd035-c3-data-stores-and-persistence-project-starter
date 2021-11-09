package com.udacity.jdnd.course3.critter.model.entity;


import com.udacity.jdnd.course3.critter.model.dto.PetDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Transient;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends User {
    private String phoneNumber;
    private String notes;

    @Transient
    private List<PetDTO> pets;

}
