package com.donada.dataweave;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.mockito.Mockito;


@SpringBootTest(classes = {DataweaveApplication.class, DataweaveApplicationTests.MockDataSourceConfig.class})
class DataweaveApplicationTests {

	@TestConfiguration
	static class MockDataSourceConfig {
		@Bean
		public javax.sql.DataSource dataSource() {
			return Mockito.mock(javax.sql.DataSource.class);
		}
	}

	@Test
	void contextLoads() {
	}

}
