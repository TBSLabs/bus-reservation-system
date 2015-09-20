package org.ticketbooking.core.api.config;

import javax.ws.rs.ApplicationPath;

import org.apache.log4j.Logger;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;
import org.ticketbooking.core.api.exception.provider.ApplicationExceptionProvider;
import org.ticketbooking.core.api.exception.provider.CommonExceptionProvider;
import org.ticketbooking.core.api.web.CheckBookingStatus;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;

@ApplicationPath("/api/*")
@Component
public class ApiApplicationConfig extends ResourceConfig {
	private static final Logger LOGGER = Logger.getLogger(ApiApplicationConfig.class);
	
	public ApiApplicationConfig() {
		LOGGER.info("Api going to start");
		packages("org.ticketbooking.core.api.web");
		register(JacksonJaxbJsonProvider.class);
		registerClasses(CheckBookingStatus.class,ApplicationExceptionProvider.class,CommonExceptionProvider.class);
		LOGGER.info("Api started");
	}

}
