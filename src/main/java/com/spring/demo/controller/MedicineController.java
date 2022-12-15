package com.spring.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.demo.domain.Medicine;
import com.spring.demo.repository.MedicineRepository;

@RestController
@RequestMapping(value = "/medicine")
public class MedicineController {
	
	@Autowired
	private MedicineRepository medicineRepository;
	
	@GetMapping(value = "/all")
	public List<Medicine> getAllMedicines() {
		return medicineRepository.findAll();
	}
	
	@GetMapping(value = "/find/{serial}")
	public Optional<Medicine> findById(@PathVariable Long serial) {
		return medicineRepository.findById(serial);
	}
	
	@PostMapping(value = "/add")
	public Medicine insertMed(Medicine medicine) {
		System.out.println(medicine.getSerialNumber());
		return medicineRepository.save(medicine);
	}

	@PutMapping(value = "/update/{serial}")
	public Medicine updateMed(Medicine medicine, @PathVariable Long serial) {

		Optional<Medicine> med = medicineRepository.findById(serial);
		
		if(med != null) {
			//medicineRepository.deleteById(serial);
			return medicineRepository.save(medicine);
		}
		return null;
	}
	
	@DeleteMapping(value = "/delete/{serial}")
	public boolean deleteMed(@PathVariable Long serial) {
		try {
			medicineRepository.deleteById(serial);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
}
