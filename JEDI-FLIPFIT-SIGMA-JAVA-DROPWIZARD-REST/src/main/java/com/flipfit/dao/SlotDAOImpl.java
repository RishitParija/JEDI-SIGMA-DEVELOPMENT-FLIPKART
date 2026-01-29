package com.flipfit.dao;

import com.flipfit.bean.Slot;
import com.flipfit.util.DBConnection;
import com.flipfit.constants.SQLConstants;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/// Class level Commenting

// TODO: Auto-generated Javadoc
/**
 * The Class SlotDAOImpl.
 *
 * @author Rishit
 * @ClassName "SlotDAOImpl"
 */
public class SlotDAOImpl implements SlotDAO {

    // Method level Commenting

    /**
     * Adds the slot.
     *
     * @param slot the slot
     */
    @Override
    public void addSlot(Slot slot) {
        // FIX: Generate UUID for the Slot if it is null
        if (slot.getSlotId() == null) {
            slot.setSlotId(UUID.randomUUID().toString());
        }

        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(SQLConstants.ADD_SLOT_QUERY)) {

            stmt.setString(1, slot.getSlotId());
            stmt.setString(2, slot.getCentreId()); // Must be a valid UUID from GymCentre table

            // Ensure time is not null to avoid NullPointerException
            // Assumes getStartTime() returns LocalTime or String in "HH:MM:SS" format
            stmt.setTime(3, Time.valueOf(slot.getStartTime()));
            stmt.setTime(4, Time.valueOf(slot.getEndTime()));

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Recommended: Throw runtime exception to notify Service layer
            throw new RuntimeException("Error adding slot: " + e.getMessage());
        }
    }

    // Method level Commenting

    /**
     * Gets slots by centre id.
     *
     * @param centreId the centre id
     * @return the slots by centre id
     */
    @Override
    public List<Slot> getSlotsByCentreId(String centreId) {
        List<Slot> slots = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(SQLConstants.GET_SLOTS_BY_CENTRE_QUERY)) {
            stmt.setString(1, centreId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Slot slot = new Slot(
                        rs.getString("slotId"),
                        rs.getString("centreId"),
                        rs.getTime("startTime").toLocalTime(),
                        rs.getTime("endTime").toLocalTime());
                slots.add(slot);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return slots;
    }

    // Method level Commenting

    /**
     * Gets slot by id.
     *
     * @param slotId the slot id
     * @return the slot by id
     */
    @Override
    public Slot getSlotById(String slotId) {
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(SQLConstants.GET_SLOT_BY_ID_QUERY)) {
            stmt.setString(1, slotId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Slot(
                        rs.getString("slotId"),
                        rs.getString("centreId"),
                        rs.getTime("startTime").toLocalTime(),
                        rs.getTime("endTime").toLocalTime());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
