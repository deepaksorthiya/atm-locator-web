package com.example.atmloc.controller;

import static org.junit.Assert.assertNotNull;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class AtmLocApiControllerTest {

	MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	private final static String TEST_USER_ID = "admin";

	@Test
	@WithMockUser
	public void testGetAtmsLocByCity() throws Exception {
		MvcResult result = mockMvc.perform(
				MockMvcRequestBuilders.get("/api/locator/atms?page=0&size=10&city=Nijmegen").with(user(TEST_USER_ID))
						.with(csrf()).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();
		String resultCZ = result.getResponse().getContentAsString();
		assertNotNull(resultCZ);
	}

	@Test
	@WithMockUser
	public void testGetAtmsLocAll() throws Exception {
		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.get("/api/locator/atms").with(user(TEST_USER_ID)).with(csrf())
						.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();
		String resultCZ = result.getResponse().getContentAsString();
		assertNotNull(resultCZ);
	}

}
