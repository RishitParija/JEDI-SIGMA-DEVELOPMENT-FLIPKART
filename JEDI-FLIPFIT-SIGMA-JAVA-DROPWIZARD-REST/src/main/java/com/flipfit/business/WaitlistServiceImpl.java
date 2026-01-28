package com.flipfit.business;

import com.flipfit.bean.Waitlist;
import com.flipfit.dao.WaitlistDAO;
import com.flipfit.dao.WaitlistDAOImpl;
import java.util.List;
import java.util.UUID;

/// Class level Commenting

// TODO: Auto-generated Javadoc
/**
 * The Class WaitlistServiceImpl.
 *
 * @author Rishit
 * @ClassName "WaitlistServiceImpl"
 */
public class WaitlistServiceImpl implements WaitlistService {

    private WaitlistDAO waitlistDAO = new WaitlistDAOImpl();

    // Method level Commenting

    @Override
    public void addToWaitlist(String userId, String scheduleId) {
        Waitlist entry = new Waitlist(UUID.randomUUID().toString(), userId, scheduleId);
        waitlistDAO.addWaitlistEntry(entry);
    }

    // Method level Commenting

    @Override
    public boolean promoteToBooking(String scheduleId) {
        List<Waitlist> waitlist = waitlistDAO.getWaitlistByScheduleId(scheduleId);
        if (waitlist.isEmpty()) {
            return false;
        }

        // Promote the first user (already ordered by requestDate ASC in DAO)
        Waitlist nextUser = waitlist.get(0);
        String userId = nextUser.getUserId();

        // Create Booking manually avoid circular dependency if needed or use simplified
        // logic
        // Actually, internal booking addition during promotion should bypass seat check
        // since we just vacated a seat.

        BookingService bookingService = new BookingServiceImpl();
        // We'll add a method or just call addBooking if it handles the seat correctly.
        // Wait, addBooking decrements seats.
        // Flow: Cancel -> promote -> addBooking (decrements) -> seats same as before
        // cancel.
        // This is correct because one seat was freed and immediately taken.

        bookingService.addBooking(userId, scheduleId);

        // Send Notification
        NotificationService notificationService = new NotificationServiceImpl();
        notificationService.sendNotification(userId,
                "Good news! You have been promoted from waitlist to booked for Schedule " + scheduleId);

        // Remove from waitlist
        waitlistDAO.removeWaitlistEntry(nextUser.getWaitlistId());
        return true;
    }
}