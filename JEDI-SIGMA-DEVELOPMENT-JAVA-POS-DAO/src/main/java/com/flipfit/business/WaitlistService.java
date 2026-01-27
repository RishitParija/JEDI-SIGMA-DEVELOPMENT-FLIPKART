package com.flipfit.business;

// TODO: Auto-generated Javadoc
/**
 * The Interface WaitlistService.
 *
 * @author Shravya
 * @ClassName "WaitlistService"
 */
public interface WaitlistService {
    /**
     * Adds the to waitlist.
     *
     * @param userId     the user ID
     * @param scheduleId the schedule ID
     */
    void addToWaitlist(String userId, String scheduleId);

    /**
     * Promote to booking.
     *
     * @param scheduleId the schedule ID
     * @return true, if successful
     */
    boolean promoteToBooking(String scheduleId);
}