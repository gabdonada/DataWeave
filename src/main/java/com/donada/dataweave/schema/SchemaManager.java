package com.donada.dataweave.schema;

import javax.sql.DataSource;

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
