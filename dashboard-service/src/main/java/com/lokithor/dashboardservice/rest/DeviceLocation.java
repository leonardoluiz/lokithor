package com.lokithor.dashboardservice.rest;

import java.util.Properties;

import javax.inject.Inject;
import javax.json.JsonArray;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/devicelocation")
public class DeviceLocation {

	@Inject
	private Properties properties;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response doGet() {

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(properties.getProperty("geotracking-service-url")).path("record/current");
		Response response = target.request(MediaType.APPLICATION_JSON).get();
		if (response.getStatus() == 200) {
			JsonArray json = response.readEntity(JsonArray.class);
			return Response.ok().entity(json.toString()).build();
		} else {
			return Response.serverError().build();
		}
		
	}
}