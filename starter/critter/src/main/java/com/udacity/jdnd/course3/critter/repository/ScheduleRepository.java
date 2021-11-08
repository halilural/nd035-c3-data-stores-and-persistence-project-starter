package com.udacity.jdnd.course3.critter.repository;

import com.udacity.jdnd.course3.critter.model.dto.ScheduleDTO;
import com.udacity.jdnd.course3.critter.model.entity.Schedule;

import java.util.List;

public interface ScheduleRepository {

    Schedule createSchedule(ScheduleDTO schedule);

    List<Schedule> getAllSchedules();

    List<Schedule> getScheduleForPet(long petId);


    List<Schedule> getScheduleForEmployee(long employeeId);


    List<Schedule> getScheduleForCustomer(long customerId);

}
