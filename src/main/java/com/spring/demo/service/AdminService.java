package com.spring.demo.service;

import com.spring.demo.domain.Admin;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

public interface AdminService {
	ResponseEntity<Object> addNewAdmin(Admin admin);
	ResponseEntity<Object> findById(Long id);
	ResponseEntity<Object> removeAdmin(Long id);
    List<Admin> fetchAll();
}
