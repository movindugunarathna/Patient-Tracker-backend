package com.spring.demo.service;

import com.spring.demo.domain.Admin;

import java.util.List;
import java.util.Optional;

public interface AdminService {
    public Admin addNewAdmin(Admin admin);
    public Optional<Admin> getAdminById(Long id);
    public void removeAdmin(Long id);
    public List<Admin> fetchAll();
}
