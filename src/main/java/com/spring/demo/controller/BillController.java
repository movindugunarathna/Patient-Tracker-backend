package com.spring.demo.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	public List<Bill> getAllBills() {
		logger.info("Get all the bills.");
		return billServiceImpl.getAllBills();
	}

	@GetMapping(value = "/find/{id}")
	public Optional<Bill> findById(@PathVariable @Positive Long id) {
		logger.info("Get bill by bill ID.");
		return billServiceImpl.findById(id);
	}

	@PostMapping(value = "/add")
	public Bill insertBill(@RequestBody @Valid Bill bill) {
		logger.info("New bill created.");
		return billServiceImpl.insertBill(bill);
	}

	@PutMapping(value = "/update/{id}")
	public Bill updateBill(@RequestBody @Valid Bill bill, @PathVariable @Positive Long id) {
		logger.info("Update bill by bill ID.");
		return billServiceImpl.updateBill(bill, id);	
	}

	@DeleteMapping(value = "/delete/{id}")
	public void deleteBill(@PathVariable @Positive Long id) {
		logger.info("Delete bill by bill ID.");
		billServiceImpl.deleteBill(id);
	}
	
}
