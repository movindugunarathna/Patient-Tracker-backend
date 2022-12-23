package com.spring.demo.controller;

import com.spring.demo.domain.Doctor;
import com.spring.demo.repository.DoctorRepository;
import com.spring.demo.service_impl.DoctorServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/doctor")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepo;
    
    @Autowired
    private DoctorService doctorService;
    
    static Logger logger = Logger.getLogger(DoctorController.class.getName());
    
    @RequestMapping(value="/list")
    public ResponseEntity<List<Doctor>>getDoctor(){
    	logger.info("Inside class!!!!!!!! DoctorController, method!!!! : getDoctorsList");
    	return new ResponseEntity<List<Doctor>>(doctorService.getDoctor(),HttpStatus.OK);
    }
    
    @RequestMapping(value="/add", method = RequestMethod.POST)
    public ResponseEntity<Object>createDoctor(@Valid @RequestBody Doctor doctor) {
    	logger.info("Inside class!!!!!!!! DoctorController, method!!!! : createDoctor");
    		//Doctor doc = doctorRepo.save(doc)
    	doctorService.createDoctor(doctor);
    	return new ResponseEntity<>("Doctor added successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/list/{doctorId}", method=RequestMethod.GET)
    public ResponseEntity<Doctor> getDoctorById(@PathVariable("doctorId") Long doctorId) {
        logger.info("Inside Class!!!!!!!! DoctorController, method!!!!! :  getDoctorById");
        
        Doctor doc= doctorRepo.findById(doctorId).orElseThrow(()-> new DoctorNotFoundException());
       // if(!doctorService.containsKey(doctorId)) throw new DoctorNotFoundException(;)
        //return new ResponseEntity<Doctor>(doctorService.getDoctorById(doctorID), HttpStatus.OK);
        return ResponseEntity.ok().body(doc);
    }
    
    @RequestMapping(value = "/delete/{doctorId}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteDoctor(@PathVariable("doctorId") Long doctorId) {
        logger.info("Inside class!!!!!!!! DoctorController, method!!!! : delete");
        
        Doctor doc = doctorRepo.findById(doctorId).orElseThrow(()-> new DoctorNotFoundException());
        		
        doctorService.deleteDoctor(doctorId);
        return new ResponseEntity<>("Doctor deleted successsfully", HttpStatus.OK);
      
    }
    
   /* @RequestMapping(value = "/update/{doctorId}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateDoctor(@PathVariable("doctorId") Long doctorId, @RequestBody Doctor doctor) {
        logger.info("Inside class!!!!!!!! DoctorController, method!!!! : updateAdmin");
        	Doctor doc = doctorRepo.findById(doctorId).orElseThrow(()-> new DoctorNotFoundException());
        	
        doctorService.updateDoctor(doctorId,doctor);
        return new ResponseEntity<>("Doctor is updated successsfully", HttpStatus.OK);
        
    }*/
    
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateDoctor( @RequestBody Doctor doctor) {
        logger.info("Inside class!!!!!!!! DoctorController, method!!!! : updateAdmin");
        	
        doctorService.updateDoctor(doctor);
        return new ResponseEntity<>("Doctor is updated successsfully", HttpStatus.OK);
        
    }
    
}