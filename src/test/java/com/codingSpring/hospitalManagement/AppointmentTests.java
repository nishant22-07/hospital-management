package com.codingSpring.hospitalManagement;

import com.codingSpring.hospitalManagement.entity.Appointment;
import com.codingSpring.hospitalManagement.repository.AppointmentRepository;
import com.codingSpring.hospitalManagement.service.AppointmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class AppointmentTests {

    @Autowired
    private AppointmentService appointmentService;

    @Test
    public void testCreateAppointment(){
        Appointment appointment = Appointment.builder()
                .appointmentTime(LocalDateTime.now())
                .reason("Cancer")
                .build();

        var newAppointment =  appointmentService.createNewAppointment(appointment,1L,2L);
        System.out.println(newAppointment);
    }


}
