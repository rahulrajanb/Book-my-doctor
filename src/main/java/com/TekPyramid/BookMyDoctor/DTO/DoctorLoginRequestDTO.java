package com.TekPyramid.BookMyDoctor.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoctorLoginRequestDTO {
    private String doctorEmail;
    private String doctorPassword;
}
