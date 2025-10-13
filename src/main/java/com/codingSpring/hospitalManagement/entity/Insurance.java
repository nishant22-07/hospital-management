package com.codingSpring.hospitalManagement.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Insurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "ID")
    private Long id;

    @Column(name = "Policy Number",nullable = false, length = 50)
    private String policyNumber;

    @Column(name = "Provider",nullable = false, length = 100)
    private String provider;

    @Column(name= "Validity Date" ,nullable = false)
    private LocalDate validUntil;

    @CreationTimestamp
    @Column(name="Creation time and date",nullable = false,updatable = false)
    private LocalDateTime createdAt;

    @OneToOne(mappedBy = "insurance") //inverse side
    private  Patient patient;

}
