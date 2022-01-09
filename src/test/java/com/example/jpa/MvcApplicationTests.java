package com.example.jpa;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.jpa.controller.DataController;
import com.example.jpa.model.User;
import com.example.jpa.model.UserRepo;
import com.example.jpa.service.UserService;
import org.springframework.test.context.TestPropertySource;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:application-mock.properties")
class MvcApplicationTests {

	@Autowired
	DataController controller;

	@Autowired
	UserService service;

	@Autowired
	UserRepo repo;

	@Autowired
	List<User> user;

	@Autowired
	ObjectMapper objectMapper;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	void contextLoads() {
	}

	@Test
	public void findAll() {
		ResponseEntity<Object> response = controller.findAll();
		//System.out.println("lista"+response.getBody().toString());
		assertNotNull(response);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		List<User> userDetails = convertUserData(response);
		System.out.println("el nombre de: "+userDetails.get(0).getName());
		System.out.println("el tamaño: "+userDetails.size());

	}

	private List<User> convertUserData(ResponseEntity<Object> response) {
		user = null;
		try {
			String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(response.getBody());
			System.out.println("la cadena"+ json);
			user = objectMapper.readValue(json, new TypeReference<List<User>>() {});
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return user;
	}

}
