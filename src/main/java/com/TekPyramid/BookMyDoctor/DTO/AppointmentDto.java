package com.TekPyramid.BookMyDoctor.DTO;

import com.TekPyramid.BookMyDoctor.Entity.Doctor;
import com.TekPyramid.BookMyDoctor.Entity.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;


@Data
public class AppointmentDto {

    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
    private Doctor doctor;
    private User user;
}
