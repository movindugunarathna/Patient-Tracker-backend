package com.spring.demo.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.spring.demo.AbstractTest;
import com.spring.demo.domain.Medicine;

class MedicineControllerTest extends AbstractTest {
	@Override
	@Before
	public void setUp() {
		super.setUp();
	}

	@Test
	public void createMedicineTest() throws Exception {
		String uri = "/medicine/add";
		Medicine medicine = new Medicine();
		medicine.setSerialNumber(1L);
		medicine.setMedicineName("Adderall");
		medicine.setManufacturedDate(new Date(2022, 11, 25));
		medicine.setExpiryDate(new Date(2023, 05, 25));
		String inputJson = super.mapToJson(medicine);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals("Medicine added successfully", content);
	}

	@Test
	public void getMedicineByIdTest() throws Exception {
		String uri = "/medicine/find/1";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

		Medicine expectMedicine = new Medicine();
		expectMedicine.setSerialNumber(1L);
		expectMedicine.setMedicineName("Adderall");
		expectMedicine.setManufacturedDate(new Date(2022, 11, 25));
		expectMedicine.setExpiryDate(new Date(2023, 05, 25));
		String expectJson = super.mapToJson(expectMedicine);

		String actual = mvcResult.getResponse().getContentAsString();
		assertEquals(expectJson, actual);
	}

	@Test
	public void getMedicineListTest() throws Exception {
		String uri = "/medicine/all";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Medicine[] medicinelist = super.mapFromJson(content, Medicine[].class);
		assertTrue(medicinelist.length > 0);
	}
	
	@Test
	public void updateMedicine() throws Exception {
		String uri = "/medicine/update/1";
		Medicine medicine = new Medicine();
		medicine.setNotes("Notes Updated");
		String inputJson = super.mapToJson(medicine);
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(inputJson)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals("Medicine updated successsfully", content);
	}

	@Test
	public void removeMedicineTest() throws Exception {
		String uri = "/medicine/delete/1";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals("Medicine deleted successsfully", content);
	}
}
