package com.spring.demo.service_impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.demo.domain.Clerk;
import com.spring.demo.repository.ClerkRepository;
import com.spring.demo.service.ClerkService;

@Service
public class ClerkServiceImpl implements ClerkService{
    @Autowired
    private ClerkRepository clerkRepository;

    //save clerk
    @Override
    public Clerk addClerk(Clerk clerk){
        return this.clerkRepository.save(clerk);
    }    

    //get a clerk
    @Override
    public Optional<Clerk> getAClerk(long clerkID){
        // return clerkRepository.findByClerkID(clerkID).get(0);
        return clerkRepository.findById(clerkID);
    }

    //get All Clerks
    @Override
    public List<Clerk> getAllClerks(){
        return clerkRepository.findAll();
    }

    //update clerk
    @Override
    public Clerk updateClerk(long clerkID, Clerk clerk){
        Clerk returnClerk = clerkRepository.findByClerkID(clerkID).get(0);
        if(returnClerk != null){
            clerk.setClerkID(clerkID);
            return clerkRepository.save(clerk);
        }
        return null;
    }

    //delete clerk
    @Override
    public boolean deleteClerk(long clerkID){
        try{
            clerkRepository.deleteById(clerkID);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
