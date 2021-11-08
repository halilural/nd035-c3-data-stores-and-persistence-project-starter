package com.udacity.jdnd.course3.critter.mapper;


import com.udacity.jdnd.course3.critter.model.dto.CustomerDTO;
import com.udacity.jdnd.course3.critter.model.entity.Customer;
import com.udacity.jdnd.course3.critter.model.entity.Pet;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class CustomerMapperDecorator implements CustomerMapper {

    private final CustomerMapper delegate;

    public CustomerMapperDecorator(CustomerMapper delegate) {
        this.delegate = delegate;
    }

    @Override
    public CustomerDTO asDTO(Customer entity) {
        CustomerDTO dto = delegate.asDTO(entity);
        if (entity.getPetSet() != null && !entity.getPetSet().isEmpty())
            dto.setPetIds(entity.getPetSet().stream().map(Pet::getId).collect(Collectors.toList()));
        return dto;
    }

    @Override
    public Customer asEntity(CustomerDTO dto) {
        Customer entity = delegate.asEntity(dto);
        if (dto.getPetIds() != null && !dto.getPetIds().isEmpty())
            entity.setPetSet(dto.getPetIds().stream().map(Pet::new).collect(Collectors.toSet()));
        return entity;
    }

    @Override
    public List<CustomerDTO> asDTO(List<Customer> customers) {
        List<CustomerDTO> customerDTOS = new ArrayList<>();
        for (Customer entity : customers) {
            customerDTOS.add(asDTO(entity));
        }
        return customerDTOS;
    }
}
