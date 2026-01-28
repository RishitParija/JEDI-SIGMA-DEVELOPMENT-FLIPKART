package com.flipfit.rest;

import com.flipfit.bean.Schedule;
import com.flipfit.dao.ScheduleDAO;
import com.flipfit.dao.ScheduleDAOImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;
import java.util.List;

@Path("/schedules")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ScheduleResource {

    private final ScheduleDAO scheduleDAO = new ScheduleDAOImpl();

    @POST
    public Response addSchedule(Schedule schedule) {
        scheduleDAO.addSchedule(schedule);
        return Response.ok("Schedule Added").build();
    }

    @GET
    @Path("/{scheduleId}")
    public Schedule getScheduleById(@PathParam("scheduleId") String scheduleId) {
        return scheduleDAO.getScheduleById(scheduleId);
    }

    @GET
    @Path("/date/{date}")
    public List<Schedule> getSchedulesByDate(@PathParam("date") String date) {
        LocalDate localDate = LocalDate.parse(date);
        return scheduleDAO.getSchedulesByDate(localDate);
    }

    @PUT
    @Path("/{scheduleId}/seats")
    public Response updateSeats(@PathParam("scheduleId") String scheduleId,
            @QueryParam("seats") int seats) {
        scheduleDAO.updateScheduleSeats(scheduleId, seats);
        return Response.ok("Seats Updated").build();
    }
}
