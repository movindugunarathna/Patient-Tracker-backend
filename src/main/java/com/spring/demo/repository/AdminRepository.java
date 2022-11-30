package com.spring.demo.repository;


import com.spring.demo.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("adminRepository")
public interface AdminRepository extends JpaRepository<Admin, Long> {

}
