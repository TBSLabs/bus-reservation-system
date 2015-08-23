package org.ticketbooking.site.api.web;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;

@Path("/test")
public class ValidateTicketService {
	private final static Logger LOGGER = Logger.getLogger(ValidateTicketService.class);
	
	public Response checkStatus(){
		LOGGER.info("Service called");
		return Response.status(Status.ACCEPTED)
				.entity("Accepted")
				.build();
	}
}
