package com.udacity.jdnd.course3.critter.repository;


import com.udacity.jdnd.course3.critter.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query(nativeQuery = true, value = "select * from customer c inner join pet p on c.id = p.customer_id where  p.id = :id")
    Optional<Customer> findByPetsIn(@Param("id") long petId);

}
