package com.TekPyramid.BookMyDoctor.Service;

import com.TekPyramid.BookMyDoctor.DTO.AppointmentDto;
import com.TekPyramid.BookMyDoctor.Entity.Appointment;
import com.TekPyramid.BookMyDoctor.Entity.Doctor;
import com.TekPyramid.BookMyDoctor.Entity.User;
import com.TekPyramid.BookMyDoctor.Repository.AppointmentRepository;
import com.TekPyramid.BookMyDoctor.Repository.DoctorRepository;
import com.TekPyramid.BookMyDoctor.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public AppointmentDto bookAppointment(AppointmentDto dto) {
        Doctor doctor = doctorRepository.findById(dto.getDoctor().getDoctorId())
                .orElseThrow(() -> new RuntimeException("Doctor not found"));
        User user = userRepository.findById(dto.getUser().getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Appointment appointment = Appointment.builder()
                .appointmentDate(dto.getAppointmentDate())
                .appointmentTime(dto.getAppointmentTime())
                .doctor(doctor)
                .user(user)
                .build();

        Appointment saved = appointmentRepository.save(appointment);

        // Populate DTO to return
        AppointmentDto responseDto = new AppointmentDto();
        responseDto.setAppointmentDate(saved.getAppointmentDate());
        responseDto.setAppointmentTime(saved.getAppointmentTime());
        responseDto.setDoctor(saved.getDoctor());
        responseDto.setUser(saved.getUser());

        return responseDto;
    }
}
