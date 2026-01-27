package com.flipfit.business;

public interface WaitlistService {
    void addToWaitlist(String userId, String scheduleId);

    boolean promoteToBooking(String scheduleId);
}