package com.flipfit.util;

import java.sql.Connection;
import java.sql.DriverManager;
import com.flipfit.constants.Constants;

// TODO: Auto-generated Javadoc
/**
 * The Class DBConnection.
 *
 * @author Rishit
 * @ClassName "DBConnection"
 */
public class DBConnection {
    private static Connection connection = null;

    /**
     * Gets the connection.
     *
     * @return the connection
     */
    public static Connection getConnection() {
        if (connection != null)
            return connection;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(Constants.JDBC_URL, Constants.JDBC_USER, Constants.JDBC_PASSWORD);
            return connection;
        } catch (Exception e) {
            System.err.println("DB Connection Error: " + e.getMessage());
            return null;
        }
    }
}
