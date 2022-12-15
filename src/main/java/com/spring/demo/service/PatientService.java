package com.spring.demo.service;
import java.util.List;
import java.util.Optional;

import com.spring.demo.domain.Patient;

public interface PatientService {

		public Optional<Patient> findById(Long id);
		
		public Patient insertPatient(Patient patient);

		public Patient updatePatient(Patient patient, Long id);
		
		public void deletePatient(Long id);

		List<Patient> getAllPatients();

}
