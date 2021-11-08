package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.mapper.ScheduleMapper;
import com.udacity.jdnd.course3.critter.mapper.ScheduleMapperImpl;
import com.udacity.jdnd.course3.critter.model.dto.ScheduleDTO;
import com.udacity.jdnd.course3.critter.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    private final ScheduleMapper scheduleMapper = new ScheduleMapperImpl();

    @Override
    public ScheduleDTO createSchedule(ScheduleDTO scheduleDTO) {
        return scheduleMapper.asDTO(scheduleRepository.createSchedule(scheduleDTO));
    }

    @Override
    public List<ScheduleDTO> getAllSchedules() {
        return scheduleMapper.asDTO(scheduleRepository.getAllSchedules());
    }

    @Override
    public List<ScheduleDTO> getScheduleForPet(long petId) {
        return scheduleMapper.asDTO(scheduleRepository.getScheduleForPet(petId));
    }

    @Override
    public List<ScheduleDTO> getScheduleForEmployee(long employeeId) {
        return scheduleMapper.asDTO(scheduleRepository.getScheduleForEmployee(employeeId));
    }

    @Override
    public List<ScheduleDTO> getScheduleForCustomer(long customerId) {
        return scheduleMapper.asDTO(scheduleRepository.getScheduleForCustomer(customerId));
    }
}
