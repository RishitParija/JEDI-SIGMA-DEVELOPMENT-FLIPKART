package com.flipfit.constants;

public class Constants {
    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/FlipFit";
    public static final String JDBC_USER = "root";
    public static final String JDBC_PASSWORD = "Rishit12@708"; // Update with user's password if known, otherwise
                                                               // default to
    // "password"

    public static void loadMockData() {
        // Mock data seeding is disabled as we transition to MySQL.
        // You can use the generated flipfit_schema.sql to seed your database.
        System.out.println("System initialized (Database mode).");
    }
}
