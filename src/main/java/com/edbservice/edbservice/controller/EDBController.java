package com.edbservice.edbservice.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
 
import org.springframework.web.bind.annotation.RestController;

import com.edbservice.edbservice.model.Customer;
import com.edbservice.edbservice.repository.CustomerRepository;
import com.edbservice.edbservice.exception.ResourceNotFoundException;
 
 
 
@RestController
public class EDBController {
 
	@Autowired
	CustomerRepository customerRepository;
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/customers")
	 public Page<Customer> getQuestions(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }
 
	@PostMapping("/add-customer")
	public Customer createQuestion(@Valid @RequestBody Customer customer) {
	    return customerRepository.save(customer);
	}
    
	@PutMapping("/customers/{customerId}")
    public Customer updateCustomer(@PathVariable Long customerId,
                                   @Valid @RequestBody Customer customerRequest) {
        return customerRepository.findById(customerId)
                .map(customer -> {
                	customer.setFirstname(customerRequest.getFirstname());
                	customer.setLastname(customerRequest.getLastname());
                    return customerRepository.save(customer);
                }).orElseThrow(() -> new ResourceNotFoundException("Customer not found with id " + customerId));
    }


    @DeleteMapping("/customers/{customerId}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long customerId) {
        return customerRepository.findById(customerId)
                .map(customer -> {
                	customerRepository.delete(customer);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Customer not found with id " + customerId));
    }
    
}