package com.flipfit.util;

import java.sql.Connection;
import java.sql.DriverManager;
import com.flipfit.constants.SQLConnectorConstants;

// TODO: Auto-generated Javadoc
/**
 * The Class DBConnection.
 *
 * @author Rishit
 * @ClassName "DBConnection"
 */
public class DBConnection {

    /**
     * Gets the connection.
     *
     * @return the connection
     */
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(SQLConnectorConstants.JDBC_URL, SQLConnectorConstants.JDBC_USER,
                    SQLConnectorConstants.JDBC_PASSWORD);
        } catch (Exception e) {
            System.err.println("DB Connection Error: " + e.getMessage());
            return null;
        }
    }
}
