package com.example.hoteldatabase;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.hoteldatabase.web.AsiakasController;

@SpringBootTest
class HoteldatabaseApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	AsiakasController asiakasController;
	@Test
	public void contextLoadsAsiakasContr() throws Exception {
		assertThat(asiakasController).isNotNull();
	}
	

}
