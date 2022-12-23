package com.spring.demo.service;

import org.springframework.http.ResponseEntity;

import com.spring.demo.domain.Bill;
import com.spring.demo.exception.BillNotFoundException;


public interface BillService {

	public ResponseEntity<Object> getAllBills();

    public ResponseEntity<Object> findById(Long id) throws BillNotFoundException;

    public ResponseEntity<Object> insertBill(Bill bill);

    public ResponseEntity<Object> updateBill(Bill bill, Long id) throws BillNotFoundException;

    public ResponseEntity<Object> deleteBill(Long id);
}
