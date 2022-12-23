package com.spring.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.spring.demo.domain.Medicine;

public interface MedicineService {

    public List<Medicine> getAllMedicines();

    public ResponseEntity<Object> findById(Long serial);

    public ResponseEntity<Object> insertMed(Medicine medicine);

    public ResponseEntity<Object> updateMed(Medicine medicine, Long serial);

    public ResponseEntity<Object> deleteMed(Long serial);
}
