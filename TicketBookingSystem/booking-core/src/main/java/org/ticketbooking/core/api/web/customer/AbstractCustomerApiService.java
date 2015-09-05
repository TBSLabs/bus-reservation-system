package org.ticketbooking.core.api.web.customer;

import javax.annotation.Resource;

import org.ticketbooking.core.api.jaxb.user.UserDetails;
import org.ticketbooking.core.domain.user.Customer;
import org.ticketbooking.core.service.customer.CustomerService;

public abstract class AbstractCustomerApiService implements CustomerApiService {

	@Resource(name = "customerService")
	protected CustomerService customerService;

	protected Customer performCustomerCreation(UserDetails userDetails) {
		return customerService.performCustomerCreation(userDetails);
	}
}
