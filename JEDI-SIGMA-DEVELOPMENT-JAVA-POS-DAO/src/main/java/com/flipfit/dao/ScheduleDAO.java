package com.flipfit.dao;

import com.flipfit.bean.Schedule;
import java.time.LocalDate;
import java.util.List;

/**
 * The Interface ScheduleDAO.
 *
 * @author Rishit
 * @ClassName "ScheduleDAO"
 */
public interface ScheduleDAO {
    /**
     * Adds the schedule.
     *
     * @param schedule the schedule
     */
    void addSchedule(Schedule schedule);

    /**
     * Gets schedule by id.
     *
     * @param scheduleId the schedule ID
     * @return the schedule by id
     */
    Schedule getScheduleById(String scheduleId);

    /**
     * Gets schedules by date.
     *
     * @param date the date
     * @return the schedules by date
     */
    List<Schedule> getSchedulesByDate(LocalDate date);

    /**
     * Update schedule seats.
     *
     * @param scheduleId     the schedule ID
     * @param availableSeats the available seats
     */
    void updateScheduleSeats(String scheduleId, int availableSeats);
}
