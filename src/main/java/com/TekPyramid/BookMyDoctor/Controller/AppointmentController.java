package com.TekPyramid.BookMyDoctor.Controller;

import com.TekPyramid.BookMyDoctor.DTO.AppointmentDto;
import com.TekPyramid.BookMyDoctor.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    //-----------------------------------------------------------------------------------------------------------------> 1. MAKING APPOINTMENTS
    @PostMapping("/book")
    public String  bookAppointment(@RequestBody AppointmentDto appointmentDto) {
        AppointmentDto created = appointmentService.bookAppointment(appointmentDto);
        return "Appointmanet booked";
    }
}
