package com.spring.demo.service_impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.demo.domain.Doctor;
import com.spring.demo.domain.Medicine;
import com.spring.demo.domain.Patient;
import com.spring.demo.repository.MedicineRepository;
import com.spring.demo.service.MedicineService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MedicineServiceImpl implements MedicineService{

	private static final Logger logger = LoggerFactory.getLogger(MedicineServiceImpl.class);
	
	@Autowired
	private MedicineRepository medicineRepository;

	@Override
	public List<Medicine> getAllMedicines() {
		logger.info("Medicine list retrieved.");
		return medicineRepository.findAll();
	}

	@Override
	public ResponseEntity<Object> findById(Long serial) {
		Medicine findMedicine = medicineRepository.findById(serial).get();
		logger.info("Get Medicine by serial number.");
		return new ResponseEntity<>(findMedicine, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> insertMed(Medicine medicine) {
		medicineRepository.save(medicine);
		logger.info("Medicine added successfully");
		return new ResponseEntity<>("Medicine added successfully", HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<Object> updateMed(Medicine medicine, Long serial) {
		Medicine findMedicine = medicineRepository.findById(serial).get();

		if (findMedicine != null) {
			medicine.setSerialNumber(serial);
			medicineRepository.save(medicine);
			logger.info("Update medicine details using medicine ID.");
			return new ResponseEntity<>("Medicine updated successsfully", HttpStatus.OK);
		}
		return null;
	}

	@Override
	public ResponseEntity<Object> deleteMed(Long serial) {
		try {
			medicineRepository.deleteById(serial);
			logger.warn("Delete medicine by serial number");
			return new ResponseEntity<>("Medicine deleted successsfully", HttpStatus.OK);
		} catch (Exception e) {
			logger.warn(e.getLocalizedMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

}
