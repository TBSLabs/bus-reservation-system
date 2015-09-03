package org.ticketbooking.core.dao.address;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.ticketbooking.core.domain.user.AddressImpl;

@Repository("addressDao")
public class AddressDaoImpl implements AddressDao{
	
	@PersistenceContext
	EntityManager entityManager;

	public void createAddress(AddressImpl address) {
		entityManager.persist(address);
	}

	public void deleteAddress(Long id) {
		AddressImpl address = fetchAddress(id);
		entityManager.remove(address);
	}

	public AddressImpl fetchAddress(Long id) {
		return entityManager.find(AddressImpl.class, id);
	}

	/*@SuppressWarnings("unchecked")
	public List<AddressImpl> fetchAddressByCustomer(Long customerId) {
		Query query = entityManager.createNamedQuery("AddressImpl.fetchByCustomer");
		query.setParameter("id", customerId);
		return query.getResultList();
	}*/

	public void updateAddress(AddressImpl address) {
		entityManager.merge(address);
	}

}
