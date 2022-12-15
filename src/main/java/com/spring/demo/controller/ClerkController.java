package com.spring.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.demo.domain.Clerk;
import com.spring.demo.repository.ClerkRepository;

@RestController
@RequestMapping(value = "/clerk")
public class ClerkController {

	@Autowired
	private ClerkRepository clerkRepository;
	
	@GetMapping(value = "/all")
	public List<Clerk> getAllClerks() {
		return clerkRepository.findAll();
	}
	
	@GetMapping(value = "/find/{id}")
	public Optional<Clerk> findById(@PathVariable Long id) {
		return clerkRepository.findById(id);
	}
	
	@PostMapping(value = "/add")
	public Clerk insertMed(Clerk clerk) {
		return clerkRepository.save(clerk);
	}

	@PutMapping(value = "/update/{id}")
	public Clerk updateClerk(Clerk clerk, @PathVariable Long id) {

		Optional<Clerk> clk = clerkRepository.findById(id);
		
		if(clk != null) {
			clerk.setId(id);
			return clerkRepository.save(clerk);
		}
		return null;
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public boolean deleteClerk(@PathVariable Long id) {
		try {
			clerkRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
}
