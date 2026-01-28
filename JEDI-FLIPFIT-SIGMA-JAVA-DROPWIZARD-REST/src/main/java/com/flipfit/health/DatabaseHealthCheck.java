package com.flipfit.health;

import com.codahale.metrics.health.HealthCheck;
import com.flipfit.util.DBConnection;
import java.sql.Connection;

public class DatabaseHealthCheck extends HealthCheck {

    @Override
    protected Result check() throws Exception {
        try (Connection connection = DBConnection.getConnection()) {
            if (connection != null && !connection.isClosed()) {
                return Result.healthy();
            } else {
                return Result.unhealthy("Cannot connect to database");
            }
        } catch (Exception e) {
            return Result.unhealthy("Database connection failed: " + e.getMessage());
        }
    }
}
