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

import com.spring.demo.domain.Prescription;
import com.spring.demo.service_impl.PrescriptionServiceImpl;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

@RestController
@RequestMapping(value = "/prescription")
public class PrescriptionController {
	@Autowired
	PrescriptionServiceImpl prescriptionServiceImpl;

	@GetMapping(value = "/list")
	public List<Prescription> getAllBills() {
		return prescriptionServiceImpl.getAllPrescriptions();
	}

	@GetMapping(value = "/find/{id}")
	public Optional<Prescription> findById(@PathVariable @Positive Long id) {
		return prescriptionServiceImpl.findById(id);
	}

	@PostMapping(value = "/add")
	public Prescription insertPrescription(@RequestBody @Valid Prescription prescription) {
		return prescriptionServiceImpl.createPrescription(prescription);
	}

	@PutMapping(value = "/update/{id}")
	public Prescription updatePrescription(@RequestBody @Valid Prescription prescription,
			@PathVariable @Positive Long id) {
		return prescriptionServiceImpl.updatePrescription(prescription, id);
	}

	@DeleteMapping(value = "/delete/{id}")
	public void deletePrescription(@PathVariable @Positive Long id) {
		prescriptionServiceImpl.deletePrescription(id);
	}
}
