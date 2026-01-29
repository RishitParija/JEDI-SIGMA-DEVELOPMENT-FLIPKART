package com.flipfit.dao;

import com.flipfit.bean.Payment;
import com.flipfit.util.DBConnection;
import com.flipfit.constants.SQLConstants;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

/// Class level Commenting

// TODO: Auto-generated Javadoc
/**
 * The Class PaymentDAOImpl.
 *
 * @author Rishit
 * @ClassName "PaymentDAOImpl"
 */
public class PaymentDAOImpl implements PaymentDAO {

    // Method level Commenting

    /**
     * Adds the payment.
     *
     * @param payment the payment
     */
    @Override
    public void addPayment(Payment payment) {
        // FIX: Generate UUID for Payment if null
        if (payment.getPaymentId() == null) {
            payment.setPaymentId(UUID.randomUUID().toString());
        }

        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(SQLConstants.ADD_PAYMENT_QUERY)) {

            stmt.setString(1, payment.getPaymentId());
            stmt.setString(2, payment.getBookingId()); // Must exist in Booking table
            stmt.setDouble(3, payment.getAmount());
            stmt.setString(4, payment.getStatus());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error recording payment: " + e.getMessage());
        }
    }
}
