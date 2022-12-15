package com.spring.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.demo.domain.Bill;

public interface BillRepository extends JpaRepository<Bill, Long>{

}
