package com.lokithor.dashboardservice.rest;

import java.util.ArrayList;
import java.util.Properties;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.logging.Logger;
import org.wildfly.swarm.spi.runtime.annotations.ConfigurationValue;

@Path("/devicelocation")
public class DeviceLocation {
	
	private static final Logger LOG = Logger.getLogger(DeviceLocation.class);

	@Inject
	@ConfigurationValue("geolocation.service.url")
	private String geolocationUrl;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response doGet() {
		
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(geolocationUrl).path("records/current");
		Response response = target.request(MediaType.APPLICATION_JSON).get();
		if (response.getStatus() == 200) {
			ArrayList<?> json = response.readEntity(ArrayList.class);
			return Response.ok().entity(json).build();
		} else {
			return Response.serverError().build();
		}
		
	}
}
