package com.flipfit.bean;

import java.time.LocalDate;

// TODO: Auto-generated Javadoc
/**
 * The Class Booking.
 *
 * @author Rishit
 * @ClassName "Booking"
 */
public class Booking {
    private String bookingId;
    private String userId;
    private String scheduleId;
    private String gymId;
    private LocalDate date;
    private String status;

    /**
     * Instantiates a new booking.
     *
     * @param bookingId  the booking ID
     * @param userId     the user ID
     * @param scheduleId the schedule ID
     * @param gymId      the gym ID
     * @param date       the date
     * @param status     the status
     */
    public Booking(String bookingId, String userId, String scheduleId, String gymId, LocalDate date,
            String status) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.scheduleId = scheduleId;
        this.gymId = gymId;
        this.date = date;
        this.status = status;
    }

    // Getters and Setters
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
     * Gets the user id.
     *
     * @return the user id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets the user id.
     *
     * @param userId the new user id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Gets the schedule id.
     *
     * @return the schedule id
     */
    public String getScheduleId() {
        return scheduleId;
    }

    /**
     * Sets the schedule id.
     *
     * @param scheduleId the new schedule id
     */
    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
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
     * Gets the gym id.
     *
     * @return the gym id
     */
    public String getGymId() {
        return gymId;
    }

    /**
     * Sets the gym id.
     *
     * @param gymId the new gym id
     */
    public void setGymId(String gymId) {
        this.gymId = gymId;
    }

    /**
     * Gets the date.
     *
     * @return the date
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Sets the date.
     *
     * @param date the new date
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }
}
