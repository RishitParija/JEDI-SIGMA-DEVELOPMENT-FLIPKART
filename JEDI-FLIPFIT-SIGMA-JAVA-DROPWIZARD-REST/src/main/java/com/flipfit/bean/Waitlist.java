package com.flipfit.bean;

import java.time.LocalDateTime;

// TODO: Auto-generated Javadoc
/**
 * The Class Waitlist.
 *
 * @author Rishit
 * @ClassName "Waitlist"
 */
public class Waitlist {
    private String waitlistId;
    private String userId;
    private String scheduleId;
    private LocalDateTime requestDate;

    /**
     * Instantiates a new waitlist.
     */
    public Waitlist() {
    }

    /**
     * Instantiates a new waitlist.
     *
     * @param waitlistId the waitlist id
     * @param userId     the user id
     * @param scheduleId the schedule id
     */
    public Waitlist(String waitlistId, String userId, String scheduleId) {
        this.waitlistId = waitlistId;
        this.userId = userId;
        this.scheduleId = scheduleId;
        this.requestDate = LocalDateTime.now();
    }

    /**
     * Gets the waitlist id.
     *
     * @return the waitlist id
     */
    public String getWaitlistId() {
        return waitlistId;
    }

    /**
     * Sets the waitlist id.
     *
     * @param waitlistId the new waitlist id
     */
    public void setWaitlistId(String waitlistId) {
        this.waitlistId = waitlistId;
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
     * Gets the request date.
     *
     * @return the request date
     */
    public LocalDateTime getRequestDate() {
        return requestDate;
    }

    /**
     * Sets the request date.
     *
     * @param requestDate the new request date
     */
    public void setRequestDate(LocalDateTime requestDate) {
        this.requestDate = requestDate;
    }
}