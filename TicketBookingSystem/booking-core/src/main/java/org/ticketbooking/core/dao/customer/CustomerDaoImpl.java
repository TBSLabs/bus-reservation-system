package org.ticketbooking.core.dao.customer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.ticketbooking.core.domain.user.Customer;
import org.ticketbooking.core.domain.user.CustomerImpl;


@Repository("customerDao")
public class CustomerDaoImpl implements CustomerDao{
	
	@PersistenceContext
	EntityManager entityManager;
		
	public Customer findCustomerById(Long id){
		return entityManager.find(CustomerImpl.class, id);
	}
	
	public Customer findCustomerByUserName(String username){
		Query query = entityManager.createNamedQuery("CustomerImpl.fetchByUsername");
		query.setParameter("username", username);
		return (CustomerImpl)query.getSingleResult();
	}

	public void createCustomer(Customer customer) {
		entityManager.persist(customer);
	}

	public Customer updateCustomer(Customer customer) {
		return entityManager.merge(customer);
	}

	public void deleteCustomer(Long id) {
		Customer customer = entityManager.find(Customer.class, id);
		entityManager.remove(customer);
	}
}
