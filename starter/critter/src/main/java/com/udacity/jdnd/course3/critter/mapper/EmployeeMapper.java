package com.udacity.jdnd.course3.critter.mapper;


import com.udacity.jdnd.course3.critter.model.dto.EmployeeDTO;
import com.udacity.jdnd.course3.critter.model.entity.Employee;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    EmployeeDTO asDTO(Employee entity);

    Employee asEntity(EmployeeDTO dto);

    List<EmployeeDTO> asDTO(List<Employee> customerList);

}
