package com.flipfit.business;

import com.flipfit.bean.Booking;
import com.flipfit.bean.Payment;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class BookingServiceImpl implements BookingService {

    private static List<Booking> bookingData = new ArrayList<>();
    private static List<Payment> paymentData = new ArrayList<>();

    @Override
    public Booking addBooking(String userId, String scheduleId) {
        return null;
    }

    @Override
    public boolean cancelBooking(String bookingId) {
        return true;
    }

    @Override
    public List<Booking> getBookingsByUserId(String userId) {
        return null;
    }

    private void processRefund(String bookingId) {}
}
