package com.flipfit.business;

import com.flipfit.bean.Booking;
import com.flipfit.bean.Schedule;
import com.flipfit.bean.Slot;
import com.flipfit.dao.BookingDAO;
import com.flipfit.dao.BookingDAOImpl;
import com.flipfit.dao.ScheduleDAO;
import com.flipfit.dao.ScheduleDAOImpl;
import com.flipfit.dao.SlotDAO;
import com.flipfit.dao.SlotDAOImpl;
import com.flipfit.exception.BookingNotDoneException;
import com.flipfit.exception.SlotNotAvailableException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/// Classs level Comminting

// TODO: Auto-generated Javadoc
/**
 * The Class BookingServiceImpl.
 *
 * @author Rishit
 * @ClassName "BookingServiceImpl"
 */
public class BookingServiceImpl implements BookingService {

    private BookingDAO bookingDAO = new BookingDAOImpl();
    private ScheduleDAO scheduleDAO = new ScheduleDAOImpl();
    private SlotDAO slotDAO = new SlotDAOImpl();

    // MEthod level Commenting

    @Override
    public Booking addBooking(String userId, String scheduleId) {
        Schedule schedule = scheduleDAO.getScheduleById(scheduleId);
        if (schedule == null) {
            throw new BookingNotDoneException("Booking Failed: Schedule not found for ID: " + scheduleId);
        }

        Slot slot = slotDAO.getSlotById(schedule.getSlotId());
        String gymId = (slot != null) ? slot.getCentreId() : "Unknown";
        java.time.LocalDate date = schedule.getDate();

        if (schedule.getAvailableSeats() <= 0) {
            throw new SlotNotAvailableException(
                    "Booking Failed: No seats available for schedule ID: " + scheduleId);
        }

        schedule.setAvailableSeats(schedule.getAvailableSeats() - 1);
        scheduleDAO.updateScheduleSeats(scheduleId, schedule.getAvailableSeats());

        try {
            Booking booking = new Booking(UUID.randomUUID().toString(), userId, scheduleId, gymId, date, "CONFIRMED");
            bookingDAO.addBooking(booking);
            return booking;
        } catch (Exception e) {
            throw new BookingNotDoneException("Booking failed for User: " + userId);
        }
    }

    // MEthod level Commenting

    @Override
    public List<Booking> getAllBookings() {
        return bookingDAO.getAllBookings();
    }

    // MEthod level Commenting

    @Override
    public List<Booking> getBookingsByGym(String gymId) {
        return new ArrayList<>(); // Needs BookingDAO support for gymId lookup
    }

    // MEthod level Commenting

    @Override
    public List<Booking> getBookingsByUserId(String userId) {
        return bookingDAO.getBookingsByUserId(userId);
    }

    // MEthod level Commenting

    /**
     * Cancel booking and update seats/waitlist.
     *
     * @param bookingId the booking id
     * @return true, if successful
     */
    @Override
    public boolean cancelBooking(String bookingId) {
        try {
            Booking booking = bookingDAO.getBookingById(bookingId);
            if (booking == null || booking.getStatus().equals("CANCELLED")) {
                return false;
            }

            // 1. Mark as cancelled in DB
            bookingDAO.cancelBooking(bookingId);
            String scheduleId = booking.getScheduleId();

            // 2. Increment seats first to make space for promotion or just reflect free
            // slot
            Schedule schedule = scheduleDAO.getScheduleById(scheduleId);
            if (schedule != null) {
                int newSeats = schedule.getAvailableSeats() + 1;
                scheduleDAO.updateScheduleSeats(scheduleId, newSeats);
            }

            // 3. Attempt promotion from waitlist
            WaitlistService waitlistService = new WaitlistServiceImpl();
            waitlistService.promoteToBooking(scheduleId);

            // 4. Notify the user about cancellation
            NotificationService notificationService = new NotificationServiceImpl();
            notificationService.sendNotification(booking.getUserId(),
                    "Your booking with ID " + bookingId + " has been successfully cancelled.");

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // MEthod level Commenting

    @Override
    public com.flipfit.bean.Schedule getScheduleById(String scheduleId) {
        return scheduleDAO.getScheduleById(scheduleId);
    }

    // MEthod level Commenting

    @Override
    public com.flipfit.bean.Slot getSlotById(String slotId) {
        return slotDAO.getSlotById(slotId);
    }
}
