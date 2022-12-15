package com.spring.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.demo.domain.Clerk1;

@Repository("clerkRepository")
public interface Cler1kRepository extends JpaRepository<Clerk1, Long>{
    List<Clerk1> findByClerkID(long clerkID);
}
