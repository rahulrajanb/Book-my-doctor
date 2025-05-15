package com.TekPyramid.BookMyDoctor.Entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int appointmentId;

    private LocalDate appointmentDate;
    private LocalTime appointmentTime;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
   private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;



}
