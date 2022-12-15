package com.spring.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.demo.domain.Clerk1;
import com.spring.demo.repository.Cler1kRepository;

@RestController
@RequestMapping(value = "/clerk")
public class ClerkController1 {
   @Autowired
   private Cler1kRepository clerkRepository;
   
   @PostMapping(value = "/add")
   public Clerk1 addClerk(@RequestBody Clerk1 clerk){
      return clerkRepository.save(clerk);
   }

   @GetMapping(value = "/getAll")
   public List<Clerk1> getAllClerks(){
      return clerkRepository.findAll();
   }

   @GetMapping(value = "get")
   public Clerk1 getClerk(@PathVariable("clerkID") long clerkID){
      return clerkRepository.findByClerkID(clerkID).get(0);
   }

   @PutMapping(value = "/update/{clerkID}")
   public Clerk1 updateClerk(@PathVariable("clerkID") long clerkID, @RequestBody Clerk1 clerk){
      Clerk1 returnClerk = clerkRepository.findByClerkID(clerkID).get(0);
      returnClerk.setFirstName(clerk.getFirstName());
      returnClerk.setLastName(clerk.getFirstName());
      returnClerk.setAge(clerk.getFirstName());
      returnClerk.setGender(clerk.getFirstName());
      returnClerk.setContactNo(clerk.getFirstName());
      returnClerk.setPassword(clerk.getFirstName());
      return clerkRepository.save(returnClerk);
   }
}
