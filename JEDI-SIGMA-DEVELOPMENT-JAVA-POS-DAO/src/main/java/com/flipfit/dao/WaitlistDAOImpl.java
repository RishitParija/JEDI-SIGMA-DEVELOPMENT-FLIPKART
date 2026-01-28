package com.flipfit.dao;

import com.flipfit.bean.Waitlist;
import com.flipfit.util.DBConnection;
import com.flipfit.constants.SQLConstants;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The Class WaitlistDAOImpl.
 *
 * @author Rishit
 * @ClassName "WaitlistDAOImpl"
 */
public class WaitlistDAOImpl implements WaitlistDAO {

    @Override
    public void addWaitlistEntry(Waitlist waitlist) {
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(SQLConstants.ADD_WAITLIST_QUERY)) {
            stmt.setString(1, waitlist.getWaitlistId());
            stmt.setString(2, waitlist.getUserId());
            stmt.setString(3, waitlist.getScheduleId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Waitlist> getWaitlistByScheduleId(String scheduleId) {
        List<Waitlist> waitlist = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(SQLConstants.GET_WAITLIST_BY_SCHEDULE_QUERY)) {
            stmt.setString(1, scheduleId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Waitlist entry = new Waitlist(
                        rs.getString("waitlistId"),
                        rs.getString("userId"),
                        rs.getString("scheduleId"));
                // requestDate is set to LocalDateTime.now() in constructor by default,
                // but ideally we should fetch from DB.
                // For simplicity, keeping it basic.
                waitlist.add(entry);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return waitlist;
    }

    @Override
    public void removeWaitlistEntry(String waitlistId) {
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(SQLConstants.DELETE_WAITLIST_QUERY)) {
            stmt.setString(1, waitlistId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
