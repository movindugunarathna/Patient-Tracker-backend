package com.spring.demo.service;

import java.util.List;
import java.util.Optional;

import com.spring.demo.domain.Bill;


public interface BillService {

	public List<Bill> getAllBills();

    public Optional<Bill> findById(Long id);

    public Bill insertBill(Bill bill);

    public Bill updateBill(Bill bill, Long id);

    public void deleteBill(Long id);
}
