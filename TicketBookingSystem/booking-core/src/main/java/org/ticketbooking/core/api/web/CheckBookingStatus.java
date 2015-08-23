package org.ticketbooking.core.api.web;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;

@Path("/booking")
public class CheckBookingStatus {
	
	private final static Logger LOGGER = Logger.getLogger(CheckBookingStatus.class);
	
	@GET
	public Response checkBooking(){
		LOGGER.info("CheckBookingStatus - started");
		return Response.status(Status.ACCEPTED)
				.entity("App is up")
				.build();
	}
}
