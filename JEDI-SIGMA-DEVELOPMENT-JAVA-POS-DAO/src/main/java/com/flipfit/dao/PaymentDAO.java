package com.flipfit.dao;

import com.flipfit.bean.Payment;

/**
 * The Interface PaymentDAO.
 *
 * @author Rishit
 * @ClassName "PaymentDAO"
 */
public interface PaymentDAO {
    /**
     * Adds the payment.
     *
     * @param payment the payment
     */
    void addPayment(Payment payment);
}
