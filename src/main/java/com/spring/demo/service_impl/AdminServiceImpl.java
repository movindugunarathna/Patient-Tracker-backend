package com.spring.demo.service_impl;

import com.spring.demo.domain.Admin;
import com.spring.demo.repository.AdminRepository;
import com.spring.demo.service.AdminService;

import jakarta.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
	private static final Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);
	
    @Autowired
    AdminRepository adminRepository;

    @Override
    public ResponseEntity<Object> addNewAdmin(Admin admin) {
    	adminRepository.save(admin);
    	logger.info("Admin added successfully");
    	return new ResponseEntity<>("Admin added successfully", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Object> findById(Long id) {
        Admin findAdmin = adminRepository.findById(id).get();
        logger.info("Get admin by admin ID");
		return new ResponseEntity<>(findAdmin, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> removeAdmin(Long id) {
        try {
            adminRepository.deleteById(id);
            logger.warn("Remove admin by admin ID.");
			return new ResponseEntity<>("Admin removed successsfully", HttpStatus.OK);
        } catch (Exception e) {
        	logger.warn(e.getLocalizedMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public List<Admin> fetchAll() {
    	logger.info("Admins list retrieved.");
        return adminRepository.findAll();
    }
}
