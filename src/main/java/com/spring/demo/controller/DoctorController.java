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

    @RequestMapping(value = "/list/{doctorID}", method=RequestMethod.GET)
    public ResponseEntity<Doctor> getDoctorById(@PathVariable("doctorID") Long doctorID) {
        logger.info("Inside Class!!!!!!!! DoctorController, method!!!!! :  getDoctorById");
        
        Doctor doc= doctorRepo.findById(doctorID).orElseThrow(()-> new DoctorNotFoundException());
       // if(!doctorService.containsKey(doctorId)) throw new DoctorNotFoundException(;)
        //return new ResponseEntity<Doctor>(doctorService.getDoctorById(doctorID), HttpStatus.OK);
        return ResponseEntity.ok().body(doc);
    }
    
    @RequestMapping(value = "/delete/{doctorID}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteDoctor(@PathVariable("doctorID") Long doctorID) {
        logger.info("Inside class!!!!!!!! DoctorController, method!!!! : delete");
        
        Doctor doc = doctorRepo.findById(doctorID).orElseThrow(()-> new DoctorNotFoundException());
        		
        doctorService.deleteDoctor(doctorID);
        //return new ResponseEntity<>("Doctor deleted successsfully", HttpStatus.OK);
        
        return ResponseEntity.ok().body("Doctor with Id "+doctorID+" DELETED");
    }





















    /*@Autowired
    private DoctorServiceImpl doctorServiceImpl;

    @GetMapping(value = "/list")
    public List<Doctor> fetchAll() {
        return doctorServiceImpl.getAllDoctors();
    }

    @PostMapping(value = "/add")
    public Doctor doctor(@RequestBody Doctor d) {
        return doctorServiceImpl.createNewDoctor(d);
    }

    @GetMapping(value = "/find/{id}")
    public Optional<Doctor> findById(@PathVariable Long id) {
        return doctorServiceImpl.findById(id);
    }

    @DeleteMapping(value = "/remove/{id}")
    public boolean deleteById(@PathVariable Long id) {
        try {
            doctorServiceImpl.removeDoctor(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @PutMapping(value = "/update/{id}")
    public Doctor updateDoctor(@RequestBody Doctor updateDoctor, @PathVariable Long id) {
        return doctorServiceImpl.updateDoctor(updateDoctor, id);
    }
    */

}