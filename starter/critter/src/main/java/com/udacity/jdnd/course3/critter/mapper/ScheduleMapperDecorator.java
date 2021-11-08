package com.udacity.jdnd.course3.critter.mapper;


import com.udacity.jdnd.course3.critter.model.dto.ScheduleDTO;
import com.udacity.jdnd.course3.critter.model.entity.Employee;
import com.udacity.jdnd.course3.critter.model.entity.Pet;
import com.udacity.jdnd.course3.critter.model.entity.Schedule;
import com.udacity.jdnd.course3.critter.model.entity.ScheduleEmployee;

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
        if (schedule.getEmployees() != null && !schedule.getEmployees().isEmpty())
            dto.setEmployeeIds(schedule.getEmployees().stream().map(scheduleEmployee -> scheduleEmployee.getEmployee().getId()).collect(Collectors.toList()));
        if (schedule.getPets() != null && !schedule.getPets().isEmpty())
            dto.setPetIds(schedule.getPets().stream().map(Pet::getId).collect(Collectors.toList()));
        return dto;
    }

    @Override
    public Schedule asEntity(ScheduleDTO dto) {
        Schedule entity = delegate.asEntity(dto);
        if (dto.getEmployeeIds() != null && !dto.getEmployeeIds().isEmpty())
            entity.setEmployees(dto.getEmployeeIds().stream().map(id -> new ScheduleEmployee(entity, new Employee(id))).collect(Collectors.toSet()));
        if (dto.getPetIds() != null && !dto.getPetIds().isEmpty())
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
