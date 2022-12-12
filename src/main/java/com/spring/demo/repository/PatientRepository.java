package com.spring.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.demo.domain.Patient;

@Repository(value = "patientRepository")
public interface PatientRepository extends JpaRepository<Patient, Long> {

}
