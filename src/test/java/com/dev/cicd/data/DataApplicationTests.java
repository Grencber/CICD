package com.dev.cicd.data;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DataApplicationTests {

	@Autowired
	DataController dataController;

	@Test
	void contextLoads() {
	}

	@Test
	void health() {
		assertEquals( "Health check is OK", dataController.healthCheck());
	}

	@Test
	void version() {
		assertEquals( "The actual version is 1.0.0", dataController.version());
	}

	@Test
	void nationsLength() {
		Integer nationsLength = dataController.getRandomNations().size();
		assertEquals(10, nationsLength);
	}

	@Test
	void currenciesLength() {
		Integer currenciesLength = dataController.getCurrencies().size();
		assertEquals(10, currenciesLength);
	}
}
