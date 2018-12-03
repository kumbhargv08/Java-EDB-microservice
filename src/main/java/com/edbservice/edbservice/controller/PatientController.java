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

import com.edbservice.edbservice.model.Patient;
import com.edbservice.edbservice.repository.PatientRepository;
import com.edbservice.edbservice.exception.ResourceNotFoundException;
 
 
@RestController
public class PatientController {
	
	@Autowired
	PatientRepository patientRepository;
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/patients")
	 public Page<Patient> getQuestions(Pageable pageable) {
        return patientRepository.findAll(pageable);
    }
 
	@PostMapping("/add-patient")
	public Patient createQuestion(@Valid @RequestBody Patient patient) {
	    return patientRepository.save(patient);
	}
    
	@PutMapping("/patients/{patientId}")
    public Patient updatePatient(@PathVariable Long patientId,
                                   @Valid @RequestBody Patient patientRequest) {
        return patientRepository.findById(patientId)
                .map(patient -> {
                	patient.setName(patientRequest.getName());
                    return patientRepository.save(patient);
                }).orElseThrow(() -> new ResourceNotFoundException("Patient not found with id " + patientId));
    }


    @DeleteMapping("/patients/{patientId}")
    public ResponseEntity<?> deletePatient(@PathVariable Long patientId) {
        return patientRepository.findById(patientId)
                .map(patient -> {
                	patientRepository.delete(patient);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Patient not found with id " + patientId));
    }

}
