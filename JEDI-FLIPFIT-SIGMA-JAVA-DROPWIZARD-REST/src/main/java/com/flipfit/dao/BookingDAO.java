package com.flipfit.dao;

import com.flipfit.bean.Booking;
import java.util.List;

/// Class level Commenting

// TODO: Auto-generated Javadoc
/**
 * The Interface BookingDAO.
 *
 * @author Rishit
 * @ClassName "BookingDAO"
 */
public interface BookingDAO {

    // Method level Commenting

    /**
     * Adds the booking.
     *
     * @param booking the booking
     */
    void addBooking(Booking booking);

    // Method level Commenting

    /**
     * Gets bookings by user id.
     *
     * @param userId the user id
     * @return the bookings by user id
     */
    List<Booking> getBookingsByUserId(String userId);

    // Method level Commenting

    /**
     * Gets booking by id.
     *
     * @param bookingId the booking id
     * @return the booking
     */
    Booking getBookingById(String bookingId);

    // Method level Commenting

    /**
     * Cancel booking.
     *
     * @param bookingId the booking id
     */
    void cancelBooking(String bookingId);

    // Method level Commenting

    /**
     * Gets all bookings.
     *
     * @return the all bookings
     */
    List<Booking> getAllBookings();
}
