package com.donada.dataweave.schema;

import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class SchemaManager {
    // This class should receive SQL, execute and handle DB connections

    private final DataSource dataSource;

    public SchemaManager(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void createTable(String sql) {
        // execute SQL
    }
}
