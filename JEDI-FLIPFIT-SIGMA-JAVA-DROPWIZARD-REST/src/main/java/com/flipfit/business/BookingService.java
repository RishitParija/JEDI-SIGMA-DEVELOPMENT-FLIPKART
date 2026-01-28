package com.flipfit.business;

import com.flipfit.bean.Booking;
import java.util.List;

/// Class level Commenting

// TODO: Auto-generated Javadoc
/**
 * The Interface BookingService.
 *
 * @author Rishit
 * @ClassName "BookingService"
 */
public interface BookingService {

    // Method level Commenting

    /**
     * Adds booking.
     *
     * @param userId     the user id
     * @param scheduleId the schedule id
     * @return the booking
     */
    Booking addBooking(String userId, String scheduleId);

    // Method level Commenting

    /**
     * Cancel booking.
     *
     * @param bookingId the booking id
     * @return true, if successful
     */
    boolean cancelBooking(String bookingId);

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
     * Gets all bookings.
     *
     * @return the all bookings
     */
    List<Booking> getAllBookings();

    // Method level Commenting

    /**
     * Gets bookings by gym.
     *
     * @param gymId the gym id
     * @return the bookings by gym
     */
    List<Booking> getBookingsByGym(String gymId);

    // Method level Commenting

    /**
     * Gets schedule by id.
     *
     * @param scheduleId the schedule id
     * @return the schedule
     */
    com.flipfit.bean.Schedule getScheduleById(String scheduleId);

    // Method level Commenting

    /**
     * Gets slot by id.
     *
     * @param slotId the slot id
     * @return the slot
     */
    com.flipfit.bean.Slot getSlotById(String slotId);
}
