package com.flipfit.rest;

import com.flipfit.bean.GymCustomer;
import com.flipfit.bean.GymOwner;
import com.flipfit.business.AdminService;
import com.flipfit.business.AdminServiceImpl;
import com.flipfit.business.GymCustomerService;
import com.flipfit.business.GymCustomerServiceImpl;
import com.flipfit.business.GymOwnerService;
import com.flipfit.business.GymOwnerServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    private final GymCustomerServiceImpl customerService = new GymCustomerServiceImpl();
    private final GymOwnerServiceImpl ownerService = new GymOwnerServiceImpl();
    private final AdminServiceImpl adminService = new AdminServiceImpl();

    @POST
    @Path("/login")
    public Response login(@QueryParam("username") String username,
            @QueryParam("password") String password,
            @QueryParam("role") String role) {

        boolean isValid = false;
        if (role.equalsIgnoreCase("Admin")) {
            isValid = adminService.validateLogin(username, password);
        } else if (role.equalsIgnoreCase("Customer")) {
            isValid = customerService.validateCustomer(username, password);
        } else if (role.equalsIgnoreCase("GymOwner")) {
            isValid = ownerService.validateLogin(username, password);
        }

        if (isValid) {
            return Response.ok("Login Successful").build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).entity("Invalid Credentials").build();
        }
    }

    @POST
    @Path("/register-customer")
    public Response registerCustomer(GymCustomer customer) {
        customerService.registerCustomer(customer);
        return Response.ok("Customer Registered Successfully").build();
    }

    @POST
    @Path("/register-owner")
    public Response registerOwner(GymOwner owner) {
        ownerService.registerGymOwner(owner);
        return Response.ok("Gym Owner Registered Successfully").build();
    }
}
