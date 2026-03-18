package com.codingSpring.hospitalManagement.service;


import com.codingSpring.hospitalManagement.entity.Appointment;
import com.codingSpring.hospitalManagement.entity.Doctor;
import com.codingSpring.hospitalManagement.entity.Patient;
import com.codingSpring.hospitalManagement.repository.AppointmentRepository;
import com.codingSpring.hospitalManagement.repository.DoctorRepository;
import com.codingSpring.hospitalManagement.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final PatientService patientService;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Appointment createNewAppointment(Appointment appointment,Long doctorID, Long patientID){
        Doctor doctor = doctorRepository.findById(doctorID).orElseThrow();
        Patient patient = patientRepository.findById(patientID).orElseThrow();

        if(appointment.getId() != null) throw new IllegalArgumentException("Appointment already exists");

        appointment.setDoctor(doctor);
        appointment.setPatient(patient);

        patient.getAppointments().add(appointment);// To maintain bidirectional consistency

        return appointmentRepository.save(appointment);

    }
}











