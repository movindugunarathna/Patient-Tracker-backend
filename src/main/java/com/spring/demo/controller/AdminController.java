package com.spring.demo.controller;

import com.spring.demo.domain.Admin;
import com.spring.demo.exception.AdminNotFoundException;
import com.spring.demo.service_impl.AdminServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	private AdminServiceImpl adminServiceImpl;

	@PostMapping(value = "/add")
	public ResponseEntity<Object> admin(@RequestBody Admin a) {
		return adminServiceImpl.addNewAdmin(a);
	}

	@GetMapping(value = "/find/{id}")
	public ResponseEntity<Object> findById(@PathVariable Long id) throws AdminNotFoundException {
		return adminServiceImpl.findById(id);
	}

	@DeleteMapping(value = "/remove/{id}")
	public ResponseEntity<Object> deleteById(@PathVariable Long id) {
		return adminServiceImpl.removeAdmin(id);
	}

	@GetMapping(value = "/list")
	public List<Admin> listAllAdmins() {
		return adminServiceImpl.fetchAll();
	}
}