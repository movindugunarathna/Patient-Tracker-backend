package com.spring.demo;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.spring.demo.domain.Doctor;


public class DoctorTestCase  extends PatientTrackerBackendApplicationTests{

	@Override
	@Before
	public void setUp() {
		// TODO Auto-generated method stub
		super.setUp();
	}
	
	@Test
	public void getDoctorList() throws Exception{
		String uri ="/doctor/list";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
				.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Doctor[] doctorlist = super.mapFromJson(content, Doctor[].class);
		assertTrue(doctorlist.length > 0);

		}
	
	@Test
	public void createDoctor() throws Exception{
		String uri = "/doctor/add";
		
		Doctor doc = new Doctor();
		doc.setFirstName("David");
		doc.setLastName("Beckam");
		doc.setNicNumber("867845643V");
		doc.setGender("Male");
		doc.setContactNumber("0779459345");
		doc.setSpecialization("Neurologist");
		
		String inputJson = super.mapToJson(doc);
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(inputJson)).andReturn();
		
		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals("Doctor added successfully",content);
	}
	
	@Test
	public void updateDoctor() throws Exception{
		String uri = "/doctor/update";
		
		
		
		Doctor doc = new Doctor(5L, "John", "Bugg", "868745643V", "Male", "0779459345","Neurologist");
		
		String inputJson = super.mapToJson(doc);
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(inputJson)).andReturn();
		
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals("Doctor is updated successsfully", content);
	}
	
	@Test
	public void deleteDoctor() throws Exception{
		String uri = "/doctor/delete/11";
		
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)
				.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		
		
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals("Doctor deleted successsfully", content);
		
	}
	
	@Test
	public void getDoctorById() throws Exception{
		String uri ="/doctor/list/8";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
				.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Doctor doctor = super.mapFromJson(content, Doctor.class);
		assertEquals(doctor.getDoctorId(), 8);

		}
	
	
}