package com.lokithor.geotracking.rest;


import com.google.gson.Gson;
import com.lokithor.geotracking.domain.TrackingRecord;
import com.lokithor.geotracking.domain.TrackingRecordDTO;
import com.lokithor.geotracking.service.ServiceException;
import com.lokithor.geotracking.service.TrackingRecordService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/record")
public class TrackingRecordResource {

	@Inject
	private TrackingRecordService trackingRecordService;

	@GET
	@Path("{device}")
	public Response get(@PathParam("device") String deviceId) {
		try {
			TrackingRecordDTO records = trackingRecordService.getLastRecords(deviceId);
			if (records == null) {
				return Response.noContent().build();
			} else {
				return Response.ok(new Gson().toJson(records)).build();
			}
		} catch (Exception e) {
			return Response.serverError().build();
		}
	}

	@GET
	@Path("current")
	public Response getCurrent() {
		try {
			List<TrackingRecord> records = trackingRecordService.getActiveDeviceRecords();
			if (records == null) {
				return Response.noContent().build();
			} else {
				return Response.ok(new Gson().toJson(records)).build();
			}
		} catch (Exception e) {
			return Response.serverError().build();
		}
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response post(TrackingRecord trackingRecord) {
		try {
			return Response.ok(trackingRecordService.push(trackingRecord.getDeviceId(),trackingRecord)).build();
		} catch (ServiceException e) {
			return Response
					.serverError()
					.entity(new ErrorMessage(e.getMessage())).build();
		} catch (Exception e) {
			return Response
					.serverError().build();
		}

	}
}