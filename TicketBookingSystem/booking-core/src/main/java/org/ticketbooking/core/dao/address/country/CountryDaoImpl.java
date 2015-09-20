package org.ticketbooking.core.dao.address.country;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.ticketbooking.common.utils.ApplicationObjectUtils;
import org.ticketbooking.core.domain.user.Country;
import org.ticketbooking.core.domain.user.CountryImpl;

@Repository("countryDao")
public class CountryDaoImpl implements CountryDao{

	@PersistenceContext
	EntityManager entityManager;
	
	public void createCountry(Country country) {
		entityManager.persist(country);
	}

	public Country fetchCountry(Long id) {
		return entityManager.find(CountryImpl.class, id);
	}

	@SuppressWarnings("unchecked")
	public Country fetchCountryByName(String name) {
		Query query = entityManager.createNamedQuery("CountryImpl.fetchByCountryName");
		query.setParameter("name", name);
		List<Country> countries = query.getResultList();
		return ApplicationObjectUtils.isNull(countries) || countries.isEmpty() ? null :countries.get(0);
	}
	
}
