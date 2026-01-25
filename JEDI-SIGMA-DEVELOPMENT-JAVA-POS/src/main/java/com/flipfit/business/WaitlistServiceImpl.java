package com.flipfit.business;

public class WaitlistServiceImpl implements WaitlistService {
    @Override
    public void promoteToBooking(String scheduleId) {
        System.out.println("Checking waitlist for schedule: " + scheduleId);
        // Logic: Find first in waitlist for scheduleId
        // Create booking
        // Remove from waitlist
        // This requires access to Waitlist Data. Assuming in-memory list here.
    }
}