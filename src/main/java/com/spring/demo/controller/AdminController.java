package com.spring.demo.controller;

import com.spring.demo.domain.Admin;
import com.spring.demo.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


}
