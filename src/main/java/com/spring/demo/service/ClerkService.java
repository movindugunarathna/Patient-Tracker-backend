package com.spring.demo.service;

import java.util.List;
import java.util.Optional;

import com.spring.demo.domain.Clerk1;

public interface ClerkService {

    //save clerk
    public Clerk1 addClerk(Clerk1 clerk);   

    //get a clerk
    public Optional<Clerk1> getAClerk(long clerkID);

    //get All Clerks
    public List<Clerk1> getAllClerks();

    //update clerk
    public Clerk1 updateClerk(long clerkID, Clerk1 clerk);

    //delete clerk
    public boolean deleteClerk(long clerkID);
}
