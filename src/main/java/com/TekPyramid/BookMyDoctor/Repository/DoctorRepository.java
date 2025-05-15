package com.TekPyramid.BookMyDoctor.Repository;

import com.TekPyramid.BookMyDoctor.Entity.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
    Doctor findByDoctorName(String doctorName);
    Doctor findByDoctorEmail(String doctorEmail);

    Page<Doctor> findAll(Pageable pageable);
    List<Doctor> findByLocationIgnoreCase(String location);

}
