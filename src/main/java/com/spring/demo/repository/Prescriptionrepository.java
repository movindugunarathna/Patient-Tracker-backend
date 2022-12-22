package com.spring.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.demo.domain.Prescription;

@Repository(value = "presRepository")
public interface Prescriptionrepository extends JpaRepository<Prescription, Long> {

}
