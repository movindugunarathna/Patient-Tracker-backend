package com.spring.demo;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = PatientTrackerBackendApplication.class)
@WebAppConfiguration
class DoctorTestController {

	protected MockMvc mvc;
	
	@Autowired
	WebApplicationContext webAppContext;
	
	protected void setUp() {
		mvc = MockMvcBuilders.webAppContextSetup(webAppContext).build();
	}
	
	protected String mapToJson(Object obj) throws JsonProcessingException{
		ObjectMapper objMapp = new ObjectMapper();
		return objMapp.writeValueAsString(obj);
	}
	
	protected <T> T mapFromJson(String json, Class<T> clazz) 
			throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper obMapp = new ObjectMapper();
		return obMapp.readValue(json, clazz);
	}

}
