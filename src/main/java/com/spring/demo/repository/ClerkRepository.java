package com.spring.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.demo.domain.Clerk;

@Repository("clerkRepository")
public interface ClerkRepository extends JpaRepository<Clerk, Long>{
    List<Clerk> findByClerkID(long clerkID);
}
