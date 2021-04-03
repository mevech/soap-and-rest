package org.example.rest;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.example.rest.lib.DrinkClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.stream.Collectors;

@ApplicationScoped
@Path("/menu")
@Slf4j
public class MenuResource {
    @ConfigProperty(name= "input.menu")
    String menu;

    @Inject
    @RestClient
    DrinkClient drinkClient;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String menu(@Context HttpHeaders headers){
        String headerString = headers.getRequestHeaders()
                .entrySet()
                .stream()
                .map(e -> e.getKey() + " = " + e.getValue())
                .collect(Collectors.joining("\n"));
        log.info("header transformed: \n{} ", headerString);
        String responseBody = menu + " serves " + drinkClient.drink();
        return responseBody;
    }
}
