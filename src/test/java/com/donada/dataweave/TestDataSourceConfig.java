package com.donada.dataweave;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import javax.sql.DataSource;
import org.mockito.Mockito;

@TestConfiguration
public class TestDataSourceConfig {
    @Bean
    public DataSource dataSource() {
        return Mockito.mock(DataSource.class);
    }
}
