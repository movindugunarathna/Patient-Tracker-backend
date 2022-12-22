package com.spring.demo.service;

import java.util.List;
import java.util.Optional;

import com.spring.demo.domain.Clerk;

public interface ClerkService {

    //save clerk
    public Clerk addClerk(Clerk clerk);   

    //get a clerk
    public Optional<Clerk> getAClerk(long clerkID);

    //get All Clerks
    public List<Clerk> getAllClerks();

    //update clerk
    public Clerk updateClerk(long clerkID, Clerk clerk);

    //delete clerk
    public boolean deleteClerk(long clerkID);
}
