package com.flipfit.business;

import com.flipfit.bean.Waitlist;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class WaitlistServiceImpl implements WaitlistService {

    public static List<Waitlist> waitlistEntries = new ArrayList<>();

    @Override
    public void addToWaitlist(String userId, String scheduleId) {
        Waitlist entry = new Waitlist(UUID.randomUUID().toString(), userId, scheduleId);
        waitlistEntries.add(entry);
        System.out.println("User " + userId + " added to waitlist for Schedule " + scheduleId);
    }

    @Override
    public boolean promoteToBooking(String scheduleId) {
        // Find first user in waitlist for this schedule
        // Sort by date ideally, but list order preserves insertion order
        for (Waitlist entry : waitlistEntries) {
            if (entry.getScheduleId().equals(scheduleId)) {
                // Found candidate
                String userId = entry.getUserId();
                System.out.println("Waitlist Promotion: Promoting User " + userId);

                // Create Booking (Calling BookingService directly might cause circular
                // dependency if not careful)
                // Better approach: Return the userId to BookingService, or use a new instance
                // here if stateless.
                // Assuming BookingService has static list or using singleton pattern. Current
                // impl is new instance safe enough for list access?
                // Wait, BookingServiceImpl uses static list. So logic is safe.
                BookingService bookingService = new BookingServiceImpl();
                bookingService.addBooking(userId, scheduleId);

                // Remove from waitlist
                waitlistEntries.remove(entry);
                return true;
            }
        }
        return false;
    }
}