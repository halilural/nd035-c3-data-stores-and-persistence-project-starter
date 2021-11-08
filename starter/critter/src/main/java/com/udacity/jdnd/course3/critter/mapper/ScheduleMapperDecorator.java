package com.udacity.jdnd.course3.critter.mapper;


import com.udacity.jdnd.course3.critter.model.dto.ScheduleDTO;
import com.udacity.jdnd.course3.critter.model.entity.Employee;
import com.udacity.jdnd.course3.critter.model.entity.Pet;
import com.udacity.jdnd.course3.critter.model.entity.Schedule;
import com.udacity.jdnd.course3.critter.model.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class ScheduleMapperDecorator implements ScheduleMapper {

    private final ScheduleMapper delegate;

    public ScheduleMapperDecorator(ScheduleMapper delegate) {
        this.delegate = delegate;
    }

    @Override
    public ScheduleDTO asDTO(Schedule schedule) {
        ScheduleDTO dto = delegate.asDTO(schedule);
        dto.setEmployeeIds(schedule.getEmployees().stream().map(User::getId).collect(Collectors.toList()));
        dto.setPetIds(schedule.getPets().stream().map(Pet::getId).collect(Collectors.toList()));
        return dto;
    }

    @Override
    public Schedule asEntity(ScheduleDTO dto) {
        Schedule entity = delegate.asEntity(dto);
        entity.setEmployees(dto.getEmployeeIds().stream().map(Employee::new).collect(Collectors.toSet()));
        entity.setPets(dto.getPetIds().stream().map(Pet::new).collect(Collectors.toList()));
        return entity;
    }

    @Override
    public List<ScheduleDTO> asDTO(List<Schedule> scheduleList) {
        List<ScheduleDTO> scheduleDTOS = new ArrayList<>();
        for (Schedule entity : scheduleList) {
            scheduleDTOS.add(asDTO(entity));
        }
        return scheduleDTOS;
    }
}
