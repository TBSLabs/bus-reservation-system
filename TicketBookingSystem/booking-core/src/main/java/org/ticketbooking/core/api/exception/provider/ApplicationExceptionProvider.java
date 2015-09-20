package org.ticketbooking.core.api.exception.provider;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.apache.log4j.Logger;
import org.ticketbooking.common.constants.ApplicationConstants;
import org.ticketbooking.core.api.exception.ApplicationException;
import org.ticketbooking.core.api.exception.ErrorDecorator;

/**
 * <p> Provider class for {@link ApplicationException}. When ever {@link ApplicationException} or its sub-class throws by this system (not specific whose provider are present).
 * Then , the provider will activate to send the relevant message</p>
 * @author cooligc
 * */

@Provider
public class ApplicationExceptionProvider implements ExceptionMapper<ApplicationException>{
	
	Logger logger = Logger.getLogger(ApplicationExceptionProvider.class);
	


	public Response toResponse(ApplicationException exception) {
		logger.error(exception);
		ErrorDecorator decorator = new ErrorDecorator();
		decorator.setErrorCode(ApplicationConstants.ERROR_4000);
		decorator.setErrorMessage(ApplicationConstants.ERROR_4000_MSG);
		return Response.status(Status.INTERNAL_SERVER_ERROR)
				.entity(decorator)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
}
