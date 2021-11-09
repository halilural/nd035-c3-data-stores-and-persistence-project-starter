package com.udacity.jdnd.course3.critter.mapper;


import com.udacity.jdnd.course3.critter.model.dto.CustomerDTO;
import com.udacity.jdnd.course3.critter.model.dto.PetDTO;
import com.udacity.jdnd.course3.critter.model.entity.Customer;

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
        if (entity.getPets() != null && !entity.getPets().isEmpty())
            dto.setPetIds(entity.getPets().stream().map(PetDTO::getId).collect(Collectors.toList()));
        return dto;
    }

    @Override
    public Customer asEntity(CustomerDTO dto) {
        Customer entity = delegate.asEntity(dto);
        if (dto.getPetIds() != null && !dto.getPetIds().isEmpty())
            entity.setPets(dto.getPetIds().stream().map(PetDTO::new).collect(Collectors.toList()));
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
