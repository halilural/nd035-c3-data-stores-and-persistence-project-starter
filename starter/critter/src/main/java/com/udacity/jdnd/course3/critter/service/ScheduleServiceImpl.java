package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.model.entity.Schedule;
import com.udacity.jdnd.course3.critter.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Override
    public Schedule createSchedule(Schedule schedule) {
        return scheduleRepository.createSchedule(schedule);
    }

    @Override
    public List<Schedule> getAllSchedules() {
        return scheduleRepository.getAllSchedules();
    }

    @Override
    public List<Schedule> getScheduleForPet(long petId) {
        return scheduleRepository.getScheduleForPet(petId);
    }

    @Override
    public List<Schedule> getScheduleForEmployee(long employeeId) {
        return scheduleRepository.getScheduleForEmployee(employeeId);
    }

    @Override
    public List<Schedule> getScheduleForCustomer(long customerId) {
        return scheduleRepository.getScheduleForCustomer(customerId);
    }
}
