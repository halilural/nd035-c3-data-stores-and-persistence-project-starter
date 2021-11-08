package com.udacity.jdnd.course3.critter.mapper;

import com.udacity.jdnd.course3.critter.model.dto.CustomerDTO;
import com.udacity.jdnd.course3.critter.model.entity.Customer;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
@DecoratedWith(CustomerMapperDecorator.class)
public interface CustomerMapper {

    CustomerDTO asDTO(Customer entity);

    Customer asEntity(CustomerDTO dto);

    List<CustomerDTO> asDTO(List<Customer> customerList);

}
