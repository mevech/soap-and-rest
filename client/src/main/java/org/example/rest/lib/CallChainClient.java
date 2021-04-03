package org.example.rest.lib;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/chain")
@Produces(MediaType.APPLICATION_JSON)
@RegisterRestClient
public interface CallChainClient {

    @GET
    public String chain();
}