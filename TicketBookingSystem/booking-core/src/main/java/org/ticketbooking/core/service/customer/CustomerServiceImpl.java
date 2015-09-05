package org.ticketbooking.core.service.customer;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ticketbooking.core.api.jaxb.user.UserDetails;
import org.ticketbooking.core.domain.user.Customer;

@Service("customerService")
public class CustomerServiceImpl extends AbstractCustomerService {

	
	@Transactional(value="tbsTransaction",readOnly=true)
	public Customer findCustomerById(Long id) {
		return super.findCustomerById(id);
	}
	
	@Transactional(value="tbsTransaction",readOnly=true)
	public Customer findCustomerByUserName(String username) {
		return super.findCustomerByUserName(username);
	}

	@Transactional("tbsTransaction")
	public void createCustomer(Customer customer) {
		super.createCustomer(customer);
	}
	
	
	@Transactional("tbsTransaction")
	public Customer updateCustomer(Customer customer) {
		return super.updateCustomer(customer);
	}
	
	@Transactional("tbsTransaction")
	public void deleteCustomer(Long id) {
		super.deleteCustomer(id);
	}
	
	@Transactional("tbsTransaction")
	@Override
	public Customer performCustomerCreation(UserDetails userDetails) {
		return super.performCustomerCreation(userDetails);
	}
	
}
