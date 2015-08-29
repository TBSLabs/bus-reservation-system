package org.ticketbooking.site.api.core;

import javax.ws.rs.ApplicationPath;

import org.apache.log4j.Logger;
import org.glassfish.jersey.server.ResourceConfig;
import org.ticketbooking.core.api.web.CheckBookingStatus;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;

@ApplicationPath("/api/v1/*")
public class ApiApplicationConfiguration extends ResourceConfig{
	final static Logger LOGGER = Logger.getLogger(ApiApplicationConfiguration.class);
	public ApiApplicationConfiguration(){
		LOGGER.info("Going to load the packages");
		packages("org.ticketbooking.core.api.web");
		LOGGER.info("Package were Register Succeessfully");
		
		LOGGER.info("Registering thirdparty Provider");
		register(JacksonJaxbJsonProvider.class);
		LOGGER.info("Thirdparty Provider were Registered Successfully");
		
		LOGGER.info("Going to Register Classes");
		registerClasses(CheckBookingStatus.class);
		
		LOGGER.info("All Classes were register successfully");
	}
}
