package com.spring.demo.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.demo.domain.Bill;
import com.spring.demo.exception.BillNotFoundException;
import com.spring.demo.service_impl.BillServiceImpl;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

@RestController
@RequestMapping(value = "/bill")
public class BillController {
	
	private static final Logger logger = LoggerFactory.getLogger(BillController.class);

	@Autowired
	private BillServiceImpl billServiceImpl;
	
	@GetMapping(value = "/all")
	public ResponseEntity<Object> getAllBills() {
		return billServiceImpl.getAllBills();
	}

	@GetMapping(value = "/find/{id}")
	public ResponseEntity<Object> findById(@PathVariable @Positive Long id) throws BillNotFoundException {
		return billServiceImpl.findById(id);
	}

	@PostMapping(value = "/add")
	public ResponseEntity<Object> insertBill(@RequestBody @Valid Bill bill) {
		return billServiceImpl.insertBill(bill);
	}

	@PutMapping(value = "/update/{id}")
	public ResponseEntity<Object> updateBill(@RequestBody @Valid Bill bill, @PathVariable @Positive Long id) throws BillNotFoundException {
		return billServiceImpl.updateBill(bill, id);	
	}

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Object> deleteBill(@PathVariable @Positive Long id) {
		return billServiceImpl.deleteBill(id);
	}
	
}
