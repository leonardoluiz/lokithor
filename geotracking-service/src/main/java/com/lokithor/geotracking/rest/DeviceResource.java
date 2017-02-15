package com.lokithor.geotracking.rest;


import com.google.gson.Gson;
import com.lokithor.geotracking.domain.Device;
import com.lokithor.geotracking.domain.TrackingRecord;
import com.lokithor.geotracking.domain.TrackingRecordDTO;
import com.lokithor.geotracking.service.DeviceService;
import com.lokithor.geotracking.service.ServiceException;
import com.lokithor.geotracking.service.TrackingRecordService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/device")
public class DeviceResource {

	@Inject
	private DeviceService deviceService;

	@GET
	public Response get() {
		try {
			List<Device> devices = deviceService.findAll();
			if (devices.isEmpty()) {
				return Response.noContent().build();
			} else {
				return Response.ok(new Gson().toJson(devices)).build();
			}
		} catch (Exception e) {
			return Response.serverError().build();
		}
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response post(Device device) {
		try {
			return Response.ok(deviceService.create(device)).build();
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