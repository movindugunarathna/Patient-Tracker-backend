package com.spring.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.demo.domain.Patient;
import com.spring.demo.repository.PatientRepository;

@RestController
@RequestMapping(value = "/patient")
public class PatientController {
	@Autowired
	private PatientRepository patientRepository;
	
	 @GetMapping(value = "/list")
	    public List<Patient> fetchAll() {
	        return patientRepository.findAll();
	    }

	    @PostMapping(value = "/add")
	    public Patient add(@RequestBody Patient p) {
	        return patientRepository.save(p);
	    }

	    @GetMapping(value = "/find/{id}")
	    public Optional<Patient> findById(@PathVariable Long id) {
	        return patientRepository.findById(id);
	    }

	    @DeleteMapping(value = "/remove/{id}")
	    public boolean deleteById(@PathVariable Long id) {
	        try {
	        	patientRepository.deleteById(id);
	            return true;
	        } catch (Exception e) {
	            return false;
	        }
	    }
}
