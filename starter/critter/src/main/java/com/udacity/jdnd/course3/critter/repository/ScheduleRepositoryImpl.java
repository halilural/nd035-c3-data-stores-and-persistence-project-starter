package com.udacity.jdnd.course3.critter.repository;


import com.udacity.jdnd.course3.critter.model.employee.EmployeeSkill;
import com.udacity.jdnd.course3.critter.model.entity.Schedule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Repository
@Slf4j
public class ScheduleRepositoryImpl implements ScheduleRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Schedule createSchedule(Schedule schedule) {
        entityManager.persist(schedule);
        return schedule;
    }

    @Override
    public List<Schedule> getAllSchedules() {
        List schedules = entityManager.createNamedQuery("Schedule.findAll").getResultList();
        return schedules;
    }

    @Override
    public List<Schedule> getScheduleForPet(long petId) {
        List schedules = entityManager.createNamedQuery("Schedule.findAllByPetId").setParameter("petId", petId).getResultList();
        return schedules;
    }

    @Override
    public List<Schedule> getScheduleForEmployee(long employeeId) {
        List schedules = entityManager.createNamedQuery("Schedule.findAllByEmployeeId").setParameter("employeeId", employeeId).getResultList();
        return schedules;
    }

    @Override
    public List<Schedule> getScheduleForCustomer(long customerId) {
        List schedules = entityManager.createNamedQuery("Schedule.findAllByCustomerId").setParameter("customerId", customerId).getResultList();
        return schedules;
    }

    @Override
    public List<Schedule> getScheduleForDateAndActivities(LocalDate date, Set<EmployeeSkill> activities) {
        List schedules = entityManager.createNamedQuery("Schedule.findAllByDateAndSkills").setParameter("date", date).setParameter("skills", activities).getResultList();
        return schedules;
    }
}
