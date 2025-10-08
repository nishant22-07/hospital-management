package com.codingSpring.hospitalManagement.repository;

import com.codingSpring.hospitalManagement.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    Patient findByName(String name);
}
