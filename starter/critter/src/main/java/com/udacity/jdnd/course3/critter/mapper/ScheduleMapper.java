package com.udacity.jdnd.course3.critter.mapper;


import com.udacity.jdnd.course3.critter.model.dto.ScheduleDTO;
import com.udacity.jdnd.course3.critter.model.entity.Schedule;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
@DecoratedWith(ScheduleMapperDecorator.class)
public interface ScheduleMapper {

    ScheduleDTO asDTO(Schedule schedule);

    Schedule asEntity(ScheduleDTO dto);

    List<ScheduleDTO> asDTO(List<Schedule> scheduleList);

}
