package com.TekPyramid.BookMyDoctor.DTO;

import com.TekPyramid.BookMyDoctor.Entity.Appointment;
import com.TekPyramid.BookMyDoctor.Entity.Doctor;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;


@Data
public class UserDto {


    private String userName;
    private int age;
    private String city;
    private String State;
    private String email;
    private String password;
    private String gender;
    private long mobileNumber;
    private List<Appointment> appointments;
}
