package com.flipfit.dao;

import com.flipfit.bean.Booking;
import com.flipfit.util.DBConnection;
import com.flipfit.constants.SQLConstants;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The Class BookingDAOImpl.
 *
 * @author Rishit
 * @ClassName "BookingDAOImpl"
 */
public class BookingDAOImpl implements BookingDAO {

    /**
     * Adds the booking.
     *
     * @param booking the booking
     */
    @Override
    public void addBooking(Booking booking) {
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(SQLConstants.ADD_BOOKING_QUERY)) {
            stmt.setString(1, booking.getBookingId());
            stmt.setString(2, booking.getUserId());
            stmt.setString(3, booking.getScheduleId());
            stmt.setString(4, booking.getGymId());
            stmt.setDate(5, Date.valueOf(booking.getDate()));
            stmt.setString(6, booking.getStatus());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets bookings by user id.
     *
     * @param userId the user ID
     * @return the bookings by user id
     */
    @Override
    public List<Booking> getBookingsByUserId(String userId) {
        List<Booking> bookings = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(SQLConstants.GET_BOOKINGS_BY_USER_QUERY)) {
            stmt.setString(1, userId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Booking booking = new Booking(
                        rs.getString("bookingId"),
                        rs.getString("userId"),
                        rs.getString("scheduleId"),
                        rs.getString("gymId"),
                        rs.getDate("date").toLocalDate(),
                        rs.getString("status"));
                bookings.add(booking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookings;
    }

    /**
     * Cancel booking.
     *
     * @param bookingId the booking ID
     */
    @Override
    public void cancelBooking(String bookingId) {
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(SQLConstants.CANCEL_BOOKING_QUERY)) {
            stmt.setString(1, bookingId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets all bookings.
     *
     * @return the list of all bookings
     */
    @Override
    public List<Booking> getAllBookings() {
        List<Booking> bookings = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(SQLConstants.GET_ALL_BOOKINGS_QUERY);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Booking booking = new Booking(
                        rs.getString("bookingId"),
                        rs.getString("userId"),
                        rs.getString("scheduleId"),
                        rs.getString("gymId"),
                        rs.getDate("date").toLocalDate(),
                        rs.getString("status"));
                bookings.add(booking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookings;
    }

    /**
     * Gets booking by id.
     *
     * @param bookingId the booking ID
     * @return the booking
     */
    @Override
    public Booking getBookingById(String bookingId) {
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(SQLConstants.GET_BOOKING_BY_ID_QUERY)) {
            stmt.setString(1, bookingId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Booking(
                        rs.getString("bookingId"),
                        rs.getString("userId"),
                        rs.getString("scheduleId"),
                        rs.getString("gymId"),
                        rs.getDate("date").toLocalDate(),
                        rs.getString("status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
