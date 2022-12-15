package com.spring.demo.service;

import com.spring.demo.domain.Admin;
import com.spring.demo.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminRepository adminRepository;

    @Override
    public Admin addNewAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public Optional<Admin> getAdminById(Long id) {
        return adminRepository.findById(id);
    }

    @Override
    public void removeAdmin(Long id) {
        try {
            adminRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println();
        }
    }
}
