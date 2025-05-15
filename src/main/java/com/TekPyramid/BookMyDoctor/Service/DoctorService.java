package com.TekPyramid.BookMyDoctor.Service;

import com.TekPyramid.BookMyDoctor.DTO.DoctorAppointmentResponseDto;
import com.TekPyramid.BookMyDoctor.DTO.DoctorDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DoctorService {
    DoctorDto addDoctor(DoctorDto doctorDto);
    boolean login(String email, String password);
    Page<DoctorDto> getAllDoctors(int page, int size);
    List<DoctorDto> getDoctorsByLocation(String location);
    DoctorAppointmentResponseDto getAppointmentsByDoctorId(int doctorId);


}
