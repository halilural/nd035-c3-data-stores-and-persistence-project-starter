package com.udacity.jdnd.course3.critter.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends User {
    private String phoneNumber;
    private String notes;

    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER)
    private Set<Pet> petSet = new HashSet<>();

}
