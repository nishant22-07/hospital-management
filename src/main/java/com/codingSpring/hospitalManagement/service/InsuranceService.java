package com.codingSpring.hospitalManagement.service;

import com.codingSpring.hospitalManagement.entity.Insurance;
import com.codingSpring.hospitalManagement.entity.Patient;
import com.codingSpring.hospitalManagement.repository.InsuranceRepository;
import com.codingSpring.hospitalManagement.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequiredArgsConstructor
public class InsuranceService {

    private InsuranceRepository insuranceRepository;
    private PatientRepository patientRepository;


    @Transactional
    public Patient assignInsurancetoPatient(Insurance insurance, Long patientId){
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found with this id :" + patientId ));

        patient.setInsurance(insurance);

        insurance.setPatient(patient);// bidirectional consistency maintenance

        return patient;
    }
}
