package com.lokithor.geotracking.rest;


import com.lokithor.geotracking.domain.TrackingRecord;
import com.lokithor.geotracking.service.TrackingRecordService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/record")
public class TrackingRecordResource {

    @Inject
    private TrackingRecordService trackingRecordService;

    @GET
    @Produces("text/plain")
    public Response doGet() {
        trackingRecordService.push(new TrackingRecord());
        return Response.ok("TrackingRecord").build();

    }
}