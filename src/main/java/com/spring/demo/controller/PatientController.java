package com.spring.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.demo.domain.Patient;
import com.spring.demo.exception.PatientNotFoundException;
import com.spring.demo.service_impl.PatientServiceImpl;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

@RestController
@RequestMapping(value = "/patient")
public class PatientController {

	private static final Logger logger = LoggerFactory.getLogger(PatientController.class);

	@Autowired
	private PatientServiceImpl patientServiceImpl;

	@GetMapping(value = "/all")
	public ResponseEntity<Object> getAllPatient() {
		return patientServiceImpl.getAllPatients();
	}

	@GetMapping(value = "/find/{id}")
	public ResponseEntity<Object> findById(@PathVariable @Positive Long id) throws Exception {
		return patientServiceImpl.findById(id);
	}

	@PostMapping(value = "/add")
	public ResponseEntity<Object> insertPatient(@RequestBody @Valid Patient patient) {
		return patientServiceImpl.insertPatient(patient);
	}

	@PutMapping(value = "/update/{id}")
	public ResponseEntity<Object> updatePatient(@RequestBody @Valid Patient patient, @PathVariable @Positive Long id) throws PatientNotFoundException {
		return patientServiceImpl.updatePatient(patient, id);	
	}

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Object> deletePatient(@PathVariable @Positive Long id) {
		return patientServiceImpl.deletePatient(id);
	}

}
