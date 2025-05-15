package com.TekPyramid.BookMyDoctor.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    @NotBlank(message = "Enter your Name")
    private String userName;

    @NotNull(message = "Enter your Age")
    private int age;

    @NotBlank(message = "Enter your City")
    private String city;

    @NotBlank(message = "Enter your State")
    private String State;

    @NotBlank(message = "Enter your email")
    @Column(unique = true)
    private String email;


    private String password;

    @NotBlank(message = "Enter your Gender")
    private String gender;


    @Column(unique = true)
    private long mobileNumber;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Appointment> appointments;
}
