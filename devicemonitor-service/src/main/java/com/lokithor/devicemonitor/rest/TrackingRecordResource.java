package com.lokithor.devicemonitor.rest;

import com.lokithor.devicemonitor.domain.TrackingRecord;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Path("/api/tracking-record")
public class TrackingRecordResource {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addRecord(TrackingRecord record) {

		try {
			record.setId(UUID.randomUUID().toString());
			System.out.println(record);
			return Response.ok(record).build();
		} catch (Exception e) {
			return Response.serverError().build();
		}

	}
}