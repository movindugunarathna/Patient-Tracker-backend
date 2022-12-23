package com.spring.demo.service_impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.demo.domain.Doctor;
import com.spring.demo.domain.Prescription;
import com.spring.demo.exception.PrescriptionNotFoundException;
import com.spring.demo.repository.Prescriptionrepository;
import com.spring.demo.service.PrescriptionService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PrescriptionServiceImpl implements PrescriptionService {
	private static final Logger logger = LoggerFactory.getLogger(PrescriptionServiceImpl.class);
	
	@Autowired
	Prescriptionrepository presRepository;

	@Override
	public List<Prescription> getAllPrescriptions() {
		logger.info("Prescription list retrieved");
		return presRepository.findAll();
	}

	@Override
	public ResponseEntity<Object> findById(Long id) {
		Prescription findPrescription = presRepository.findById(id).orElseThrow(()-> new PrescriptionNotFoundException());
		logger.info("Get prescription by ID");
		return new ResponseEntity<>(findPrescription, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> createPrescription(Prescription prescription) {
		presRepository.save(prescription);
		logger.info("Prescription added successfully");
		return new ResponseEntity<>("Prescription added successfully", HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<Object> updatePrescription(Prescription prescription, Long id) {
		Prescription findPrescription = presRepository.findById(id).get();

		if (findPrescription != null) {
//			prescription.setPrescriptionId(id);
			presRepository.save(prescription);
			logger.info("Prescription with ID " + id + " updated successfully");
			return new ResponseEntity<>("Prescription updated successsfully", HttpStatus.OK);
		}
		return null;
	}

	@Override
	public ResponseEntity<Object> deletePrescription(Long id) {
		try {
			presRepository.deleteById(id);
			logger.warn("Prescription with ID " + id + " deleted successfully");
			return new ResponseEntity<>("Prescription deleted successsfully", HttpStatus.OK);
		} catch (Exception e) {
			logger.warn(e.getLocalizedMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

}
