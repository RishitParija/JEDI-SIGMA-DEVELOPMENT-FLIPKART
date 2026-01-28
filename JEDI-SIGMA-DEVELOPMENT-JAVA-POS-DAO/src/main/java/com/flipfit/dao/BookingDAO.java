package com.flipfit.dao;

import com.flipfit.bean.Booking;
import java.util.List;

/// Classs level Comminting

// TODO: Auto-generated Javadoc
/**
 * The Interface BookingDAO.
 *
 * @author Rishit
 * @ClassName "BookingDAO"
 */
public interface BookingDAO {

    // MEthod level Commenting

    /**
     * Adds the booking.
     *
     * @param booking the booking
     */
    void addBooking(Booking booking);

    // MEthod level Commenting

    /**
     * Gets bookings by user id.
     *
     * @param userId the user id
     * @return the bookings by user id
     */
    List<Booking> getBookingsByUserId(String userId);

    // MEthod level Commenting

    /**
     * Gets booking by id.
     *
     * @param bookingId the booking id
     * @return the booking
     */
    Booking getBookingById(String bookingId);

    // MEthod level Commenting

    /**
     * Cancel booking.
     *
     * @param bookingId the booking id
     */
    void cancelBooking(String bookingId);

    // MEthod level Commenting

    /**
     * Gets all bookings.
     *
     * @return the all bookings
     */
    List<Booking> getAllBookings();
}
