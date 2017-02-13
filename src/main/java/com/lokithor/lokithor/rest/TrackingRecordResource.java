package com.lokithor.lokithor.rest;


import com.lokithor.lokithor.domain.TrackingRecord;
import com.lokithor.lokithor.service.TrackingRecordService;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

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