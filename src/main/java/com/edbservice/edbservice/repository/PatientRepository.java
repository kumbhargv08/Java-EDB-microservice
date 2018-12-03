package com.edbservice.edbservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.edbservice.edbservice.model.Patient;
import org.springframework.stereotype.Repository;

@Repository 	
public interface PatientRepository extends JpaRepository<Patient, Long> {}