package com.udacity.jdnd.course3.critter.repository;

import com.udacity.jdnd.course3.critter.model.dto.ScheduleDTO;
import com.udacity.jdnd.course3.critter.model.employee.EmployeeSkill;
import com.udacity.jdnd.course3.critter.model.entity.Schedule;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface ScheduleRepository {

    Schedule createSchedule(ScheduleDTO schedule);

    List<Schedule> getAllSchedules();

    List<Schedule> getScheduleForPet(long petId);

    List<Schedule> getScheduleForEmployee(long employeeId);

    List<Schedule> getScheduleForCustomer(long customerId);

    List<Schedule> getScheduleForDateAndActivities(LocalDate date, Set<EmployeeSkill> activities);

}
