package com.udacity.jdnd.course3.critter.repository;

import com.udacity.jdnd.course3.critter.model.dto.PetDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface PetDAO {

    Long savePet(@RequestBody PetDTO petDTO);

    PetDTO getPet(@PathVariable long petId);

    List<PetDTO> getPets();

    List<PetDTO> getPetsByOwner(@PathVariable long ownerId);

}
