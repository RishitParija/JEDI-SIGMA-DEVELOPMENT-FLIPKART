package com.flipfit.rest;

import com.flipfit.bean.Payment;
import com.flipfit.dao.PaymentDAO;
import com.flipfit.dao.PaymentDAOImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/payments")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PaymentResource {

    private final PaymentDAO paymentDAO = new PaymentDAOImpl();

    @POST
    public Response addPayment(Payment payment) {
        paymentDAO.addPayment(payment);
        return Response.ok("Payment Recorded").build();
    }
}
