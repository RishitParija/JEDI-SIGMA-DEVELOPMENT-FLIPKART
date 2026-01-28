package com.flipkart.rest;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
@Path("/Hello")
public class HelloController {
    @GET
    @Path("/fetch")
    public String helloworld(){
        return "Hello, this is Rishit!!!";
    }

}
