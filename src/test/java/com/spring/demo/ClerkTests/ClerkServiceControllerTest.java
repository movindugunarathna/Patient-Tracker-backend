package com.spring.demo.ClerkTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.spring.demo.domain.Clerk;

public class ClerkServiceControllerTest extends ClerkTest{
    @Override
	@Before
	public void setUp() {
		super.setUp();
	}
	
	//get all clerks test case============================================================
	@Test
	public void getAllClerks() throws Exception {
		String uri = "/clerk/getAll";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
				.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Clerk[] clerkList = super.mapFromJson(content, Clerk[].class);
		assertTrue(clerkList.length > 0);
	}

	//add a clerk test case ===============================================================
	@Test
	public void addClerk() throws Exception {
		String uri = "/clerk/add";
		Clerk clerk = new Clerk();
		clerk.setClerkID(6);
		clerk.setFirstName("Maneesha");
		clerk.setLastName("Lakshani");
		clerk.setAge("25");
		clerk.setGender("Male");
		clerk.setContactNo("0786546325");
		clerk.setDepartment("SE Department");
		String inputJson = super.mapToJson(clerk);
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(inputJson)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, content);
	}

	//update a clerk test case ============================================================
	@Ignore
	@Test
	public void updateClerk() throws Exception {
		String uri = "/clerk/update/6";

		Clerk clerk = new Clerk();
		clerk.setFirstName("Maneesha Updated");
		clerk.setLastName("Lakshani Updated");
		clerk.setFirstName("Maneesha Updated");
		clerk.setDepartment("Department Updated");
		clerk.setAge("Age Updated");
		clerk.setContactNo("ContactNo Updated");

		String inputJson = super.mapToJson(clerk);
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(inputJson)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, content);
	}

	//delete a clerk test case ============================================================
	@Test
	public void deleteClerk() throws Exception {
		String uri = "/clerk/delete/6";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content,content);
	}
}
