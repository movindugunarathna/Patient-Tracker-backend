package com.spring.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.demo.domain.Bill;
import com.spring.demo.repository.BillRepository;

@Service
public class BillServiceImpl implements BillService{

	@Autowired
	private BillRepository billRepository;
	
	@Override
	public List<Bill> getAllBills() {
		return billRepository.findAll();
	}

	@Override
	public Optional<Bill> findById(Long id) {
		return billRepository.findById(id);
	}

	@Override
	public Bill insertBill(Bill bill) {
		return billRepository.save(bill);
	}

	@Override
	public Bill updateBill(Bill bill, Long id) {
		Optional<Bill> b = billRepository.findById(id);

		if(b != null) {
			bill.setId(id);
			return billRepository.save(bill);
		}
		return null;
	}

	@Override
	public void deleteBill(Long id) {
		try {
			billRepository.deleteById(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
