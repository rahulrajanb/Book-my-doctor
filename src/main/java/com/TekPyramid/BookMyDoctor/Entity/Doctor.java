package com.TekPyramid.BookMyDoctor.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int doctorId;

    @NotBlank(message = "Enter your Name")
    private String doctorName;

    @NotBlank(message = "Enter your Role")
    private String role;

    private int yearsOfExperience;

    @NotBlank(message = "Enter your Location")
    private String location;

    @Column(unique = true)
    private long doctorMobileNumber;

    @Email(message = "Enter a valid Email")
    @NotBlank(message = "Email is required")
    @Column(unique = true)
    private String doctorEmail;

    @NotBlank(message = "Password is required")
    private String doctorPassword;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    private List<Appointment> appointments;
}
