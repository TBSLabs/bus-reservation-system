package org.ticketbooking.core.dao.customer;

import org.ticketbooking.core.domain.user.Customer;

public interface CustomerDao {
	Customer findCustomerById(Long id);
	Customer findCustomerByUserName(String username);
	void createCustomer(Customer customer);
	Customer updateCustomer(Customer customer);
	void deleteCustomer(Long id);
}
