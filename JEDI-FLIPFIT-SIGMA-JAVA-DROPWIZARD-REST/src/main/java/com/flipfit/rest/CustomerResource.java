package com.flipfit.rest;

import com.flipfit.bean.GymCentre;
import com.flipfit.bean.Schedule;
import com.flipfit.business.GymCustomerService;
import com.flipfit.business.GymCustomerServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;
import java.util.List;

@Path("/customer")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerResource {

    private final GymCustomerService customerService = new GymCustomerServiceImpl();

    @GET
    @Path("/gyms/{city}")
    public List<GymCentre> getGymsByCity(@PathParam("city") String city) {
        return customerService.getGymsByCity(city);
    }

    @POST
    @Path("/book-slot")
    public Response bookSlot(@QueryParam("userId") String userId,
            @QueryParam("gymId") String gymId,
            @QueryParam("slotId") String slotId,
            @QueryParam("date") String date) {
        try {
            LocalDate localDate = LocalDate.parse(date);

            // Get schedules for the given gym and date
            List<Schedule> schedules = customerService.getSchedulesByGymAndDate(gymId, localDate);

            // Find the schedule that matches the slotId
            Schedule targetSchedule = schedules.stream()
                    .filter(s -> s.getSlotId().equals(slotId))
                    .findFirst()
                    .orElse(null);

            if (targetSchedule == null) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("No schedule found for the given slot and date").build();
            }

            // Use BookingService to create the booking
            com.flipfit.business.BookingService bookingService = new com.flipfit.business.BookingServiceImpl();
            com.flipfit.bean.Booking booking = bookingService.addBooking(userId, targetSchedule.getScheduleId());

            return Response.ok(booking).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Booking Failed: " + e.getMessage()).build();
        }
    }

    @GET
    @Path("/schedules")
    public List<Schedule> getSchedules(@QueryParam("userId") String userId,
            @QueryParam("gymId") String gymId,
            @QueryParam("date") String date) {
        LocalDate localDate = LocalDate.parse(date);
        return customerService.getSchedulesByGymAndDate(gymId, localDate);
    }

    @POST
    @Path("/update-wallet")
    public Response updateWallet(@QueryParam("userId") String userId, @QueryParam("amount") double amount) {
        customerService.updateWallet(userId, amount);
        return Response.ok("Wallet Updated").build();
    }

    @GET
    @Path("/profile")
    public Response getProfile(@QueryParam("userId") String userId) {
        // In a real app, you'd validate userId matches the authenticated user
        return Response.ok(customerService.getCustomerByUsername(userId)).build();
    }
}
