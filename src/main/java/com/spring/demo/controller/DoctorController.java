package com.spring.demo.controller;

import com.spring.demo.domain.Doctor;
import com.spring.demo.repository.DoctorRepository;
import com.spring.demo.service_impl.DoctorServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/doctor")
public class DoctorController {
    @Autowired
    private DoctorServiceImpl doctorServiceImpl;

    @GetMapping(value = "/list")
    public List<Doctor> fetchAll() {
        return doctorServiceImpl.getAllDoctors();
    }

    @PostMapping(value = "/add")
    public Doctor doctor(@RequestBody Doctor d) {
        return doctorServiceImpl.createNewDoctor(d);
    }

    @GetMapping(value = "/find/{id}")
    public Optional<Doctor> findById(@PathVariable Long id) {
        return doctorServiceImpl.findById(id);
    }

    @DeleteMapping(value = "/remove/{id}")
    public boolean deleteById(@PathVariable Long id) {
        try {
            doctorServiceImpl.removeDoctor(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @PutMapping(value = "/update/{id}")
    public Doctor updateDoctor(@RequestBody Doctor updateDoctor, @PathVariable Long id) {
        return doctorServiceImpl.updateDoctor(updateDoctor, id);
    }
    
//	@PutMapping(value = "/{doctorId}/assign/{patientId}")
//	public Doctor assignPatients(@PathVariable Long doctorId, @PathVariable Long patientId) {
//		return doctorServiceImpl.assignPatients(doctorId, patientId);
//	}
}