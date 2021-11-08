package com.udacity.jdnd.course3.critter.repository;


import com.udacity.jdnd.course3.critter.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("select c from Customer  c inner join fetch c.petSet p where p.id = :petId")
    Optional<Customer> findByPetId(@Param("petId") long petId);

}
