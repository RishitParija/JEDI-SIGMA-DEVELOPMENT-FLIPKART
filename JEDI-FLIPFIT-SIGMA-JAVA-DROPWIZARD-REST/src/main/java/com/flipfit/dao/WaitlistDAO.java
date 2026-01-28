package com.flipfit.dao;

import com.flipfit.bean.Waitlist;
import java.util.List;

/// Class level Commenting

// TODO: Auto-generated Javadoc
/**
 * The Interface WaitlistDAO.
 *
 * @author Rishit
 * @ClassName "WaitlistDAO"
 */
public interface WaitlistDAO {

    // Method level Commenting

    /**
     * Adds the to waitlist.
     *
     * @param waitlist the waitlist entry
     */
    void addWaitlistEntry(Waitlist waitlist);

    // Method level Commenting

    /**
     * Gets waitlist by schedule.
     *
     * @param scheduleId the schedule id
     * @return the waitlist entries
     */
    List<Waitlist> getWaitlistByScheduleId(String scheduleId);

    // Method level Commenting

    /**
     * Removes the waitlist entry.
     *
     * @param waitlistId the waitlist id
     */
    void removeWaitlistEntry(String waitlistId);
}
