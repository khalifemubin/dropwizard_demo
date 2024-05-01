package com.synergym.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/hello")
public class HelloWorldResource {
    @GET
    public String get() {
        return "Hello World from Dropwizard!";
    }
}
