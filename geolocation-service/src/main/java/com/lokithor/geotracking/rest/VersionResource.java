package com.lokithor.geotracking.rest;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/version")
public class VersionResource {

    private class Version {
        public String version = "v 0.0.1";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response about() {
        return Response.ok(new Version()).build();
    }

}
