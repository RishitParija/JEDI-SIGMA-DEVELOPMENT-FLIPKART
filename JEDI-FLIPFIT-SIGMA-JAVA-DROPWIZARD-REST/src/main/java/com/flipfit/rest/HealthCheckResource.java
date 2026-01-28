package com.flipfit.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class HealthCheckResource {

    @GET
    public String getStatus() {
        return "{\"status\": \"FlipFit Server is running\"}";
    }
}
