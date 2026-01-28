package com.flipfit.rest;

import com.flipfit.bean.GymCentre;
import com.flipfit.bean.Slot;
import com.flipfit.business.GymOwnerService;
import com.flipfit.business.GymOwnerServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/gym-owner")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GymOwnerResource {

    private final GymOwnerService gymOwnerService = new GymOwnerServiceImpl();

    @POST
    @Path("/register-centre")
    public Response registerCentre(@QueryParam("ownerId") String ownerId, GymCentre centre) {
        // Validate ownerId matches the centre's ownerId
        gymOwnerService.registerCentre(centre);
        return Response.ok("Centre Registered").build();
    }

    @POST
    @Path("/add-slot")
    public Response addSlot(@QueryParam("ownerId") String ownerId, Slot slot) {
        // Validate ownerId has permission to add slot to this centre
        gymOwnerService.addSlot(slot);
        return Response.ok("Slot Added").build();
    }

    @GET
    @Path("/centres")
    public List<GymCentre> getCentres(@QueryParam("ownerId") String ownerId) {
        return gymOwnerService.getCentresByOwnerId(ownerId);
    }

    @GET
    @Path("/slots/{centreId}")
    public List<Slot> getSlots(@QueryParam("ownerId") String ownerId, @PathParam("centreId") String centreId) {
        // Validate ownerId owns this centre
        return gymOwnerService.getSlotsByCentreId(centreId);
    }

    @POST
    @Path("/create-schedule")
    public Response createSchedule(@QueryParam("ownerId") String ownerId,
            @QueryParam("slotId") String slotId,
            @QueryParam("date") String date) {
        // Validate ownerId owns the slot
        gymOwnerService.createSchedule(slotId, java.time.LocalDate.parse(date));
        return Response.ok("Schedule Created").build();
    }

    @GET
    @Path("/profile")
    public Response getProfile(@QueryParam("ownerId") String ownerId) {
        return Response.ok(gymOwnerService.getGymOwnerByUsername(ownerId)).build();
    }
}
