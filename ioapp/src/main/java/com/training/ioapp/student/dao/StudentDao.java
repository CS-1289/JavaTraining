package com.training.ioapp.student.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.training.ioapp.student.model.Student;

public class StudentDao {

    private static final String CREATE_TABLE =
            "CREATE TABLE IF NOT EXISTS students ("
                    + "student_id INT NOT NULL,"
                    + "first_name VARCHAR(45) NOT NULL,"
                    + "last_name VARCHAR(45) NOT NULL,"
                    + "email VARCHAR(100) NOT NULL,"
                    + "course VARCHAR(100) NOT NULL,"
                    + "PRIMARY KEY (student_id))";

    private static final String INSERT_STUDENT =
            "INSERT INTO students (student_id, first_name, last_name, email, course) "
                    + "VALUES (?, ?, ?, ?, ?) "
                    + "ON DUPLICATE KEY UPDATE first_name = VALUES(first_name), last_name = VALUES(last_name), "
                    + "email = VALUES(email), course = VALUES(course)";

    public void createTable() throws SQLException {
        try (Connection connection = connection();
                Statement statement = connection.createStatement()) {
            statement.execute(CREATE_TABLE);
        }
    }

    public void saveAll(List<Student> students) throws SQLException {
        try (Connection connection = connection();
                PreparedStatement statement = connection.prepareStatement(INSERT_STUDENT)) {
            for (Student student : students) {
                statement.setInt(1, student.getId());
                statement.setString(2, student.getFirstName());
                statement.setString(3, student.getLastName());
                statement.setString(4, student.getEmail());
                statement.setString(5, student.getCourse());
                statement.addBatch();
            }
            statement.executeBatch();
        }
    }

    private Connection connection() throws SQLException {
        String url = System.getenv("LMSDB_JDBC_URL");
        if (url == null || url.trim().isEmpty()) {
            throw new SQLException("LMSDB_JDBC_URL is not set");
        }
        return DriverManager.getConnection(url);
    }
}
