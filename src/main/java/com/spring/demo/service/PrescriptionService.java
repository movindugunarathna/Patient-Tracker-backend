package com.spring.demo.service;

import java.util.List;
import java.util.Optional;

import com.spring.demo.domain.Prescription;

public interface PrescriptionService {
	public List<Prescription> getAllPrescriptions();

	public Optional<Prescription> findById(Long id);

	public Prescription createPrescription(Prescription prescription);

	public Prescription updatePrescription(Prescription prescription, Long id);

	public void deletePrescription(Long id);
}
