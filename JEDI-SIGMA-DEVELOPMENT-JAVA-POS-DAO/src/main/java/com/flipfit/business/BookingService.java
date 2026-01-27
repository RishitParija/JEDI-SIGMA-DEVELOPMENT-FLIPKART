package com.flipfit.business;

import com.flipfit.bean.Booking;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class BookingService.
 *
 * @author Shravya
 * @ClassName "BookingService"
 */
public interface BookingService {

    /**
     * Adds booking.
     *
     * @param userId     the user ID
     * @param scheduleId the schedule ID
     * @return the booking
     */
    Booking addBooking(String userId, String scheduleId);

    /**
     * Cancel booking.
     *
     * @param bookingId the booking ID
     * @return true, if successful
     */
    boolean cancelBooking(String bookingId);

    /**
     * Gets bookings by user id.
     *
     * @param userId the user ID
     * @return the bookings by user id
     */
    List<Booking> getBookingsByUserId(String userId);

    /**
     * Gets all bookings.
     *
     * @return the all bookings
     */
    List<Booking> getAllBookings();

    /**
     * Gets bookings by gym.
     *
     * @param gymId the gym ID
     * @return the bookings by gym
     */
    List<Booking> getBookingsByGym(String gymId);
}
