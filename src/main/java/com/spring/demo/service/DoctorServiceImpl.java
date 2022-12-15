package com.spring.demo.service;

import com.spring.demo.domain.Doctor;
import com.spring.demo.domain.Medicine;
import com.spring.demo.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public Optional<Doctor> findById(Long id) {
        return doctorRepository.findById(id);
    }

    @Override
    public Doctor createNewDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor updateDoctor(Doctor doctor, Long id) {
        Optional<Doctor> findDoctor = doctorRepository.findById(id);

        Doctor updatedDoctor = null;
        if (findDoctor.isPresent()) {
            updatedDoctor = doctorRepository.save(doctor);
        }
        return updatedDoctor;
    }

    @Override
    public void removeDoctor(Long id) {
        doctorRepository.deleteById(id);
    }
}
