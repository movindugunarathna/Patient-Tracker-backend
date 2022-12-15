package com.spring.demo.controller;

import com.spring.demo.domain.Admin;
import com.spring.demo.service.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {
    @Autowired
    private AdminServiceImpl adminServiceImpl;
    @PostMapping(value = "/add")
    public Admin admin(@RequestBody Admin a) {
        return adminServiceImpl.addNewAdmin(a);
    }

    @GetMapping(value = "/find/{id}")
    public Optional<Admin> findById(@PathVariable Long id) {
        return adminServiceImpl.getAdminById(id);
    }

    @DeleteMapping(value = "/remove/{id}")
    public boolean deleteById(@PathVariable Long id) {
        try {
            adminServiceImpl.removeAdmin(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}