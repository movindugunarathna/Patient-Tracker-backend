package com.spring.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.demo.domain.Doctor;
import com.spring.demo.repository.DoctorRepository;

import jakarta.validation.Valid;

public interface DoctorService {
	
	public Doctor getDoctorById(Long doctorID);
	
	public List<Doctor> getDoctor();

	public Doctor createDoctor(Doctor doctor);
	
	public void deleteDoctor(Long doctorID);

	public Doctor updateDoctor(Doctor doctor);

	

}
