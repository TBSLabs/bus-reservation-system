package org.ticketbooking.core.api.exception.provider;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.apache.log4j.Logger;
import org.ticketbooking.common.constants.ApplicationConstants;
import org.ticketbooking.core.api.exception.ErrorDecorator;

@Provider
public class CommonExceptionProvider implements ExceptionMapper<Exception> {
	Logger logger = Logger.getLogger(CommonExceptionProvider.class);
	public Response toResponse(Exception exception) {
		logger.error(exception.getStackTrace());
		ErrorDecorator decorator = new ErrorDecorator();
		decorator.setErrorCode(ApplicationConstants.ERROR_5000);
		decorator.setErrorMessage(ApplicationConstants.ERROR_5000_MSG);
		return Response.status(Status.INTERNAL_SERVER_ERROR)
				.entity(decorator)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}

}
