package com.sahan.jaxrsapp;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getTest() {
        return "Hello World";
    }
    
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String postTest() {
        return "Http POST request";
    }
    
    @PUT
    @Produces(MediaType.TEXT_PLAIN)
    public String putTest() {
        return "Http PUT request";
    }
    
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteTest() {
        return "Http DELETE request";
    }
}
