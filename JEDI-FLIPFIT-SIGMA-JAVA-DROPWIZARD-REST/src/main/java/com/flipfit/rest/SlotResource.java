package com.flipfit.rest;

import com.flipfit.bean.Slot;
import com.flipfit.dao.SlotDAO;
import com.flipfit.dao.SlotDAOImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/slots")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SlotResource {

    private final SlotDAO slotDAO = new SlotDAOImpl();

    @POST
    public Response addSlot(Slot slot) {
        slotDAO.addSlot(slot);
        return Response.ok("Slot Added").build();
    }

    @GET
    @Path("/{slotId}")
    public Slot getSlotById(@PathParam("slotId") String slotId) {
        return slotDAO.getSlotById(slotId);
    }

    @GET
    @Path("/centre/{centreId}")
    public List<Slot> getSlotsByCentre(@PathParam("centreId") String centreId) {
        return slotDAO.getSlotsByCentreId(centreId);
    }
}
