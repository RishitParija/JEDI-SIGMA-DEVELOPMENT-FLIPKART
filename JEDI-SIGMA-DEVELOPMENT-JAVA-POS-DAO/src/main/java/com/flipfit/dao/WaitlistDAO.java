package com.flipfit.dao;

import com.flipfit.bean.Waitlist;
import java.util.List;

/**
 * The Interface WaitlistDAO.
 *
 * @author Rishit
 * @ClassName "WaitlistDAO"
 */
public interface WaitlistDAO {
    /**
     * Adds the to waitlist.
     *
     * @param waitlist the waitlist entry
     */
    void addWaitlistEntry(Waitlist waitlist);

    /**
     * Gets waitlist by schedule.
     *
     * @param scheduleId the schedule ID
     * @return the waitlist entries
     */
    List<Waitlist> getWaitlistByScheduleId(String scheduleId);

    /**
     * Removes the waitlist entry.
     *
     * @param waitlistId the waitlist ID
     */
    void removeWaitlistEntry(String waitlistId);
}
