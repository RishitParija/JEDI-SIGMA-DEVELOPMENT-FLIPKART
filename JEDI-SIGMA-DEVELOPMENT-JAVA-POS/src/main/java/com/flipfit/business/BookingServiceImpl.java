package com.flipfit.business;

import com.flipfit.bean.Booking;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class BookingServiceImpl implements BookingService {

    public static List<Booking> bookingList = new ArrayList<>();

    @Override
    public Booking addBooking(String userId, String scheduleId) {
        // Need to find the schedule to get gymId and date
        com.flipfit.bean.Schedule schedule = null;
        for (com.flipfit.bean.Schedule s : GymOwnerServiceImpl.scheduleList) {
            if (s.getScheduleId().equals(scheduleId)) {
                schedule = s;
                break;
            }
        }

        String gymId = "Unknown";
        java.time.LocalDate date = null;

        if (schedule != null) {
            date = schedule.getDate();
            // Find slot to finding gymId (CentreID)
            for (com.flipfit.bean.Slot slot : GymOwnerServiceImpl.slotList) {
                if (slot.getSlotId().equals(schedule.getSlotId())) {
                    gymId = slot.getCentreId();
                    break;
                }
            }

            // DECREMENT LOGIC HERE
            if (schedule.getAvailableSeats() <= 0) {
                System.out.println("Booking Failed: No seats available.");
                return null;
            }

            schedule.setAvailableSeats(schedule.getAvailableSeats() - 1);
            System.out.println("Seats updated. Remaining: " + schedule.getAvailableSeats());
        } else {
            System.out.println("Schedule not found!");
            return null;
        }

        System.out.println("Attempting to book for User: " + userId);
        Booking booking = new Booking(UUID.randomUUID().toString(), userId, scheduleId, gymId, date, "CONFIRMED");
        bookingList.add(booking);

        System.out.println("Booking Confirmed for User: " + userId);

        return booking;
    }

    public List<Booking> getAllBookings() {
        return bookingList;
    }

    public List<Booking> getBookingsByGym(String gymId) {
        return bookingList.stream().filter(b -> b.getGymId() != null && b.getGymId().equals(gymId))
                .collect(Collectors.toList());
    }

    public List<Booking> getBookingsByUserId(String userId) {
        return bookingList.stream().filter(b -> b.getUserId().equals(userId)).collect(Collectors.toList());
    }

    public boolean cancelBooking(String bookingId) {
        for (Booking b : bookingList) {
            if (b.getBookingId().equals(bookingId) && !b.getStatus().equals("CANCELLED")) {
                b.setStatus("CANCELLED");
                System.out.println("Booking Cancelled.");

                // 1. Free up the seat
                for (com.flipfit.bean.Schedule s : GymOwnerServiceImpl.scheduleList) {
                    if (s.getScheduleId().equals(b.getScheduleId())) {
                        s.setAvailableSeats(s.getAvailableSeats() + 1);
                        System.out.println("Seat freed. Available seats: " + s.getAvailableSeats());

                        // 2. Trigger waitlist promotion
                        WaitlistService waitlistService = new WaitlistServiceImpl();
                        waitlistService.promoteToBooking(s.getScheduleId());
                        break;
                    }
                }

                return true;
            }
        }
        return false;
    }
}
