package com.flipfit.business;

/// Class level Commenting

// TODO: Auto-generated Javadoc
/**
 * The Interface WaitlistService.
 *
 * @author Rishit
 * @ClassName "WaitlistService"
 */
public interface WaitlistService {
    // Method level Commenting

    /**
     * Adds the to waitlist.
     *
     * @param userId     the user id
     * @param scheduleId the schedule id
     */
    void addToWaitlist(String userId, String scheduleId);

    // Method level Commenting

    /**
     * Promote to booking.
     *
     * @param scheduleId the schedule id
     * @return true, if successful
     */
    boolean promoteToBooking(String scheduleId);
}