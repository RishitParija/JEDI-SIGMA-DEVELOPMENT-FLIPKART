package com.flipfit.rest;

import com.flipfit.bean.GymCentre;
import com.flipfit.bean.GymOwner;
import com.flipfit.business.AdminService;
import com.flipfit.business.AdminServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/admin")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AdminResource {

    private final AdminService adminService = new AdminServiceImpl();

    @GET
    @Path("/pending-owners")
    public List<GymOwner> getPendingOwners() {
        return adminService.getPendingGymOwners();
    }

    @POST
    @Path("/approve-owner/{ownerId}")
    public Response approveOwner(@PathParam("ownerId") String ownerId) {
        adminService.approveGymOwner(ownerId);
        return Response.ok("Gym Owner Approved").build();
    }

    @GET
    @Path("/pending-centres")
    public List<GymCentre> getPendingCentres() {
        return adminService.getPendingGymCentres();
    }

    @POST
    @Path("/approve-centre/{centreId}")
    public Response approveCentre(@PathParam("centreId") String centreId) {
        adminService.approveGymCentre(centreId);
        return Response.ok("Gym Centre Approved").build();
    }

    @GET
    @Path("/gyms")
    public List<GymCentre> getAllGyms() {
        return adminService.getAllGymCentres();
    }

    @GET
    @Path("/owners")
    public List<GymOwner> getAllOwners() {
        return adminService.getAllGymOwners();
    }

    @GET
    @Path("/owners/status")
    public List<GymOwner> getOwnersByStatus(@QueryParam("verified") boolean verified) {
        return adminService.getAllGymOwners().stream()
                .filter(owner -> owner.getIsVerified() == verified)
                .collect(java.util.stream.Collectors.toList());
    }

    @GET
    @Path("/centres/status")
    public List<GymCentre> getCentresByStatus(@QueryParam("approved") boolean approved) {
        return adminService.getAllGymCentres().stream()
                .filter(centre -> centre.isApproved() == approved)
                .collect(java.util.stream.Collectors.toList());
    }
}
