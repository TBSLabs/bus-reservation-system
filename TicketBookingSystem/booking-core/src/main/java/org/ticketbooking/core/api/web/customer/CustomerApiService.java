package org.ticketbooking.core.api.web.customer;

import javax.ws.rs.core.Response;

import org.ticketbooking.core.api.jaxb.user.UserDetails;

public interface CustomerApiService {
	Response createCustomer(UserDetails details);
	Response updateCustomer(String username,UserDetails details);
}
