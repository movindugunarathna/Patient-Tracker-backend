package com.spring.demo.service_impl;

import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.demo.domain.Bill;
import com.spring.demo.exception.BillNotFoundException;
import com.spring.demo.repository.BillRepository;
import com.spring.demo.service.BillService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BillServiceImpl implements BillService{

	private static final Logger logger = LoggerFactory.getLogger(PatientServiceImpl.class);

	@Autowired
	private BillRepository billRepository;

	@Override
	public ResponseEntity<Object> getAllBills() {
		logger.info("Bill list retrieved.");
		return new ResponseEntity<>(billRepository.findAll(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> findById(Long id) throws BillNotFoundException {
		try {
			try {
				Bill bill = billRepository.findById(id).get();
				logger.info("Get bill by bill ID.");
				return new ResponseEntity<>(bill, HttpStatus.OK);
			} catch (NoSuchElementException ex) {
				throw new BillNotFoundException("Bill Not Found");
			}
		} catch (BillNotFoundException ex) {
			throw new BillNotFoundException(ex.getMessage());
		}
	}

	@Override
	public ResponseEntity<Object> insertBill(Bill bill) {
		billRepository.save(bill);
		logger.info("Bill Created Successfully.");
		return new ResponseEntity<>("Bill Created Successfully.", HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<Object> updateBill(Bill bill, Long id) throws BillNotFoundException {
		billRepository.findById(id)
		.orElseThrow(()
				-> new BillNotFoundException("Bill not found."));
		bill.setId(id);
		billRepository.save(bill);
		logger.info("Update bill details using bill ID.");
		return new ResponseEntity<>("Bill updated successsfully", HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> deleteBill(Long id) {
		try {
			billRepository.deleteById(id);
			logger.warn("Delete bill by bill ID.");
			return new ResponseEntity<>("Bill deleted successsfully", HttpStatus.OK);
		} catch (Exception e) {
			logger.warn(e.getLocalizedMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

}
