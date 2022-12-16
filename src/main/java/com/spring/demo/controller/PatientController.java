package com.spring.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.demo.domain.Patient;
import com.spring.demo.service_impl.PatientServiceImpl;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

@RestController
@RequestMapping(value = "/patient")
public class PatientController {

	@Autowired
	private PatientServiceImpl patientServiceImpl;

	@GetMapping(value = "/all")
	public List<Patient> getAllPatient() {
		return patientServiceImpl.getAllPatients();
	}

	@GetMapping(value = "/find/{id}")
	public Optional<Patient> findById(@PathVariable @Positive Long id) {
		return patientServiceImpl.findById(id);
	}

	@PostMapping(value = "/add")
	public Patient insertPatient(@RequestBody @Valid Patient patient) {
		return patientServiceImpl.insertPatient(patient);
	}

	@PutMapping(value = "/update/{id}")
	public Patient updatePatient(@RequestBody @Valid Patient patient, @PathVariable @Positive Long id) {
		return patientServiceImpl.updatePatient(patient, id);	
	}

	@DeleteMapping(value = "/delete/{id}")
	public void deletePatient(@PathVariable @Positive Long id) {
		patientServiceImpl.deletePatient(id);
	}
}
