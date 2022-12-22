package com.spring.demo.repository;


import com.spring.demo.domain.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("doctorRepository")
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    //test case01
	Optional<Doctor> findByFirstName(String firstName);

}
