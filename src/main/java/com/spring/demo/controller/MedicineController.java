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
import com.spring.demo.service.MedicineService;
import com.spring.demo.service.MedicineServiceImpl;

@RestController
@RequestMapping(value = "/medicine")
public class MedicineController {

	@Autowired
	private MedicineServiceImpl medicineServiceImpl;

	@GetMapping(value = "/all")
	public List<Medicine> getAllMedicines() {
		return medicineServiceImpl.getAllMedicines();
	}

	@GetMapping(value = "/find/{serial}")
	public Optional<Medicine> findById(@PathVariable Long serial) {
		return medicineServiceImpl.findById(serial);
	}

	@PostMapping(value = "/add")
	public Medicine insertMed(Medicine medicine) {
		return medicineServiceImpl.insertMed(medicine);
	}

	@PutMapping(value = "/update/{serial}")
	public Medicine updateMed(Medicine medicine, @PathVariable Long serial) {
		return medicineServiceImpl.updateMed(medicine, serial);	
	}

	@DeleteMapping(value = "/delete/{serial}")
	public void deleteMed(@PathVariable Long serial) {
		medicineServiceImpl.deleteMed(serial);
	}
}
