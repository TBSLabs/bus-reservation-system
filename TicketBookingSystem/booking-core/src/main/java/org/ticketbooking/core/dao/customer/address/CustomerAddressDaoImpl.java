package org.ticketbooking.core.dao.customer.address;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.ticketbooking.core.domain.user.CustomerAddressImpl;

@Repository("customerAddressDao")
public class CustomerAddressDaoImpl implements CustomerAddressDao{
	
	@PersistenceContext
	EntityManager entityManager;
	
	public void createCustomerAddress(CustomerAddressImpl customerAddress){
		entityManager.persist(customerAddress);
	}
}
