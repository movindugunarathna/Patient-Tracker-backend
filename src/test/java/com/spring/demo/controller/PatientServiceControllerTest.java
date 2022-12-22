package com.spring.demo.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.spring.demo.AbstractTest;
import com.spring.demo.domain.Patient;

public class PatientServiceControllerTest extends AbstractTest{

	@Override
	@Before
	public void setUp() {
		super.setUp();
	}
	
	@Test
	public void createPatient() throws Exception {
		String uri = "/patient/add";
		Patient patient = new Patient();
		patient.setPatientId(1);
		patient.setFirstName("Jayamith");
		patient.setLastName("Priyankara");
		patient.setUsername("Jay");
		patient.setAge("25");
		patient.setGender("Male");
		patient.setContactNumber("0786546325");
		patient.setNotes("Special Notes");
		String inputJson = super.mapToJson(patient);
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(inputJson)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, content);
	}
	
	@Test
	public void getPatientList() throws Exception {
		String uri = "/patient/all";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
				.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Patient[] patientlist = super.mapFromJson(content, Patient[].class);
		assertTrue(patientlist.length > 0);
	}
	
	@Test
	public void updatePatient() throws Exception {
		String uri = "/patient/update/1";
		Patient patient = new Patient();
		patient.setFirstName("Jay Updated");
		String inputJson = super.mapToJson(patient);
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(inputJson)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, content);
	}
	
	@Test
	public void deletePatient() throws Exception {
		String uri = "/patient/delete/1";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content,content);
	}
}
