package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.model.employee.EmployeeSkill;
import com.udacity.jdnd.course3.critter.model.entity.Customer;
import com.udacity.jdnd.course3.critter.model.entity.Employee;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;

public interface UserService {

    Customer saveCustomer(Customer customer);

    List<Customer> getAllCustomers();

    Customer getOwnerByPet(long petId);

    Employee saveEmployee(Employee employee);

    Employee getEmployee(long employeeId);

    Employee getEmployeeEntity(long employeeId);

    void setAvailability(Set<DayOfWeek> daysAvailable, long employeeId);

    List<Employee> findEmployeesForService(Set<EmployeeSkill> skills, DayOfWeek dayOfWeek);


}
