package org.ticketbooking.core.dao.address.country;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.ticketbooking.core.domain.user.Country;
import org.ticketbooking.core.domain.user.CountryImpl;

@Repository("countryDao")
public class CountryDaoImpl implements CountryDao{

	@PersistenceContext
	EntityManager entityManager;
	
	public void createCountry(Country country) {
		entityManager.persist(country);
	}

	public CountryImpl fetchCountry(Long id) {
		return entityManager.find(CountryImpl.class, id);
	}

	public CountryImpl fetchCountryByName(String name) {
		Query query = entityManager.createNamedQuery("CountryImpl.fetchByCountryName");
		query.setParameter("name", name);
		return (CountryImpl) query.getSingleResult();
	}
	
}
