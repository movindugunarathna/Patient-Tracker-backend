package com.spring.demo.service_impl;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.demo.domain.Clerk;
import com.spring.demo.exception.ClerkNotFoundException;
import com.spring.demo.exception.EmptyInputException;
import com.spring.demo.repository.ClerkRepository;
import com.spring.demo.service.ClerkService;

@Service
// @Transactional
public class ClerkServiceImpl implements ClerkService{
    @Autowired
    private ClerkRepository clerkRepository;

    static Logger log = Logger.getLogger(ClerkServiceImpl.class.getName());
 
    //save clerk
    @Override
    public Clerk addClerk(Clerk clerk){
        if(clerk.getFirstName().isEmpty() || clerk.getLastName().isEmpty() || clerk.getAge().isEmpty() || clerk.getContactNo().isEmpty() || clerk.getDepartment().isEmpty() || clerk.getGender().isEmpty()){
            throw new EmptyInputException("601", "Input Fields are Empty");
        }
        Clerk returningClerk = this.clerkRepository.save(clerk);
        log.info("Clerk Added");
        return returningClerk;
    } 

    // //get a clerk
    // @Override
    // public ResponseEntity<Object> getAClerk(long clerkID) throws ClerkNotFoundException{
    //     Clerk returningClerk = clerkRepository.findById(clerkID).get();
    //     System.out.println(returningClerk.getClerkID());
    //     if(returningClerk.getFirstName().isEmpty() || returningClerk.getFirstName().length() == 0){
    //         //throw new ClerkNotFoundException("601","Clerk not found");
    //     }
    //     return new ResponseEntity<>(returningClerk, HttpStatus.OK);
    // }

    //get a clerk
    @Override
    public ResponseEntity<Object> getAClerk(long clerkID) {
        Clerk returningClerk = clerkRepository.findById(clerkID).get();
        System.out.println(returningClerk.getClerkID());
        return new ResponseEntity<>(returningClerk, HttpStatus.OK);
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
