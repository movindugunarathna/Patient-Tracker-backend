package com.spring.demo.controller;

import com.spring.demo.domain.Admin;
import com.spring.demo.domain.Doctor;
import com.spring.demo.repository.AdminRepository;
import com.spring.demo.repository.DoctorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/doctor")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    @GetMapping(value = "/list")
    public List<Doctor> fetchAll() {
        return doctorRepository.findAll();
    }

    @PostMapping(value = "/add")
    public Doctor doctor(@RequestBody Doctor d) {
        return doctorRepository.save(d);
    }

    @GetMapping(value = "/find/{id}")
    public Optional<Doctor> findById(@PathVariable Long id) {
        return doctorRepository.findById(id);
    }

    @DeleteMapping(value = "/remove/{id}")
    public boolean deleteById(@PathVariable Long id) {
        try {
            doctorRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}