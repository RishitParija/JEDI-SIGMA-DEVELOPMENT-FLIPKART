package com.flipfit.bean;

import java.time.LocalDateTime;

public class Booking {
    private String bookingId;
    private String userId;
    private String scheduleId; // Added to link booking to a specific schedule
    private LocalDateTime bookingDate;
    private Double totalAmount;
    private String status; // "CONFIRMED", "CANCELLED", "WAITLISTED"

    public Booking() {

    }

    public Booking(String bookingId, String userId, String scheduleId, Double totalAmount, String status) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.scheduleId = scheduleId;
        this.bookingDate = LocalDateTime.now();
        this.totalAmount = totalAmount;
        this.status = status;
    }

    // Getters and Setters
    public String getBookingId() { return bookingId; }
    public void setBookingId(String bookingId) { this.bookingId = bookingId; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getScheduleId() { return scheduleId; }
    public void setScheduleId(String scheduleId) { this.scheduleId = scheduleId; }

    public LocalDateTime getBookingDate() { return bookingDate; }
    public void setBookingDate(LocalDateTime bookingDate) { this.bookingDate = bookingDate; }

    public Double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(Double totalAmount) { this.totalAmount = totalAmount; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public void cancel() {
        this.status = "CANCELLED";
        System.out.println("Booking " + bookingId + " has been cancelled.");
    }
}
