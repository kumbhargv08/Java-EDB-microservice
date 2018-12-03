package com.edbservice.edbservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.edbservice.edbservice.model.Doctor;
import org.springframework.stereotype.Repository;

@Repository 	
public interface DoctorRepository extends JpaRepository<Doctor, Long> {}