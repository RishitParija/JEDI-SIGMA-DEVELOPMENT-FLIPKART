package com.flipfit.bean;

import java.time.LocalDateTime;

public class Waitlist {
    private String waitlistId;
    private String userId;
    private String scheduleId;
    private LocalDateTime requestDate;

    public Waitlist(String waitlistId, String userId, String scheduleId) {
        this.waitlistId = waitlistId;
        this.userId = userId;
        this.scheduleId = scheduleId;
        this.requestDate = LocalDateTime.now();
    }

    public String getWaitlistId() {
        return waitlistId;
    }

    public void setWaitlistId(String waitlistId) {
        this.waitlistId = waitlistId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }

    public LocalDateTime getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDateTime requestDate) {
        this.requestDate = requestDate;
    }
}