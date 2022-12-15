package com.spring.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.demo.domain.Clerk1;
import com.spring.demo.service.ClerkService;

@RestController
@RequestMapping(value = "/clerk")
public class ClerkController1 {
   @Autowired
   private ClerkService clerkService;
   
   @PostMapping(value = "/add")
   public Clerk1 addClerk(@RequestBody Clerk1 clerk){
      return clerkService.addClerk(clerk);
   }

   @GetMapping(value = "/getAll")
   public List<Clerk1> getAllClerks(){
      return clerkService.getAllClerks();
   }

   @GetMapping(value = "/get/{clerkID}")
   public Optional<Clerk1> getClerk(@PathVariable("clerkID") long clerkID){
      return clerkService.getAClerk(clerkID);
   }

   @PutMapping(value = "/update/{clerkID}")
   public Clerk1 updateClerk(@PathVariable("clerkID") long clerkID, @RequestBody Clerk1 clerk){
      return clerkService.updateClerk(clerkID, clerk);
   }

   @DeleteMapping(value = "/delete/{clerkID}")
   public Boolean deleteClerk(@PathVariable("clerkID") long clerkID){
      return clerkService.deleteClerk(clerkID);
   }
}
