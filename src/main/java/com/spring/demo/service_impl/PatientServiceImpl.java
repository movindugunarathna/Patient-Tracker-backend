package com.spring.demo.service_impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.demo.domain.Patient;
import com.spring.demo.exception.PatientNotFoundException;
import com.spring.demo.repository.PatientRepository;
import com.spring.demo.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {

	private static final Logger logger = LoggerFactory.getLogger(PatientServiceImpl.class);

	@Autowired
	private PatientRepository patientRepository;

	@Override
	public ResponseEntity<Object> getAllPatients() {
		logger.info("Patient list retrieved.");
		return new ResponseEntity<>(patientRepository.findAll(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> findById(Long id) throws PatientNotFoundException{
		Patient patient = patientRepository.findById(id).get();
		logger.info("Get patient by patient ID.");
		return new ResponseEntity<>(patient, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> insertPatient(Patient patient) {
		patientRepository.save(patient);
		logger.info("Patient Added Successfully.");
		return new ResponseEntity<>("Patient Added Successfully.", HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<Object> updatePatient(Patient patient, Long id) {
		Optional<Patient> findPatient = patientRepository.findById(id);

		if (findPatient != null) {
			patient.setPatientId(id);
			patientRepository.save(patient);
			logger.info("Update patient details using patient ID.");
			return new ResponseEntity<>("Patient updated successsfully", HttpStatus.OK);
		}
		return null;
	}

	@Override
	public ResponseEntity<Object> deletePatient(Long id) {
		try {
			patientRepository.deleteById(id);
			logger.warn("Delete patient by patient ID.");
			return new ResponseEntity<>("Patient deleted successsfully", HttpStatus.OK);
		} catch (Exception e) {
			logger.warn(e.getLocalizedMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	//
//	public Doctor assignPatients(Long doctorId, Long patientId) {
//		
//		Set<Patient> patientSet = null;
//		
//		Doctor doc = doctorRepository.findById(doctorId).get();
//		Patient patient = patientRepository.findById(patientId).get();
//		
//		patientSet = doc.getPatientList();
//		patientSet.add(patient);
//		doc.setPatientList(patientSet);
//		return doctorRepository.save(doc);
//		
//	}
}
