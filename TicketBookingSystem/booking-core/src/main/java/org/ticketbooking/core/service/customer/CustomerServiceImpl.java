package org.ticketbooking.core.service.customer;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ticketbooking.core.dao.customer.CustomerDao;
import org.ticketbooking.core.domain.user.Customer;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	@Resource(name = "customerDao")
	CustomerDao customerDao;
	
	@Transactional(value="tbsTransaction",readOnly=true)
	public Customer findCustomerById(Long id) {
		return customerDao.findCustomerById(id);
	}
	
	@Transactional(value="tbsTransaction",readOnly=true)
	public Customer findCustomerByUserName(String username) {
		return customerDao.findCustomerByUserName(username);
	}

	@Transactional("tbsTransaction")
	public void createCustomer(Customer customer) {
		customerDao.createCustomer(customer);
	}
	
	
	@Transactional("tbsTransaction")
	public Customer updateCustomer(Customer customer) {
		return customerDao.updateCustomer(customer);
	}
	
	@Transactional("tbsTransaction")
	public void deleteCustomer(Long id) {
		customerDao.deleteCustomer(id);
	}
}
