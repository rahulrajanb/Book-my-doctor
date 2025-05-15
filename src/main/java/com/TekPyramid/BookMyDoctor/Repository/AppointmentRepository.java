package com.TekPyramid.BookMyDoctor.Repository;

import com.TekPyramid.BookMyDoctor.Entity.Appointment;
import com.TekPyramid.BookMyDoctor.Entity.Doctor;
import com.TekPyramid.BookMyDoctor.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
    List<Appointment> findByDoctor(Doctor doctor);
    List<Appointment> findByUser(User user);
}
