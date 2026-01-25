package com.flipfit.business;

import com.flipfit.bean.Booking;
import java.util.List;

public interface BookingService {
    Booking addBooking(String userId, String scheduleId);

    boolean cancelBooking(String bookingId);

    List<Booking> getBookingsByUserId(String userId);

    List<Booking> getAllBookings();

    List<Booking> getBookingsByGym(String gymId);
}
