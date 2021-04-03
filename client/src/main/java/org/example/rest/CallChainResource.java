package org.example.rest;

import io.vertx.core.json.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.example.rest.lib.CallChainClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("/chain")
@Slf4j
public class CallChainResource {

    @ConfigProperty(name= "version")
    String version;

    @Inject
    @RestClient
    CallChainClient callChainClient;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response drink(@Context HttpHeaders headers){
        JsonObject headerObject = new JsonObject();
        headers.getRequestHeaders()
                .forEach(headerObject::put);
        log.info("header transformed: \n{} ", headerObject.encodePrettily());
        String serverResponse = callChainClient.chain();
        JsonObject responseObject = new JsonObject();
        responseObject.put("version", version);
        responseObject.put("caller", headerObject);
        responseObject.put("server-response", serverResponse);
        return Response.ok(responseObject).build();
    }
}
