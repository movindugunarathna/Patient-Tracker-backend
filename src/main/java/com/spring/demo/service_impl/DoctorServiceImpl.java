package com.spring.demo.service_impl;

import com.spring.demo.domain.Doctor;
import com.spring.demo.domain.Medicine;
import com.spring.demo.domain.Patient;
import com.spring.demo.repository.DoctorRepository;
import com.spring.demo.repository.PatientRepository;
import com.spring.demo.service.DoctorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class DoctorServiceImpl implements DoctorService {
	
    @Autowired
    DoctorRepository doctorRepository;
    
    @Autowired
    PatientRepository patientRepository;

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public Optional<Doctor> findById(Long id) {
        return doctorRepository.findById(id);
    }

    @Override
    public Doctor createNewDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor updateDoctor(Doctor doctor, Long id) {
        Optional<Doctor> findDoctor = doctorRepository.findById(id);

        Doctor updatedDoctor = null;
        if (findDoctor.isPresent()) {
            updatedDoctor = doctorRepository.save(doctor);
        }
        return updatedDoctor;
    }

    @Override
    public void removeDoctor(Long id) {
        doctorRepository.deleteById(id);
    }
    

	public Doctor assignPatients(Long doctorId, Long patientId) {
		
		Set<Patient> patientSet = null;
		
		Doctor doc = doctorRepository.findById(doctorId).get();
		Patient patient = patientRepository.findById(patientId).get();
		
		patientSet = doc.getPatientList();
		patientSet.add(patient);
		doc.setPatientList(patientSet);
		return doctorRepository.save(doc);
		
	}

}
