package org.ticketbooking.core.api.config;

import org.apache.log4j.Logger;
import org.glassfish.jersey.server.ResourceConfig;
import org.ticketbooking.core.api.web.CheckBookingStatus;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;

//@ApplicationPath("/api/*")
public class ApiApplicationConfig extends ResourceConfig {
	private final static Logger LOGGER = Logger.getLogger(ApiApplicationConfig.class);

	public ApiApplicationConfig() {
		LOGGER.info("Api going to start");
		packages("org.ticketbooking.core.api.web");
		register(JacksonJaxbJsonProvider.class);
		registerClasses(CheckBookingStatus.class);
		LOGGER.info("Api started");
	}

}
