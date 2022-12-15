package com.spring.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.demo.domain.Clerk1;
import com.spring.demo.repository.Cler1kRepository;

@Component
public class ClerkService {

    @Autowired
    private Cler1kRepository clerkRepository;

    //save clerk
    public Clerk1 addClerk(Clerk1 clerk){
        return this.clerkRepository.save(clerk);
    }    

    //get a clerk
    public Optional<Clerk1> getAClerk(long clerkID){
        // return clerkRepository.findByClerkID(clerkID).get(0);
        return clerkRepository.findById(clerkID);
    }

    //get All Clerks
    public List<Clerk1> getAllClerks(){
        return clerkRepository.findAll();
    }

    //update clerk
    public Clerk1 updateClerk(long clerkID, Clerk1 clerk){
        Clerk1 returnClerk = clerkRepository.findByClerkID(clerkID).get(0);
        if(returnClerk != null){
            clerk.setClerkID(clerkID);
            return clerkRepository.save(clerk);
        }
        return null;
    }

    //delete clerk
    public boolean deleteClerk(long clerkID){
        try{
            clerkRepository.deleteById(clerkID);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
