package com.spring.demo.service_impl;

import org.jboss.logging.Logger;

import com.spring.demo.domain.Doctor;
import com.spring.demo.domain.Medicine;
import com.spring.demo.domain.Patient;
import com.spring.demo.repository.DoctorRepository;
import com.spring.demo.repository.PatientRepository;
import com.spring.demo.service.DoctorService;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {
	
    @Autowired
    DoctorRepository docRepo;
    
    @Autowired
    PatientRepository patientRepository;

    public Doctor getDoctorById(@PathVariable("doctorId") Long doctorID) {
			logger.info("DoctorServiceImpl +++  GetDoctorByID");
			
			return docRepo.findById(doctorID).orElseThrow(()-> new DoctorNotFoundException("Doctor Not Found"));
		}
		
		
		public List<Doctor> getDoctor(){
			logger.info("DoctorServiceImpl ++++ GetDoctor");
			
			return docRepo.findAll();
		}

		public Doctor createDoctor(@Valid @RequestBody Doctor doctor) {
			logger.info("DoctorServiceImpl ++++ CreateDoctor");
			
			return docRepo.save(doctor);
		}
		
		public void deleteDoctor(@PathVariable("doctorId") Long doctorId) {
			logger.info("DoctorServiceImpl +++ DeleteDoctor");
			
			docRepo.findById(doctorId).orElseThrow(()-> new DoctorNotFoundException("Doctor Not Found"));
			docRepo.deleteById(doctorId);
		}
		
		

		public Doctor updateDoctor(Doctor doctor) {
			logger.info("DoctorServiceImpl +++ UpdateDoctor");
			
			docRepo.findById(doctor.getDoctorId()).orElseThrow(()-> new DoctorNotFoundException("Doctor Not Found"));
			
			return docRepo.save(doctor);
		}
    

	public Doctor assignPatients(Long doctorId, Long patientId) {
		
		Set<Patient> patientSet = null;
		
		Doctor doc = docRepo.findById(doctorId).get();
		Patient patient = patientRepository.findById(patientId).get();
		
		patientSet = doc.getPatientList();
		patientSet.add(patient);
		doc.setPatientList(patientSet);
		return docRepo.save(doc);
		
	}

}
