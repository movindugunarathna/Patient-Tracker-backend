package com.spring.demo.service_impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.demo.domain.Patient;
import com.spring.demo.repository.PatientRepository;
import com.spring.demo.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientRepository patientRepository;

	@Override
	public List<Patient> getAllPatients() {
		return patientRepository.findAll();
	}

	@Override
	public Optional<Patient> findById(Long id) {
		return patientRepository.findById(id);
	}

	@Override
	public Patient insertPatient(Patient patient) {
		return patientRepository.save(patient);
	}

	@Override
	public Patient updatePatient(Patient patient, Long id) {
		Optional<Patient> findPatient = patientRepository.findById(id);

		if (findPatient != null) {
			return patientRepository.save(patient);
		}
		return null;
	}

	@Override
	public void deletePatient(Long id) {
		try {
			patientRepository.deleteById(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
