package com.TekPyramid.BookMyDoctor.DTO;

import lombok.Data;

import java.util.List;

@Data
public class DoctorAppointmentResponseDto {
    private int doctorId;
    private String doctorName;
    private int totalAppointments;
    private List<DoctorAppointmentDetailDto> appointments;
}
