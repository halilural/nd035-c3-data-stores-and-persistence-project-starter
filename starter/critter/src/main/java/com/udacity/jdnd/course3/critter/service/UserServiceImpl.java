package com.udacity.jdnd.course3.critter.service;


import com.udacity.jdnd.course3.critter.exception.CustomerNotFoundException;
import com.udacity.jdnd.course3.critter.exception.EmployeeNotFoundException;
import com.udacity.jdnd.course3.critter.mapper.CustomerMapper;
import com.udacity.jdnd.course3.critter.mapper.CustomerMapperImpl;
import com.udacity.jdnd.course3.critter.mapper.EmployeeMapper;
import com.udacity.jdnd.course3.critter.mapper.EmployeeMapperImpl;
import com.udacity.jdnd.course3.critter.model.dto.CustomerDTO;
import com.udacity.jdnd.course3.critter.model.dto.EmployeeDTO;
import com.udacity.jdnd.course3.critter.model.employee.EmployeeSkill;
import com.udacity.jdnd.course3.critter.model.entity.Customer;
import com.udacity.jdnd.course3.critter.model.entity.Employee;
import com.udacity.jdnd.course3.critter.repository.CustomerRepository;
import com.udacity.jdnd.course3.critter.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    private final CustomerMapper customerMapper = new CustomerMapperImpl();

    private final EmployeeMapper employeeMapper = new EmployeeMapperImpl();

    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        return customerMapper.asDTO(customerRepository.save(customerMapper.asEntity(customerDTO)));
    }

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        return employeeMapper.asDTO(employeeRepository.save(employeeMapper.asEntity(employeeDTO)));
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerMapper.asDTO(customerRepository.findAll());
    }

    @Override
    public CustomerDTO getOwnerByPet(long petId) {
        Customer customer = customerRepository.findByPetId(petId).orElseThrow(
                () -> new CustomerNotFoundException("Customer with the pet id: " + petId + " not found")
        );
        return customerMapper.asDTO(customer);
    }

    @Override
    public EmployeeDTO getEmployee(long employeeId) {
        return employeeMapper.asDTO(getEmployeeEntity(employeeId));
    }

    @Override
    public Employee getEmployeeEntity(long employeeId) {
        return employeeRepository.findById(employeeId).orElseThrow(
                () -> new EmployeeNotFoundException("Employee with the id: " + employeeId + " not found")
        );
    }

    @Override
    public void setAvailability(Set<DayOfWeek> daysAvailable, long employeeId) {
        Employee employee = getEmployeeEntity(employeeId);
        employee.setDaysAvailable(daysAvailable);
        employeeRepository.save(employee);
    }

    @Override
    public List<EmployeeDTO> findEmployeesForService(Set<EmployeeSkill> skills, DayOfWeek dayOfWeek) {
        List<Employee> employees = employeeRepository.findAllByDaysAvailableContaining(dayOfWeek);
        List<Employee> availableEmployees = new ArrayList<>();
        for (Employee e : employees) {
            if (e.getSkills().containsAll(skills)) {
                availableEmployees.add(e);
            }
        }
        return employeeMapper.asDTO(availableEmployees);
    }
}
