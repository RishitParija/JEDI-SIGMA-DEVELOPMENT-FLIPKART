package com.flipfit.bean;

public class Payment {
    private String paymentId;
    private String bookingId;
    private Double amount;
    private String status; // "SUCCESS", "FAILED", "REFUNDED"

    public Payment() {

    }

    public Payment(String paymentId, String bookingId, Double amount, String status) {
        this.paymentId = paymentId;
        this.bookingId = bookingId;
        this.amount = amount;
        this.status = status;
    }

    // Getters and Setters
    public String getPaymentId() { return paymentId; }
    public void setPaymentId(String paymentId) { this.paymentId = paymentId; }

    public String getBookingId() { return bookingId; }
    public void setBookingId(String bookingId) { this.bookingId = bookingId; }

    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public void processRefund() {
        this.status = "REFUNDED";
        System.out.println("Refund processed for Payment ID: " + paymentId);
    }
}