package com.spring.demo.service;

import com.spring.demo.domain.Doctor;
import com.spring.demo.domain.Medicine;

import java.util.List;
import java.util.Optional;

public interface DoctorService {
    	public Doctor getDoctorById(Long doctorID);
	
	public List<Doctor> getDoctor();

	public Doctor createDoctor(Doctor doctor);
	
	public void deleteDoctor(Long doctorID);

	public Doctor updateDoctor(Doctor doctor);

}
