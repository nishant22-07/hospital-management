package com.codingSpring.hospitalManagement;

import com.codingSpring.hospitalManagement.dto.BloodGroupCountResponseEntity;
import com.codingSpring.hospitalManagement.entity.Patient;
import com.codingSpring.hospitalManagement.repository.PatientRepository;
import com.codingSpring.hospitalManagement.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.awt.print.Pageable;
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

//        Patient patient = patientRepository.findByName("Nishant Kumar");

//        List<Patient> patientList = patientRepository.findByBirthDateOrEmail(LocalDate.of(2000,05,12),"" +
//                "nishant@example.com");


//        List<Patient> patientList = patientRepository.findByBirthDateBetween(LocalDate.of(1999,01,01),LocalDate.of(2001,01,01));

//        List<Patient> patientList = patientRepository.findByNameContainingOrderByIdDesc("i");

//        List<Patient> patientList = patientRepository.findByBloodGroup(BloodGroupType.A_POSITIVE);

//        List<Patient> patientList = patientRepository.findBornAfterDate(LocalDate.of(2000,01,01));
//
//        for(Patient patient : patientList) {
//            System.out.println(patient);
//        }
//

        //Projection
        List<BloodGroupCountResponseEntity> bloodGroupList = patientRepository.findPatientCountGroupedByBloodGroup();
        for(BloodGroupCountResponseEntity objects: bloodGroupList){
            System.out.println(objects);
        }
//


        int updateName = patientRepository.updateNameWithId("nishant Kudale" , 2L);
        System.out.println(updateName);

        Page<Patient> allPatients = patientRepository.findAllPatient(PageRequest.of(0,2,Sort.by("name")));
        for(Patient patient:allPatients ){
            System.out.println(patient);
        }


    }

}
