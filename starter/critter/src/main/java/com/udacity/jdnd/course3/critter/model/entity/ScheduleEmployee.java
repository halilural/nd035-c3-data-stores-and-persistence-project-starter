package com.udacity.jdnd.course3.critter.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "schedule_employees")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = "schedule")
public class ScheduleEmployee implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    @Id
    @ManyToOne
    @JoinColumn(name = "employees_id")
    private Employee employee;

}
