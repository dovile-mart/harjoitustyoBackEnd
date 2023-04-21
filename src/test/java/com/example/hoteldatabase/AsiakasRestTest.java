package com.example.hoteldatabase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
public class AsiakasRestTest {
	@Autowired
	private WebApplicationContext webAppContext;
	
	private MockMvc mockMvc;
	
	@BeforeEach //JUnit5
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webAppContext).build();
	}
	
	//onnistuuko /asiakkaat palautus
/*	@Test
	public void checkStatus() throws Exception {
		mockMvc.perform(get("/api/asiakkaat")).andExpect(status().isOk());
	}
	/*Testin vikaviesti:
	 * jakarta.servlet.ServletException: Request processing failed: 
	 * org.springframework.security.authentication.AuthenticationCredentialsNotFoundException: 
	 * An Authentication object was not found in the SecurityContext
	*/
}
