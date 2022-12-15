package com.spring.demo.service;

import java.util.List;
import java.util.Optional;

import com.spring.demo.domain.Medicine;

public interface MedicineService {

	public List<Medicine> getAllMedicines();
	
	public Optional<Medicine> findById(Long serial);
	
	public Medicine insertMed(Medicine medicine);

	public Medicine updateMed(Medicine medicine, Long serial);
	
	public void deleteMed(Long serial);
}
