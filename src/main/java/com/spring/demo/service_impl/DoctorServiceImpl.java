package com.spring.demo.service_impl;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.spring.demo.controller.DoctorController;
import com.spring.demo.domain.Doctor;
import com.spring.demo.exception.DoctorNotFoundException;
import com.spring.demo.repository.DoctorRepository;
import com.spring.demo.service.DoctorService;

import jakarta.validation.Valid;

@Service
public class DoctorServiceImpl implements DoctorService {
	
		@Autowired
		DoctorRepository docRepo;
		
		static Logger logger = Logger.getLogger(DoctorController.class.getName());
		
		public Doctor getDoctorById(@PathVariable("doctorId") Long doctorID) {
			logger.info("DoctorServiceImple");
			
			return docRepo.findById(doctorID).orElseThrow(()-> new DoctorNotFoundException("Doctor Not Found"));
		}
		
		
		public List<Doctor> getDoctor(){
			logger.info("DoctorServiceImpl");
			
			return docRepo.findAll();
		}

		public Doctor createDoctor(@Valid @RequestBody Doctor doctor) {
			logger.info("DoctorServiceImpl");
			
			return docRepo.save(doctor);
		}
		
		public void deleteDoctor(@PathVariable("doctorId") Long doctorId) {
			logger.info("DoctorServiceImpl");
			
			docRepo.findById(doctorId).orElseThrow(()-> new DoctorNotFoundException("Doctor Not Found"));
			docRepo.deleteById(doctorId);
		}
		
		

		public Doctor updateDoctor(Doctor doctor) {
			logger.info("DoctorServiceImpl");
			
			docRepo.findById(doctor.getDoctorId()).orElseThrow(()-> new DoctorNotFoundException("Doctor Not Found"));
			
			return docRepo.save(doctor);
		}

}
