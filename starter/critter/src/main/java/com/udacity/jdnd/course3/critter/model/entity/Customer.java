package com.udacity.jdnd.course3.critter.model.entity;


import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Customer extends User {
    private String phoneNumber;
    private String notes;
}
