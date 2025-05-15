package com.TekPyramid.BookMyDoctor.Service;

import com.TekPyramid.BookMyDoctor.DTO.DoctorAppointmentDetailDto;
import com.TekPyramid.BookMyDoctor.DTO.DoctorAppointmentResponseDto;
import com.TekPyramid.BookMyDoctor.DTO.DoctorDto;
import com.TekPyramid.BookMyDoctor.Entity.Doctor;
import com.TekPyramid.BookMyDoctor.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    private Doctor convertToEntity(DoctorDto doctorDto) {
        return Doctor.builder()
                .doctorName(doctorDto.getDoctorName())
                .role(doctorDto.getRole())
                .yearsOfExperience(doctorDto.getYearsOfExperience())
                .location(doctorDto.getLocation())
                .doctorMobileNumber(doctorDto.getDoctorMobileNumber())
                .doctorEmail(doctorDto.getDoctorEmail())
                .doctorPassword(doctorDto.getDoctorPassword())
                .build();
    }

    private DoctorDto convertToDto(Doctor doctor) {
        DoctorDto doctorDto = new DoctorDto();
        doctorDto.setDoctorName(doctor.getDoctorName());
        doctorDto.setRole(doctor.getRole());
        doctorDto.setYearsOfExperience(doctor.getYearsOfExperience());
        doctorDto.setLocation(doctor.getLocation());
        doctorDto.setDoctorMobileNumber(doctor.getDoctorMobileNumber());
        doctorDto.setDoctorEmail(doctor.getDoctorEmail());
        doctorDto.setDoctorPassword(doctor.getDoctorPassword());
        return doctorDto;
    }

    @Override
    public DoctorDto addDoctor(DoctorDto doctorDto) {
        Doctor doctor = convertToEntity(doctorDto);
        Doctor savedDoctor = doctorRepository.save(doctor);
        return convertToDto(savedDoctor);
    }

    @Override
    public boolean login(String email, String password) {
        Doctor doctor = doctorRepository.findByDoctorEmail(email);
        return doctor != null && doctor.getDoctorPassword().equals(password);
    }

    @Override
    public Page<DoctorDto> getAllDoctors(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("doctorName").ascending());
        Page<Doctor> doctorPage = doctorRepository.findAll(pageable);

        List<DoctorDto> dtoList = doctorPage.getContent().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());

        return new PageImpl<>(dtoList, pageable, doctorPage.getTotalElements());
    }

    @Override
    public List<DoctorDto> getDoctorsByLocation(String location) {
        List<Doctor> doctors = doctorRepository.findByLocationIgnoreCase(location);
        return doctors.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public DoctorAppointmentResponseDto getAppointmentsByDoctorId(int doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        List<DoctorAppointmentDetailDto> appointmentDtos = doctor.getAppointments().stream()
                .map(appointment -> {
                    DoctorAppointmentDetailDto dto = new DoctorAppointmentDetailDto();
                    dto.setUserName(appointment.getUser().getUserName());
                    dto.setAppointmentDate(appointment.getAppointmentDate());
                    dto.setAppointmentTime(appointment.getAppointmentTime());
                    return dto;
                })
                .collect(Collectors.toList());

        DoctorAppointmentResponseDto response = new DoctorAppointmentResponseDto();
        response.setDoctorId(doctor.getDoctorId());
        response.setDoctorName(doctor.getDoctorName());
        response.setTotalAppointments(appointmentDtos.size());
        response.setAppointments(appointmentDtos);

        return response;
    }


}
