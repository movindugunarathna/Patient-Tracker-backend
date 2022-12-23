package com.spring.demo.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.spring.demo.AbstractTest;
import com.spring.demo.domain.Bill;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BillServiceControllerTest extends AbstractTest{
	
	@Override
	@Before
	public void setUp() {
		super.setUp();
	}
	
	@Test
	public void createBill() throws Exception {
		String uri = "/bill/add";
		Bill bill = new Bill();
		bill.setBillDate(new Date());
		bill.setCost(5600.50);
		bill.setNotes("Bill for monthly medicine");
		bill.setPatient(null);
		String inputJson = super.mapToJson(bill);
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(inputJson)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "Bill Created Successfully.");
	}
	
	@Test
	public void createBill_2() throws Exception {
		String uri = "/bill/add";
		Bill bill = new Bill();
		bill.setCost(4500.00);
		String inputJson = super.mapToJson(bill);
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(inputJson)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(400, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "");
	}
	
	@Test
	public void getBillList() throws Exception {
		String uri = "/bill/all";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
				.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Bill[] billlist = super.mapFromJson(content, Bill[].class);
		assertTrue(billlist.length > 0);
	}
	
	@Test
	public void updateBill() throws Exception {
		String uri = "/bill/update/3";
		Bill bill = new Bill();
		bill.setId(3);
		bill.setBillDate(new Date());
		bill.setCost(3460.60);
		bill.setNotes("Notes");
		String inputJson = super.mapToJson(bill);
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(inputJson)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "Bill updated successsfully");
	}
	
	@Test
	public void updateBill_2() throws Exception {
		String uri = "/bill/update/1000";
		Bill bill = new Bill();
		bill.setId(1000);
		bill.setBillDate(new Date());
		bill.setCost(5643.80);
		bill.setNotes("Notes updated");
		String inputJson = super.mapToJson(bill);
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(inputJson)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(400, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "");
	}
	
	@Test
	public void z_deleteBill() throws Exception {
		String uri = "/bill/delete/3";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content,"Bill deleted successsfully");
	}

}
