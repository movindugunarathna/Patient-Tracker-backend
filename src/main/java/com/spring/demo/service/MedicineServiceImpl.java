package com.spring.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.demo.domain.Medicine;
import com.spring.demo.repository.MedicineRepository;

@Service
public class MedicineServiceImpl implements MedicineService{

	@Autowired
	private MedicineRepository medicineRepository;

	@Override
	public List<Medicine> getAllMedicines() {
		return medicineRepository.findAll();
	}

	@Override
	public Optional<Medicine> findById(Long serial) {
		return medicineRepository.findById(serial);
	}

	@Override
	public Medicine insertMed(Medicine medicine) {
		return medicineRepository.save(medicine);
	}

	@Override
	public Medicine updateMed(Medicine medicine, Long serial) {
		Optional<Medicine> med = medicineRepository.findById(serial);

		if(med != null) {
			return medicineRepository.save(medicine);
		}
		return null;
	}

	@Override
	public void deleteMed(Long serial) {
		try {
			medicineRepository.deleteById(serial);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
