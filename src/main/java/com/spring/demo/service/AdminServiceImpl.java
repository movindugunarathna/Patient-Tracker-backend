package com.spring.demo.service;

import com.spring.demo.domain.Admin;
import com.spring.demo.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
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

    @Override
    public List<Admin> fetchAll() {
        return adminRepository.findAll();
    }
}
