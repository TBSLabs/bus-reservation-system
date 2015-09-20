package org.ticketbooking.core.service.customer;

import org.ticketbooking.core.api.jaxb.user.UserDetails;
import org.ticketbooking.core.domain.user.Customer;

public interface CustomerService {
	void createCustomer(Customer customer);
	Customer updateCustomer(Customer customer);
	void deleteCustomer(Long id);
	Customer findCustomerById(Long id);
	Customer findCustomerByUserName(String username);
	Customer performCustomerCreation(UserDetails userDetails);
	Customer performCustomerUpdation(UserDetails details);
}
