package com.udacity.jdnd.course3.critter.model.entity;


import com.udacity.jdnd.course3.critter.model.employee.EmployeeSkill;
import lombok.Data;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.time.DayOfWeek;
import java.util.Set;

@Entity
@Data
public class Employee extends User {

    @ElementCollection
    private Set<EmployeeSkill> skills;

    @ElementCollection
    private Set<DayOfWeek> daysAvailable;

}
