package com.TekPyramid.BookMyDoctor.DTO;

import com.TekPyramid.BookMyDoctor.Entity.Appointment;
import lombok.Data;

import java.util.List;

@Data
public class DoctorDto {
    private String doctorName;
    private String role;
    private int yearsOfExperience;
    private String location;
    private long doctorMobileNumber;
    private String doctorEmail;
    private String doctorPassword;
    private List<Appointment> appointments;
}
