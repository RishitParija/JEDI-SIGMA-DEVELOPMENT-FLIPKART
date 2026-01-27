package com.flipfit.dao;

import com.flipfit.bean.GymCustomer;
import com.flipfit.helper.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public void registerCustomer(GymCustomer customer) {
        String userSql = "INSERT INTO User (userId, username, name, email, hashedPassword) VALUES (?, ?, ?, ?, ?)";
        String customerSql = "INSERT INTO GymCustomer (userId, walletBalance) VALUES (?, ?)";

        try (Connection conn = DBConnection.getConnection()) {
            conn.setAutoCommit(false);
            try (PreparedStatement uStmt = conn.prepareStatement(userSql);
                    PreparedStatement cStmt = conn.prepareStatement(customerSql)) {

                uStmt.setString(1, customer.getUserId());
                uStmt.setString(2, customer.getUsername());
                uStmt.setString(3, customer.getName());
                uStmt.setString(4, customer.getEmail());
                uStmt.setString(5, customer.getPasswordHash());
                uStmt.executeUpdate();

                cStmt.setString(1, customer.getUserId());
                cStmt.setDouble(2, customer.getWalletBalance());
                cStmt.executeUpdate();

                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean validateLogin(String username, String password) {
        String sql = "SELECT * FROM User u JOIN GymCustomer c ON u.userId = c.userId WHERE u.username = ? AND u.hashedPassword = ?";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public GymCustomer getCustomerByUsername(String username) {
        String sql = "SELECT * FROM User u JOIN GymCustomer c ON u.userId = c.userId WHERE u.username = ?";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new GymCustomer(
                        rs.getString("userId"),
                        rs.getString("username"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("hashedPassword"),
                        rs.getDouble("walletBalance"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateWalletBalance(String userId, double amount) {
        String sql = "UPDATE GymCustomer SET walletBalance = walletBalance + ? WHERE userId = ?";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, amount);
            stmt.setString(2, userId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
