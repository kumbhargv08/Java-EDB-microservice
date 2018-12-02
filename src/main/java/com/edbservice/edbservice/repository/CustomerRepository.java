package com.edbservice.edbservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.edbservice.edbservice.model.Customer;
import org.springframework.stereotype.Repository;

@Repository 	
public interface CustomerRepository extends JpaRepository<Customer, Long> {}
