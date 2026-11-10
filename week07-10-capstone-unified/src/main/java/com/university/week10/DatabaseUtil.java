package com.university.week10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUtil {
    private static final String MYSQL_URL = "jdbc:mysql://localhost:3306/university_db";
    private static final String H2_URL = "jdbc:h2:mem:university_db;DB_CLOSE_DELAY=-1";
    private static final String USER = "root";
    private static final String PASSWORD = "password";
    private static boolean useFallback = false;

    public static Connection getConnection() throws SQLException {
        if (!useFallback) {
            try {
                return DriverManager.getConnection(MYSQL_URL, USER, PASSWORD);
            } catch (SQLException e) {
                System.out.println("[DatabaseUtil] MySQL not available. Switching to embedded H2 database...");
                useFallback = true;
                initH2Database();
            }
        }
        return DriverManager.getConnection(H2_URL, "sa", "");
    }

    private static void initH2Database() {
        try (Connection conn = DriverManager.getConnection(H2_URL, "sa", "");
             Statement stmt = conn.createStatement()) {
            stmt.execute("CREATE TABLE IF NOT EXISTS students (" +
                    "student_id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "registration_number VARCHAR(20) UNIQUE NOT NULL, " +
                    "first_name VARCHAR(50) NOT NULL, " +
                    "last_name VARCHAR(50) NOT NULL, " +
                    "email VARCHAR(100) UNIQUE NOT NULL)");
            stmt.execute("MERGE INTO students KEY(registration_number) VALUES " +
                    "(1, 'S101', 'Alice', 'Mungai', 'S101@university.edu'), " +
                    "(2, 'S102', 'Bob', 'Kigera', 'S102@university.edu')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
