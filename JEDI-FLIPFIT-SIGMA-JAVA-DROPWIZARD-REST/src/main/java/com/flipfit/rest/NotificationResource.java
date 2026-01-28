package com.flipfit.rest;

import com.flipfit.business.NotificationService;
import com.flipfit.business.NotificationServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/notifications")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class NotificationResource {

    private final NotificationService notificationService = new NotificationServiceImpl();

    @POST
    public Response sendNotification(@QueryParam("userId") String userId, @QueryParam("message") String message) {
        notificationService.sendNotification(userId, message);
        return Response.ok("Notification Sent").build();
    }

    @GET
    @Path("/{userId}")
    public List<String> getNotifications(@PathParam("userId") String userId) {
        return notificationService.getNotifications(userId);
    }
}
