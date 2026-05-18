package com.donada.dataweave.schema;

import com.donada.dataweave.infrastructure.ConnectionProvider;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Component
public class SchemaManager {
    // This class should receive SQL, execute and handle DB connections

    private final ConnectionProvider connectionProvider;

    public SchemaManager(ConnectionProvider connectionProvider) {
        this.connectionProvider = connectionProvider;
    }

    public void createTable(String sql) {
        try (Connection conn = connectionProvider.getConnection();
                Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
