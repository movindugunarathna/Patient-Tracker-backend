package com.spring.demo.service_impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.demo.domain.Doctor;
import com.spring.demo.domain.Prescription;
import com.spring.demo.repository.Prescriptionrepository;
import com.spring.demo.service.PrescriptionService;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {
	@Autowired
	Prescriptionrepository presRepository;

	@Override
	public List<Prescription> getAllPrescriptions() {
		return presRepository.findAll();
	}

	@Override
	public Optional<Prescription> findById(Long id) {
		return presRepository.findById(id);
	}

	@Override
	public Prescription createPrescription(Prescription prescription) {
		return presRepository.save(prescription);
	}

	@Override
	public Prescription updatePrescription(Prescription prescription, Long id) {
		Optional<Prescription> findPres = presRepository.findById(id);

		Prescription updatedPres = null;
		if (findPres.isPresent()) {
			updatedPres = presRepository.save(prescription);
		}
		return updatedPres;
	}

	@Override
	public void deletePrescription(Long id) {
		presRepository.deleteById(id);
	}

}
