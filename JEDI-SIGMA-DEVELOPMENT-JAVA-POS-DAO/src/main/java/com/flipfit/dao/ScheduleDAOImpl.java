package com.flipfit.dao;

import com.flipfit.bean.Schedule;
import com.flipfit.util.DBConnection;
import com.flipfit.constants.SQLConstants;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/// Classs level Comminting

// TODO: Auto-generated Javadoc
/**
 * The Class ScheduleDAOImpl.
 *
 * @author Rishit
 * @ClassName "ScheduleDAOImpl"
 */
public class ScheduleDAOImpl implements ScheduleDAO {

    // MEthod level Commenting

    /**
     * Adds the schedule.
     *
     * @param schedule the schedule
     */
    @Override
    public void addSchedule(Schedule schedule) {
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(SQLConstants.ADD_SCHEDULE_QUERY)) {
            stmt.setString(1, schedule.getScheduleId());
            stmt.setString(2, schedule.getSlotId());
            stmt.setDate(3, Date.valueOf(schedule.getDate()));
            stmt.setInt(4, schedule.getAvailableSeats());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // MEthod level Commenting

    /**
     * Gets schedule by id.
     *
     * @param scheduleId the schedule id
     * @return the schedule by id
     */
    @Override
    public Schedule getScheduleById(String scheduleId) {
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(SQLConstants.GET_SCHEDULE_BY_ID_QUERY)) {
            stmt.setString(1, scheduleId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Schedule schedule = new Schedule(
                        rs.getString("scheduleId"),
                        rs.getString("slotId"),
                        rs.getDate("date").toLocalDate(),
                        rs.getInt("availableSeats"));
                schedule.setIsCancelled(rs.getBoolean("isCancelled"));
                return schedule;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // MEthod level Commenting

    /**
     * Gets schedules by date.
     *
     * @param date the date
     * @return the schedules by date
     */
    @Override
    public List<Schedule> getSchedulesByDate(LocalDate date) {
        List<Schedule> schedules = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(SQLConstants.GET_SCHEDULES_BY_DATE_QUERY)) {
            stmt.setDate(1, Date.valueOf(date));
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Schedule schedule = new Schedule(
                        rs.getString("scheduleId"),
                        rs.getString("slotId"),
                        rs.getDate("date").toLocalDate(),
                        rs.getInt("availableSeats"));
                schedule.setIsCancelled(rs.getBoolean("isCancelled"));
                schedules.add(schedule);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return schedules;
    }

    // MEthod level Commenting

    /**
     * Update schedule seats.
     *
     * @param scheduleId     the schedule id
     * @param availableSeats the available seats
     */
    @Override
    public void updateScheduleSeats(String scheduleId, int availableSeats) {
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(SQLConstants.UPDATE_SCHEDULE_SEATS_QUERY)) {
            stmt.setInt(1, availableSeats);
            stmt.setString(2, scheduleId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
