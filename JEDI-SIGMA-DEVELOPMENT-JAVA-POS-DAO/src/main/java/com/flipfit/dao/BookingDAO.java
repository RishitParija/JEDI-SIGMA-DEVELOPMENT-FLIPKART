package com.flipfit.dao;

import com.flipfit.bean.Booking;
import java.util.List;

/**
 * The Interface BookingDAO.
 *
 * @author Rishit
 * @ClassName "BookingDAO"
 */
public interface BookingDAO {
    /**
     * Adds the booking.
     *
     * @param booking the booking
     */
    void addBooking(Booking booking);

    /**
     * Gets bookings by user id.
     *
     * @param userId the user ID
     * @return the bookings by user id
     */
    List<Booking> getBookingsByUserId(String userId);

    /**
     * Gets booking by id.
     *
     * @param bookingId the booking ID
     * @return the booking
     */
    Booking getBookingById(String bookingId);

    /**
     * Cancel booking.
     *
     * @param bookingId the booking ID
     */
    void cancelBooking(String bookingId);

    /**
     * Gets all bookings.
     *
     * @return the list of all bookings
     */
    List<Booking> getAllBookings();
}
