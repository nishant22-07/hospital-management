package com.codingSpring.hospitalManagement.repository;

import com.codingSpring.hospitalManagement.dto.BloodGroupCountResponseEntity;
import com.codingSpring.hospitalManagement.entity.Patient;
import com.codingSpring.hospitalManagement.entity.type.BloodGroupType;
import jakarta.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    Patient findByName(String name);
    List<Patient> findByBirthDateOrEmail(LocalDate birthDate , String email);

    List<Patient> findByBirthDateBetween(LocalDate startDate , LocalDate endDate);

    List<Patient> findByNameContaining(String Query);

    List<Patient> findByNameContainingOrderByIdDesc(String Query);

    @Query("SELECT p FROM Patient p where p.bloodGroup = ?1")
    List<Patient> findByBloodGroup(@Param("bloodGroup") BloodGroupType bloodGroup);

    @Query("SELECT p FROM Patient p WHERE p.birthDate > :birthDate")
    List<Patient> findBornAfterDate(@Param("birthDate") LocalDate date);

    @Query("Select new com.codingSpring.hospitalManagement.dto.BloodGroupCountResponseEntity(p.bloodGroup" +
            " , Count(p))  from Patient p GROUP BY p.bloodGroup")
//    List<Object[]> findPatientCountGroupedByBloodGroup();
    List<BloodGroupCountResponseEntity> findPatientCountGroupedByBloodGroup();


    @Query(value = "select * from patient" , nativeQuery = true)
    Page<Patient> findAllPatient(Pageable pageable);

    @Transactional
    @Modifying
    @Query("update Patient p set p.name = :name where p.id = :id")
    int updateNameWithId(@Param("name") String name,@Param("id") Long id);
}
