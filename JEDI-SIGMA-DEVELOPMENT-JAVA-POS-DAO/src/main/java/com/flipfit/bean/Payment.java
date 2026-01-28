package com.flipfit.bean;

// TODO: Auto-generated Javadoc
/**
 * The Class Payment.
 *
 * @author Rishit
 * @ClassName "Payment"
 */
public class Payment {
    private String paymentId;
    private String bookingId;
    private Double amount;
    private String status; // "SUCCESS", "FAILED", "REFUNDED"

    /**
     * Instantiates a new payment.
     */
    public Payment() {

    }

    /**
     * Instantiates a new payment.
     *
     * @param paymentId the payment ID
     * @param bookingId the booking ID
     * @param amount    the amount
     * @param status    the status
     */
    public Payment(String paymentId, String bookingId, Double amount, String status) {
        this.paymentId = paymentId;
        this.bookingId = bookingId;
        this.amount = amount;
        this.status = status;
    }

    // Getters and Setters
    /**
     * Gets the payment id.
     *
     * @return the payment id
     */
    public String getPaymentId() {
        return paymentId;
    }

    /**
     * Sets the payment id.
     *
     * @param paymentId the new payment id
     */
    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    /**
     * Gets the booking id.
     *
     * @return the booking id
     */
    public String getBookingId() {
        return bookingId;
    }

    /**
     * Sets the booking id.
     *
     * @param bookingId the new booking id
     */
    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    /**
     * Gets the amount.
     *
     * @return the amount
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * Sets the amount.
     *
     * @param amount the new amount
     */
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    /**
     * Gets the status.
     *
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status.
     *
     * @param status the new status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Process refund.
     */
    public void processRefund() {
        this.status = "REFUNDED";
        System.out.println("Refund processed for Payment ID: " + paymentId);
    }
}