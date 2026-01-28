package com.flipfit.dao;

import com.flipfit.bean.Payment;
import com.flipfit.util.DBConnection;
import com.flipfit.constants.SQLConstants;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/// Classs level Comminting

// TODO: Auto-generated Javadoc
/**
 * The Class PaymentDAOImpl.
 *
 * @author Rishit
 * @ClassName "PaymentDAOImpl"
 */
public class PaymentDAOImpl implements PaymentDAO {

    // MEthod level Commenting

    /**
     * Adds the payment.
     *
     * @param payment the payment
     */
    @Override
    public void addPayment(Payment payment) {
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(SQLConstants.ADD_PAYMENT_QUERY)) {
            stmt.setString(1, payment.getPaymentId());
            stmt.setString(2, payment.getBookingId());
            stmt.setDouble(3, payment.getAmount());
            stmt.setString(4, payment.getStatus());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
