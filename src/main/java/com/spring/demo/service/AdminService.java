package com.spring.demo.service;

import com.spring.demo.domain.Admin;

import java.util.List;
import java.util.Optional;

public interface AdminService {
    Admin addNewAdmin(Admin admin);
    Optional<Admin> getAdminById(Long id);
    void removeAdmin(Long id);
    List<Admin> fetchAll();
}
