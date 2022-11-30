package com.spring.demo.controller;

import com.spring.demo.domain.Admin;
import com.spring.demo.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private AdminRepository adminRepository;

    @GetMapping(value = "/list")
    public List<Admin> fetchAll() {
        return adminRepository.findAll();
    }

    @PostMapping(value = "/add")
    public Admin admin(@RequestBody Admin a) {
        return adminRepository.save(a);
    }

    @GetMapping(value = "/find/{id}")
    public Optional<Admin> findById(@PathVariable Long id) {
        return adminRepository.findById(id);
    }

    @DeleteMapping(value = "/remove/{id}")
    public boolean deleteById(@PathVariable Long id) {
        try {
            adminRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}