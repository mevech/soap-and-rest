package org.example.rest;

import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import java.util.stream.Collectors;

@ApplicationScoped
@Path("/hello")
@Slf4j
public class HelloResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@Context HttpHeaders headers){
        String headerString = headers.getRequestHeaders()
                .entrySet()
                .stream()
                .map(e -> e.getKey() + " = " + e.getValue())
                .collect(Collectors.joining("\n"));
        log.info("header transformed: \n{} ", headerString);
        return "hello server";
    }
}