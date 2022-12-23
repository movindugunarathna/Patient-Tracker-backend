package com.spring.demo.controller;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

   static Logger log = Logger.getLogger(ClerkController.class.getName());

   @Autowired
   private ClerkService clerkService;
   
   @PostMapping(value = "/add")
   public ResponseEntity<?> addClerk(@RequestBody @Valid Clerk clerk){
      log.info("started adding clerk");
      Clerk clerkObj = clerkService.addClerk(clerk);
      return new ResponseEntity<Clerk>(clerkObj, HttpStatus.CREATED);
   }

   @GetMapping(value = "/getAll")
   public ResponseEntity<List<Clerk>> getAllClerks(){
      log.info("started getting all clerks");
      List<Clerk> clerks = clerkService.getAllClerks();
      return new ResponseEntity<List<Clerk>>(clerks, HttpStatus.OK);
   }

   @GetMapping(value = "/get/{clerkID}")
   public ResponseEntity<Object> getClerk(@PathVariable("clerkID") @Positive long clerkID){
      log.info("started getting the clerk");
      return clerkService.getAClerk(clerkID);
   }

   @PutMapping(value = "/update/{clerkID}")
   public Clerk updateClerk(@PathVariable("clerkID") @Positive long clerkID, @RequestBody @Valid Clerk clerk){
      log.info("started updating the clerk");
      return clerkService.updateClerk(clerkID, clerk);
   }

   @DeleteMapping(value = "/delete/{clerkID}")
   public Boolean deleteClerk(@PathVariable("clerkID") @Positive long clerkID){
      log.info("started deleting the clerk");
      return clerkService.deleteClerk(clerkID);
   }
}
