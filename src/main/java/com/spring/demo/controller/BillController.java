package com.spring.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.demo.domain.Bill;
import com.spring.demo.service.BillServiceImpl;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

@RestController
@RequestMapping(value = "/bill")
public class BillController {

	@Autowired
	private BillServiceImpl billServiceImpl;
	
	@GetMapping(value = "/all")
	public List<Bill> getAllBills() {
		return billServiceImpl.getAllBills();
	}

	@GetMapping(value = "/find/{id}")
	public Optional<Bill> findById(@PathVariable @Positive Long id) {
		return billServiceImpl.findById(id);
	}

	@PostMapping(value = "/add")
	public Bill insertBill(@RequestBody @Valid Bill bill) {
		return billServiceImpl.insertBill(bill);
	}

	@PutMapping(value = "/update/{id}")
	public Bill updateBill(@RequestBody @Valid Bill bill, @PathVariable @Positive Long id) {
		return billServiceImpl.updateBill(bill, id);	
	}

	@DeleteMapping(value = "/delete/{id}")
	public void deleteBill(@PathVariable @Positive Long id) {
		billServiceImpl.deleteBill(id);
	}
	
}
