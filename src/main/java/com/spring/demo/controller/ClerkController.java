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

import com.spring.demo.domain.Clerk;
import com.spring.demo.service.ClerkService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

@RestController
@RequestMapping(value = "/clerk")
public class ClerkController {
   @Autowired
   private ClerkService clerkService;
   
   @PostMapping(value = "/add")
   public Clerk addClerk(@RequestBody @Valid Clerk clerk){
      return clerkService.addClerk(clerk);
   }

   @GetMapping(value = "/getAll")
   public List<Clerk> getAllClerks(){
      return clerkService.getAllClerks();
   }

   @GetMapping(value = "/get/{clerkID}")
   public Optional<Clerk> getClerk(@PathVariable("clerkID") @Positive long clerkID){
      return clerkService.getAClerk(clerkID);
   }

   @PutMapping(value = "/update/{clerkID}")
   public Clerk updateClerk(@PathVariable("clerkID") @Positive long clerkID, @RequestBody @Valid Clerk clerk){
      return clerkService.updateClerk(clerkID, clerk);
   }

   @DeleteMapping(value = "/delete/{clerkID}")
   public Boolean deleteClerk(@PathVariable("clerkID") @Positive long clerkID){
      return clerkService.deleteClerk(clerkID);
   }
}
