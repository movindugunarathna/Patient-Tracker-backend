package com.spring.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.spring.demo.domain.Patient;
import com.spring.demo.exception.PatientNotFoundException;

public interface PatientService {

	public ResponseEntity<Object> findById(Long id) throws Exception;

	public ResponseEntity<Object> insertPatient(Patient patient);

	public ResponseEntity<Object> updatePatient(Patient patient, Long id) throws PatientNotFoundException;

	public ResponseEntity<Object> deletePatient(Long id);

	ResponseEntity<Object> getAllPatients();

}
