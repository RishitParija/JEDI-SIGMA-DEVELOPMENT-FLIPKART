package com.flipfit.dao;

import com.flipfit.bean.Schedule;
import java.time.LocalDate;
import java.util.List;

/// Classs level Comminting

// TODO: Auto-generated Javadoc
/**
 * The Interface ScheduleDAO.
 *
 * @author Rishit
 * @ClassName "ScheduleDAO"
 */
public interface ScheduleDAO {

    // MEthod level Commenting

    /**
     * Adds the schedule.
     *
     * @param schedule the schedule
     */
    void addSchedule(Schedule schedule);

    // MEthod level Commenting

    /**
     * Gets schedule by id.
     *
     * @param scheduleId the schedule id
     * @return the schedule by id
     */
    Schedule getScheduleById(String scheduleId);

    // MEthod level Commenting

    /**
     * Gets schedules by date.
     *
     * @param date the date
     * @return the schedules by date
     */
    List<Schedule> getSchedulesByDate(LocalDate date);

    // MEthod level Commenting

    /**
     * Update schedule seats.
     *
     * @param scheduleId     the schedule id
     * @param availableSeats the available seats
     */
    void updateScheduleSeats(String scheduleId, int availableSeats);
}
