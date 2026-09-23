package com.training.lmsdbapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DBConnection {

    private DBConnection() {
    }

    public static Connection getConnection() throws SQLException {
        String url = System.getenv("LMSDB_JDBC_URL");
        if (url == null || url.isBlank()) {
            throw new SQLException("LMSDB_JDBC_URL is not set");
        }
        return DriverManager.getConnection(url);
    }
}
