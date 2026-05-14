package com.donada.dataweave.schema;


import com.donada.dataweave.dataset.Dataset;
import com.donada.dataweave.dataset.FieldDefinition;
import com.donada.dataweave.dataset.FieldType;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SqlBuilderTest {

    private static Connection connection;
    private static DataSource dataSource;
    private static JdbcTemplate jdbcTemplate;
    private static SqlBuilder sqlBuilder = new SqlBuilder();

    @BeforeAll
    static void setup() throws Exception {
        connection = DriverManager.getConnection("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1", "sa", "");
        dataSource = new SingleConnectionDataSource(connection, true);
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @AfterAll
    static void cleanup() throws Exception {
        connection.close();
    }

    @Test
    void testBuildCreateTableSql() {
        // Given
        String tableName = "test_table";

        List<FieldDefinition> fieldDefinitions = List.of(
                new FieldDefinition("id", FieldType.NUMBER, null, false, false, false),
                new FieldDefinition("name", FieldType.STRING, "255", false, false, false), // Provide varcharSize
                new FieldDefinition("created_at", FieldType.TIMESTAMP, null, false, false, false)
        );
        Dataset dataset = new Dataset(tableName, fieldDefinitions);

        // When
        String sql = sqlBuilder.buildCreateTable(dataset);
        jdbcTemplate.execute(sql);

        // Then
        List<String> columns = jdbcTemplate.queryForList(
                "SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = ?", String.class, tableName.toUpperCase());

        // Extract field names from fieldDefinitions and convert to uppercase for comparison
        List<String> expectedColumns = fieldDefinitions.stream().map(f -> f.name().toUpperCase()).toList();
        assertTrue(columns.containsAll(expectedColumns));
    }
}