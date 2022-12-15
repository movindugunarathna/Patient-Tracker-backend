package com.spring.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.demo.domain.Medicine;

@Repository("medicineRepository")
public interface MedicineRepository extends JpaRepository<Medicine, Long>{

}
