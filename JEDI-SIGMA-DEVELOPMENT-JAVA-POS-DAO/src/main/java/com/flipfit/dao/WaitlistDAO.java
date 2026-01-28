package com.flipfit.dao;

import com.flipfit.bean.Waitlist;
import java.util.List;

/// Classs level Comminting

// TODO: Auto-generated Javadoc
/**
 * The Interface WaitlistDAO.
 *
 * @author Rishit
 * @ClassName "WaitlistDAO"
 */
public interface WaitlistDAO {

    // MEthod level Commenting

    /**
     * Adds the to waitlist.
     *
     * @param waitlist the waitlist entry
     */
    void addWaitlistEntry(Waitlist waitlist);

    // MEthod level Commenting

    /**
     * Gets waitlist by schedule.
     *
     * @param scheduleId the schedule id
     * @return the waitlist entries
     */
    List<Waitlist> getWaitlistByScheduleId(String scheduleId);

    // MEthod level Commenting

    /**
     * Removes the waitlist entry.
     *
     * @param waitlistId the waitlist id
     */
    void removeWaitlistEntry(String waitlistId);
}
