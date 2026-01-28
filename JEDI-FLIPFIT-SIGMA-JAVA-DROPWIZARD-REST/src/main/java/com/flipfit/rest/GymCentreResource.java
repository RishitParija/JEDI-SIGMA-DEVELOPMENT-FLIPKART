package com.flipfit.rest;

import com.flipfit.bean.GymCentre;
import com.flipfit.dao.GymCentreDAO;
import com.flipfit.dao.GymCentreDAOImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/gym-centres")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GymCentreResource {

    private final GymCentreDAO gymCentreDAO = new GymCentreDAOImpl();

    @POST
    public Response addGymCentre(GymCentre centre) {
        gymCentreDAO.addGymCentre(centre);
        return Response.ok("Gym Centre Added").build();
    }

    @GET
    public List<GymCentre> getAllGymCentres() {
        return gymCentreDAO.getAllGymCentres();
    }

    @GET
    @Path("/owner/{ownerId}")
    public List<GymCentre> getGymsByOwner(@PathParam("ownerId") String ownerId) {
        return gymCentreDAO.getGymsByOwnerId(ownerId);
    }

    @GET
    @Path("/city/{city}")
    public List<GymCentre> getGymsByCity(@PathParam("city") String city) {
        return gymCentreDAO.getGymsByCity(city);
    }
}
