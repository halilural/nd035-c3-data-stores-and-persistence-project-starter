package com.udacity.jdnd.course3.critter.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "schedule_employees")
public class ScheduleEmployee {

    @Id
    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    @Id
    @ManyToOne
    @JoinColumn(name = "employees_id")
    private Employee employee;

}
