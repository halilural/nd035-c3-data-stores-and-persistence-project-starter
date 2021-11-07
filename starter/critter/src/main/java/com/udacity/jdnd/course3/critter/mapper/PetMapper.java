package com.udacity.jdnd.course3.critter.mapper;


import com.udacity.jdnd.course3.critter.model.dto.PetDTO;
import com.udacity.jdnd.course3.critter.model.entity.Pet;
import org.mapstruct.Mapper;

@Mapper
public interface PetMapper {

    PetDTO asDTO(Pet pet);

    Pet asEntity(PetDTO petDTO);

}
