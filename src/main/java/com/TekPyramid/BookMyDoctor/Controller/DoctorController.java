package com.TekPyramid.BookMyDoctor.Controller;

import com.TekPyramid.BookMyDoctor.DTO.DoctorAppointmentResponseDto;
import com.TekPyramid.BookMyDoctor.DTO.DoctorDto;
import com.TekPyramid.BookMyDoctor.DTO.DoctorLoginRequestDTO;
import com.TekPyramid.BookMyDoctor.Service.DoctorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorServiceImpl doctorService;

    //-----------------------------------------------------------------------------------------------------------------> 1. ADDING DOCTOR DETAILS TO DATABASE (OR) SIGNUP
    @PostMapping("/add")
    public String addDoctor(@RequestBody DoctorDto doctorDto) {
        DoctorDto savedDoctor = doctorService.addDoctor(doctorDto);
        return "Doctors added successfully";
    }


    //-----------------------------------------------------------------------------------------------------------------> 2. DOCTOR LOGIN
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody DoctorLoginRequestDTO loginRequestDTO) {
        boolean isValid = doctorService.login(loginRequestDTO.getDoctorEmail(), loginRequestDTO.getDoctorPassword());
        if (isValid) {
            return ResponseEntity.ok(Map.of("message", "Login Successful"));
        } else {
            return ResponseEntity.status(401).body(Map.of("message", "Invalid input"));
        }
    }

    //----------------------------------------------------------------------------------------------------------------->  3.FETCHING ALL DOCTORS
    @GetMapping("/all")
    public ResponseEntity<Page<DoctorDto>> getAllDoctors(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        Page<DoctorDto> doctorPage = doctorService.getAllDoctors(page, size);
        return ResponseEntity.ok(doctorPage);
    }

    //----------------------------------------------------------------------------------------------------------------->  4.FETCHING ALL DOCTORS BASED ON LOCATION
    @GetMapping("/location")
    public List<DoctorDto> getDoctorsByLocation(@RequestParam String location) {
        return doctorService.getDoctorsByLocation(location);
    }


    //----------------------------------------------------------------------------------------------------------------->  5. APPOINTMENT LIST FETCHING (DOCTOR's POV)
    @GetMapping("/{doctorId}/appointments")
    public DoctorAppointmentResponseDto getAppointmentsForDoctor(@PathVariable int doctorId) {
        return doctorService.getAppointmentsByDoctorId(doctorId);
    }
}
