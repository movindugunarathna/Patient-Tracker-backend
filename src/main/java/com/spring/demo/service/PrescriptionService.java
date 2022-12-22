package com.spring.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.spring.demo.domain.Prescription;

public interface PrescriptionService {
	public List<Prescription> getAllPrescriptions();

	public ResponseEntity<Object> findById(Long id);

	public ResponseEntity<Object> createPrescription(Prescription prescription);

	public ResponseEntity<Object> updatePrescription(Prescription prescription, Long id);

	public ResponseEntity<Object> deletePrescription(Long id);
}
