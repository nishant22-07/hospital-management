package com.codingSpring.hospitalManagement;


import com.codingSpring.hospitalManagement.entity.Insurance;
import com.codingSpring.hospitalManagement.entity.Patient;
import com.codingSpring.hospitalManagement.service.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class InsuranceTests {

    @Autowired
    private InsuranceService insuranceService;

    @Test
    public void testInsurance() {
        Insurance insurance = Insurance.builder()
                .policyNumber("HDFC_1234")
                .provider("HDFC HEALTH CARE")
                .validUntil(LocalDate.of(2030,12,12))
                .build();

        Patient patient = insuranceService.assignInsurancetoPatient(insurance,1L);
        System.out.println(patient);
    }
}
