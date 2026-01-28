package com.flipfit.dao;

import com.flipfit.bean.GymCustomer;
import com.flipfit.util.DBConnection;
import com.flipfit.constants.SQLConstants;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/// Class level Commenting

// TODO: Auto-generated Javadoc
/**
 * The Class CustomerDAOImpl.
 *
 * @author Rishit
 * @ClassName "CustomerDAOImpl"
 */
public class CustomerDAOImpl implements CustomerDAO {

    // Method level Commenting

    /**
     * Registers customer.
     *
     * @param customer the customer
     */
    @Override
    public void registerCustomer(GymCustomer customer) {
        try (Connection conn = DBConnection.getConnection()) {
            conn.setAutoCommit(false);
            try (PreparedStatement uStmt = conn.prepareStatement(SQLConstants.REGISTER_USER_QUERY);
                    PreparedStatement cStmt = conn.prepareStatement(SQLConstants.REGISTER_CUSTOMER_QUERY)) {

                uStmt.setString(1, customer.getUserId());
                uStmt.setString(2, customer.getUsername());
                uStmt.setString(3, customer.getName());
                uStmt.setString(4, customer.getEmail());
                uStmt.setString(5, customer.getPasswordHash());
                uStmt.setString(6, customer.getPhoneNumber());
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

    // Method level Commenting

    /**
     * Validates login.
     *
     * @param username the username
     * @param password the password
     * @return true, if successful
     */
    @Override
    public boolean validateLogin(String username, String password) {
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(SQLConstants.CUSTOMER_LOGIN_QUERY)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Method level Commenting

    /**
     * Gets customer by username.
     *
     * @param username the username
     * @return the customer by username
     */
    @Override
    public GymCustomer getCustomerByUsername(String username) {
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(SQLConstants.GET_CUSTOMER_BY_USERNAME_QUERY)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new GymCustomer(
                        rs.getString("userId"),
                        rs.getString("username"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("hashedPassword"),
                        rs.getDouble("walletBalance"),
                        rs.getString("phoneNumber"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Method level Commenting

    /**
     * Update wallet balance.
     *
     * @param userId the user id
     * @param amount the amount
     */
    @Override
    public void updateWalletBalance(String userId, double amount) {
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(SQLConstants.UPDATE_WALLET_BALANCE_QUERY)) {
            stmt.setDouble(1, amount);
            stmt.setString(2, userId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
