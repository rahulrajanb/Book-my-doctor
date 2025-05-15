package com.TekPyramid.BookMyDoctor.Service;

import com.TekPyramid.BookMyDoctor.DTO.AppointmentDto;

public interface AppointmentService {
    AppointmentDto bookAppointment(AppointmentDto appointmentDto);
}
