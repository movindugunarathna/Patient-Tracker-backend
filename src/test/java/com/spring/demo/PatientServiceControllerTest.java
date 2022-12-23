package com.spring.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.spring.demo.domain.Patient;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PatientServiceControllerTest extends PatientTest{

	@Override
	@Before
	public void setUp() {
		super.setUp();
	}
	
	@Test
//	@Order(1)
	public void createPatient() throws Exception {
		String uri = "/patient/add";
		Patient patient = new Patient();
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
		assertEquals(content, "Patient Added Successfully.");
	}
	
	@Test
//	@Order(2)
	public void createPatient_2() throws Exception {
		String uri = "/patient/add";
		Patient patient = new Patient();
		patient.setFirstName("Jayamith");
//		patient.setLastName("Priyankara");
//		patient.setUsername("Jay");
//		patient.setAge("25");
//		patient.setGender("Male");
//		patient.setContactNumber("0786546325");
//		patient.setNotes("Special Notes");
		String inputJson = super.mapToJson(patient);
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(inputJson)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(400, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "");
	}
	
	@Test
//	@Order(3)
	public void createPatient_3() throws Exception {
		String uri = "/patient/add";
		Patient patient = new Patient();
//		patient.setFirstName("Jayamith");
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
		assertEquals(400, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "");
	}
	
	@Test
//	@Order(4)
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
//	@Order(5)
	public void updatePatient() throws Exception {
		String uri = "/patient/update/2";
		Patient patient = new Patient();
		patient.setPatientId(2);
		patient.setFirstName("Jay 2");
		patient.setAge("45");
		patient.setContactNumber("0765432457");
		patient.setGender("Male");
		patient.setLastName("Pri 2");
		patient.setNotes("Additional Notes here");
		patient.setUsername("JayP");
		String inputJson = super.mapToJson(patient);
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(inputJson)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "Patient updated successsfully");
	}
	
	@Test
//	@Order(5)
	public void updatePatient_2() throws Exception {
		String uri = "/patient/update/1000";
		Patient patient = new Patient();
		patient.setPatientId(10);
		patient.setFirstName("Jay 2");
		patient.setAge("45");
		patient.setContactNumber("0765432457");
		patient.setGender("Male");
		patient.setLastName("Pri 2");
		patient.setNotes("Additional Notes here");
		patient.setUsername("JayP");
		String inputJson = super.mapToJson(patient);
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(inputJson)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(400, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "");
	}
	
	@Test
//	@Order(6)
	public void deletePatient() throws Exception {
		String uri = "/patient/delete/9";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content,"Patient deleted successsfully");
	}
}
