package com.udacity.jdnd.course3.critter.service;


import com.udacity.jdnd.course3.critter.exception.PetNotFoundException;
import com.udacity.jdnd.course3.critter.model.dto.PetDTO;
import com.udacity.jdnd.course3.critter.repository.PetDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetServiceImpl implements PetService {

    private PetDAO petDAO;

    public PetServiceImpl(PetDAO petDAO) {
        this.petDAO = petDAO;
    }

    @Override
    public PetDTO savePet(PetDTO petDTO) {
        Long id = petDAO.savePet(petDTO);
        return getPet(id);
    }

    @Override
    public PetDTO getPet(long petId) {
        PetDTO petDTO = petDAO.getPet(petId);
        if (petDTO == null)
            throw new PetNotFoundException("Pet with " + petId + " not found!");
        return petDTO;
    }

    @Override
    public List<PetDTO> getPets() {
        return petDAO.getPets();
    }

    @Override
    public List<PetDTO> getPetsByOwner(long ownerId) {
        return petDAO.getPetsByOwner(ownerId);
    }

}
