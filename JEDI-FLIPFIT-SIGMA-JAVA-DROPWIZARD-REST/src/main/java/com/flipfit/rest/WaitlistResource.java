package com.flipfit.rest;

import com.flipfit.business.WaitlistService;
import com.flipfit.business.WaitlistServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/waitlist")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class WaitlistResource {

    private final WaitlistService waitlistService = new WaitlistServiceImpl();

    @POST
    public Response addToWaitlist(@QueryParam("userId") String userId,
            @QueryParam("scheduleId") String scheduleId,
            @QueryParam("slotId") String slotId) {
        try {
            waitlistService.addToWaitlist(userId, scheduleId);

            // Create a response object with details
            java.util.Map<String, String> response = new java.util.HashMap<>();
            response.put("userId", userId);
            response.put("scheduleId", scheduleId);
            response.put("slotId", slotId);
            response.put("message", "Successfully added to waitlist for slot: " + slotId);
            response.put("status", "success");

            return Response.ok(response).build();
        } catch (Exception e) {
            java.util.Map<String, String> errorResponse = new java.util.HashMap<>();
            errorResponse.put("status", "error");
            errorResponse.put("message", "Failed to add to waitlist: " + e.getMessage());
            errorResponse.put("error", e.getClass().getSimpleName());

            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(errorResponse).build();
        }
    }

    @POST
    @Path("/promote")
    public Response promoteToBooking(@QueryParam("scheduleId") String scheduleId,
            @QueryParam("slotId") String slotId) {
        boolean success = waitlistService.promoteToBooking(scheduleId);
        if (success) {
            return Response.ok("User Promoted to Booking for slot: " + slotId).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Waitlist empty for schedule: " + scheduleId + ", slot: " + slotId).build();
        }
    }
}
