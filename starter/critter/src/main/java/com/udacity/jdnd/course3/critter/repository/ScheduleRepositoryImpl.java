package com.udacity.jdnd.course3.critter.repository;


import com.udacity.jdnd.course3.critter.mapper.ScheduleMapper;
import com.udacity.jdnd.course3.critter.mapper.ScheduleMapperImpl;
import com.udacity.jdnd.course3.critter.model.dto.ScheduleDTO;
import com.udacity.jdnd.course3.critter.model.entity.Schedule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
@Slf4j
public class ScheduleRepositoryImpl implements ScheduleRepository {

    @PersistenceContext
    private EntityManager entityManager;

    private final ScheduleMapper scheduleMapper = new ScheduleMapperImpl();

    @Override
    public Schedule createSchedule(ScheduleDTO scheduleDTO) {
        Schedule schedule = scheduleMapper.asEntity(scheduleDTO);
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
}
