package com.TekPyramid.BookMyDoctor.DTO;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class DoctorAppointmentDetailDto {
    private String userName;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
}
