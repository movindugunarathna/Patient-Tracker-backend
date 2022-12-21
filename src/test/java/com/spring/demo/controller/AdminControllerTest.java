package com.spring.demo.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.spring.demo.PatientTest;
import com.spring.demo.domain.Admin;

public class AdminControllerTest extends PatientTest {

	@Override
	@Before
	public void setUp() {
		super.setUp();
	}

	@Test
	public void getAdminListTest() throws Exception {
		String uri = "/admin/list";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Admin[] adminlist = super.mapFromJson(content, Admin[].class);
		assertTrue(adminlist.length > 0);
	}

	@Test
	public void createAdminTest() throws Exception {
		String uri = "/admin/add";
		Admin admin = new Admin(1L, "John", "Doe", "34", "Male", "0716785743", "sadasdw");
		String inputJson = super.mapToJson(admin);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, content);
	}

	@Test
	public void removeAdminTest() throws Exception {
		String uri = "/admin/remove/1";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, content);
	}
}
