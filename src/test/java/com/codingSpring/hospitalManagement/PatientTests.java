package com.codingSpring.hospitalManagement;

import com.codingSpring.hospitalManagement.entity.Patient;
import com.codingSpring.hospitalManagement.repository.PatientRepository;
import com.codingSpring.hospitalManagement.service.PatientService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientTests {


    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @Test
    public void testPatientRepository(){
        List<Patient> patientList = patientRepository.findAll();
        System.out.println(patientList);

        Patient p1 = new Patient();
        patientRepository.save(p1);
    }

    @Test
    public  void testTransactionMethods(){
//        Patient patient = patientService.getPatientById(1L);
//        Patient patient = patientRepository.findById(1L).orElseThrow(() -> new EntityNotFoundException("Patient not "));
        Patient patient = patientRepository.findByName("Nishant Kumar");

        System.out.println(patient);
    }

}
