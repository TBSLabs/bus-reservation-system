package org.ticketbooking.core.service.customer.address;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ticketbooking.core.dao.customer.address.CustomerAddressDao;
import org.ticketbooking.core.domain.user.CustomerAddress;

@Service("customerAddressService")
public class CustomerAddressServiceImpl implements CustomerAddressService{
	
	@Resource(name="customerAddressDao")
	CustomerAddressDao addressDao;
	
	@Transactional("tbsTransaction")
	public void createCustomerAddress(CustomerAddress customerAddress){
		addressDao.createCustomerAddress(customerAddress);
	}
	
}
