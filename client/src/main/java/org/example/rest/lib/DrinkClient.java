package org.example.rest.lib;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/drink")
@Produces(MediaType.TEXT_PLAIN)
@RegisterRestClient
public interface DrinkClient {

    @GET
    public String drink();
}
