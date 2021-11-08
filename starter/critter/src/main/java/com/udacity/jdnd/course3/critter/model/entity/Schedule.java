package com.udacity.jdnd.course3.critter.model.entity;


import com.udacity.jdnd.course3.critter.model.employee.EmployeeSkill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NamedQueries(
        {
                @NamedQuery(
                        name = "Schedule.findAll",
                        query = "select s from Schedule s"
                ),
                @NamedQuery(
                        name = "Schedule.findAllByPetId",
                        query = "select s from Schedule s " +
                                "inner join fetch s.pets p " +
                                "where p.id = :petId "
                ),
                @NamedQuery(
                        name = "Schedule.findAllByEmployeeId",
                        query = "select s from Schedule s " +
                                "inner join fetch s.employees e " +
                                "where e.employee.id = :employeeId "
                ),
                @NamedQuery(
                        name = "Schedule.findAllByCustomerId",
                        query = "select s from Schedule s " +
                                "inner join fetch s.pets p " +
                                "inner join fetch p.owner c " +
                                "where c.id = :customerId "
                ),
                @NamedQuery(
                        name = "Schedule.findAllByDateAndSkills",
                        query = "select s from Schedule s " +
                                "inner join fetch s.activities a " +
                                "where s.date = :date " +
                                "and a in :skills "
                )
        }
)

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Schedule implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "schedule", fetch = FetchType.EAGER)
    private Set<ScheduleEmployee> employees = new HashSet<>();

    @Column(name = "date")
    private LocalDate date;

    @ElementCollection
    private Set<EmployeeSkill> activities;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "schedule_pets", joinColumns = @JoinColumn(name = "schedule_id"),
            inverseJoinColumns = @JoinColumn(name = "pet_id"))
    private List<Pet> pets = new ArrayList<>();

}
