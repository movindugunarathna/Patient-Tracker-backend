package com.spring.demo.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.spring.demo.AbstractTest;
import com.spring.demo.domain.Doctor;
import com.spring.demo.domain.Medicine;
import com.spring.demo.domain.Patient;
import com.spring.demo.domain.Prescription;

class PrescriptionControllerTest extends AbstractTest {

	@Override
	@Before
	public void setUp() {
		super.setUp();
	}

	@Test
	public void createPrescription() throws Exception {
		String uri = "/prescription/add";
		Prescription prescription = new Prescription();
		prescription.setPrescriptionId(1L);
//		Patient patient = new Patient();
//		patient.setPatientId(1);
//		patient.setFirstName("Jayamith");
//		patient.setLastName("Priyankara");
//		patient.setUsername("Jay");
//		patient.setAge("25");
//		patient.setGender("Male");
//		patient.setContactNumber("0786546325");
//		patient.setNotes("Special Notes");
//		prescription.setPatient(patient);
//		
//		Doctor doctor = new Doctor();
//		doctor.setDoctorId(1L);
//		doctor.setFirstName("John");
//		doctor.setLastName("Doe");
//		doctor.setGender("Male");
//		doctor.setNicNumber("21584789478");
//		doctor.setSpecialization("Skin");
//		prescription.setDoctor(doctor);
		
		Medicine medicine = new Medicine();
		medicine.setSerialNumber(1L);
		medicine.setMedicineName("Adderall");
		medicine.setManufacturedDate(new Date(2022, 4, 28));
		medicine.setExpiryDate(new Date(2022, 12, 28));
		medicine.setNotes("My notes");
		Set<Medicine> medicineSet = new HashSet<Medicine>();
		medicineSet.add(medicine);
		prescription.setMedicineList(medicineSet);
		prescription.setPrescriptionDate(Date.from(Instant.now()));

		String inputJson = super.mapToJson(prescription);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals("Prescription added successfully", content);
	}

	@Test
	public void getPrescriptionList() throws Exception {
		String uri = "/prescription/list";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Prescription[] prescriptionlist = super.mapFromJson(content, Prescription[].class);
		assertTrue(prescriptionlist.length > 0);
	}

	@Test
	public void getPrescriptionByIdTest() throws Exception {
		String uri = "/prescription/find/1";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

		Prescription expectPrescription = new Prescription();
		expectPrescription.setPrescriptionId(1L);
		String expectJson = super.mapToJson(expectPrescription);

		String actual = mvcResult.getResponse().getContentAsString();
		assertEquals(expectJson, actual);
	}

	@Test
	public void updatePrescription() throws Exception {
		String uri = "/prescription/update/1";
		Prescription prescription = new Prescription();

		String inputJson = super.mapToJson(prescription);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, content);
	}

	@Test
	public void deletePrescription() throws Exception {
		String uri = "/prescription/delete/1";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, content);
	}

}
