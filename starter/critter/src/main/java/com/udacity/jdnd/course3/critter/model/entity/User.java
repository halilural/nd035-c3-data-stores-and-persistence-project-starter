package com.udacity.jdnd.course3.critter.model.entity;


import lombok.Data;
import org.hibernate.annotations.Nationalized;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


@Data
@MappedSuperclass
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Nationalized
    protected String name;

}
