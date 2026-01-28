package com.flipfit.business;

import com.flipfit.bean.Waitlist;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

// TODO: Auto-generated Javadoc
/**
 * The Class WaitlistServiceImpl.
 *
 * @author Rishit
 * @ClassName "WaitlistServiceImpl"
 */
public class WaitlistServiceImpl implements WaitlistService {

    public static List<Waitlist> waitlistEntries = new ArrayList<>();

    /**
     * Adds the to waitlist.
     *
     * @param userId     the user ID
     * @param scheduleId the schedule ID
     */
    @Override
    public void addToWaitlist(String userId, String scheduleId) {
        Waitlist entry = new Waitlist(UUID.randomUUID().toString(), userId, scheduleId);
        waitlistEntries.add(entry);
        System.out.println("User " + userId + " added to waitlist for Schedule " + scheduleId);
    }

    /**
     * Promote to booking.
     *
     * @param scheduleId the schedule ID
     * @return true, if successful
     */
    @Override
    public boolean promoteToBooking(String scheduleId) {
        // Find first user in waitlist for this schedule
        // Sort by date ideally, but list order preserves insertion order
        for (Waitlist entry : waitlistEntries) {
            if (entry.getScheduleId().equals(scheduleId)) {
                // Found candidate
                String userId = entry.getUserId();
                System.out.println("Waitlist Promotion: Promoting User " + userId);

                // Create Booking
                BookingService bookingService = new BookingServiceImpl();
                bookingService.addBooking(userId, scheduleId);

                // Send Notification
                NotificationService notificationService = new NotificationServiceImpl();
                notificationService.sendNotification(userId,
                        "Good news! You have been promoted from waitlist to booked for Slot " + scheduleId);

                // Remove from waitlist
                waitlistEntries.remove(entry);
                return true;
            }
        }
        return false;
    }
}