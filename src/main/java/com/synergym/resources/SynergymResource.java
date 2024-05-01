package com.synergym.resources;

import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import io.dropwizard.hibernate.UnitOfWork;

@Path("/books")
public class SynergymResource {
    private final SynergymEntityDAO synergymEntityDAO;

    public SynergymResource(SynergymEntityDAO synergymEntityDAO) {
        this.synergymEntityDAO = synergymEntityDAO;
    }

    @GET
    public String get() {
        return "Books!";
    }

    @POST
    @Path("/review")
    @UnitOfWork
    @Consumes(MediaType.APPLICATION_JSON)
    public String postReview(@Valid SynergymEntity synergymEntity) {
        return synergymEntityDAO.save(synergymEntity).getId();
    }

    @GET
    @Path("/review")
    @Produces(MediaType.APPLICATION_JSON)
    @UnitOfWork
    public SynergymEntity getReview(@QueryParam("bookId") String bookId) {
        return synergymEntityDAO.find(bookId);
    }

}
