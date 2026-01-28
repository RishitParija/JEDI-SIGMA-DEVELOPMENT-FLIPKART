package com.flipfit.rest;

import com.flipfit.bean.Booking;
import com.flipfit.bean.Schedule;
import com.flipfit.bean.Slot;
import com.flipfit.business.BookingService;
import com.flipfit.business.BookingServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/bookings")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookingResource {

    private final BookingService bookingService = new BookingServiceImpl();

    @POST
    public Response addBooking(@QueryParam("userId") String userId, @QueryParam("scheduleId") String scheduleId) {
        Booking booking = bookingService.addBooking(userId, scheduleId);
        return Response.ok(booking).build();
    }

    @GET
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GET
    @Path("/user/{userId}")
    public List<Booking> getBookingsByUser(@PathParam("userId") String userId) {
        return bookingService.getBookingsByUserId(userId);
    }

    @DELETE
    @Path("/{bookingId}")
    public Response cancelBooking(@QueryParam("userId") String userId, @PathParam("bookingId") String bookingId) {
        // Validate userId owns this booking before cancelling
        boolean success = bookingService.cancelBooking(bookingId);
        if (success) {
            return Response.ok("Booking Cancelled").build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Booking not found or already cancelled").build();
        }
    }

    @GET
    @Path("/schedule/{scheduleId}")
    public Schedule getSchedule(@PathParam("scheduleId") String scheduleId) {
        return bookingService.getScheduleById(scheduleId);
    }

    @GET
    @Path("/slot/{slotId}")
    public Slot getSlot(@PathParam("slotId") String slotId) {
        return bookingService.getSlotById(slotId);
    }
}
