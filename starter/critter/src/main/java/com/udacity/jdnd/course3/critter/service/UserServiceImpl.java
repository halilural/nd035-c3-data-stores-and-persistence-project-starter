package com.udacity.jdnd.course3.critter.service;


import com.udacity.jdnd.course3.critter.exception.CustomerNotFoundException;
import com.udacity.jdnd.course3.critter.exception.EmployeeNotFoundException;
import com.udacity.jdnd.course3.critter.model.employee.EmployeeSkill;
import com.udacity.jdnd.course3.critter.model.entity.Customer;
import com.udacity.jdnd.course3.critter.model.entity.Employee;
import com.udacity.jdnd.course3.critter.repository.CustomerRepository;
import com.udacity.jdnd.course3.critter.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PetService petService;

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return fillPetsForCustomers(customerRepository.findAll());
    }

    @Override
    public Customer getOwnerByPet(long petId) {
        Customer customer = customerRepository.findByPetsIn(petId).orElseThrow(
                () -> new CustomerNotFoundException("Customer with the pet id: " + petId + " not found")
        );
        return fillPetsForCustomer(customer);
    }

    @Override
    public Employee getEmployee(long employeeId) {
        return getEmployeeEntity(employeeId);
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
    public List<Employee> findEmployeesForService(Set<EmployeeSkill> skills, DayOfWeek dayOfWeek) {
        List<Employee> employees = employeeRepository.findAllByDaysAvailableContaining(dayOfWeek);
        List<Employee> availableEmployees = new ArrayList<>();
        for (Employee e : employees) {
            if (e.getSkills().containsAll(skills)) {
                availableEmployees.add(e);
            }
        }
        return availableEmployees;
    }

    private List<Customer> fillPetsForCustomers(List<Customer> customers) {
        List<Customer> customerList = new ArrayList<>();
        for (Customer customer : customers) {
            Customer newCustomer = fillPetsForCustomer(customer);
            customerList.add(newCustomer);
        }
        return customerList;
    }

    private Customer fillPetsForCustomer(Customer customer) {
        customer.setPets(petService.getPetsByOwner(customer.getId()));
        return customer;
    }


}
