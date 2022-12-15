package com.spring.demo.service;

import com.spring.demo.domain.Doctor;
import com.spring.demo.domain.Medicine;

import java.util.List;
import java.util.Optional;

public interface DoctorService {
    List<Doctor> getAllDoctors();

    Optional<Doctor> findById(Long id);

    Doctor createNewDoctor(Doctor doctor);

    Doctor updateDoctor(Doctor doctor, Long id);

    void removeDoctor(Long id);
}
