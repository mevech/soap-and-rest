package org.example.rest;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import java.util.stream.Collectors;

@ApplicationScoped
@Path("/drink")
@Slf4j
public class DrinkResource {

    @ConfigProperty(name= "input.drink")
    String drink;


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String drink(@Context HttpHeaders headers){
        String headerString = headers.getRequestHeaders()
                .entrySet()
                .stream()
                .map(e -> e.getKey() + " = " + e.getValue())
                .collect(Collectors.joining("\n"));
        log.info("header transformed: \n{} ", headerString);
        return drink;
    }
}
