package com.udacity.jdnd.course3.critter.service;


import com.udacity.jdnd.course3.critter.model.dto.CustomerDTO;
import com.udacity.jdnd.course3.critter.model.dto.EmployeeDTO;
import com.udacity.jdnd.course3.critter.model.dto.EmployeeRequestDTO;
import com.udacity.jdnd.course3.critter.model.employee.EmployeeSkill;
import com.udacity.jdnd.course3.critter.model.entity.Employee;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;

public interface UserService {

    CustomerDTO saveCustomer(CustomerDTO customerDTO);

    List<CustomerDTO> getAllCustomers();

    CustomerDTO getOwnerByPet(long petId);

    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);

    EmployeeDTO getEmployee(long employeeId);

    Employee getEmployeeEntity(long employeeId);

    void setAvailability(Set<DayOfWeek> daysAvailable, long employeeId);

    List<EmployeeDTO> findEmployeesForService(Set<EmployeeSkill> skills, DayOfWeek dayOfWeek);


}
