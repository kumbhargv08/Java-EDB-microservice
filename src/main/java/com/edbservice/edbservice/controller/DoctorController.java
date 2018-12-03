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

import com.edbservice.edbservice.model.Doctor;
import com.edbservice.edbservice.repository.DoctorRepository;
import com.edbservice.edbservice.exception.ResourceNotFoundException;
 
 
@RestController
public class DoctorController {
	
	@Autowired
	DoctorRepository doctorRepository;
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/doctor")
	 public Page<Doctor> getDoctor(Pageable pageable) {
        return doctorRepository.findAll(pageable);
    }
 
	@PostMapping("/add-doctor")
	public Doctor createDoctor(@Valid @RequestBody Doctor doctor) {
	    return doctorRepository.save(doctor);
	}
    
	@PutMapping("/doctor/{doctorId}")
    public Doctor updateDoctor(@PathVariable Long doctorId,
                                   @Valid @RequestBody Doctor doctorRequest) {
        return doctorRepository.findById(doctorId)
                .map(doctor -> {
                	doctor.setName(doctorRequest.getName());
                	// write getter-setter
                    return doctorRepository.save(doctor);
                }).orElseThrow(() -> new ResourceNotFoundException("Doctor not found with id " + doctorId));
    }


    @DeleteMapping("/doctor/{doctorId}")
    public ResponseEntity<?> deleteDoctor(@PathVariable Long doctorId) {
        return doctorRepository.findById(doctorId)
                .map(doctor -> {
                	doctorRepository.delete(doctor);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Doctor not found with id " + doctorId));
    }

}
