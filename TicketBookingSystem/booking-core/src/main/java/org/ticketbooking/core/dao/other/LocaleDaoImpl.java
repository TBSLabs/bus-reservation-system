package org.ticketbooking.core.dao.other;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.ticketbooking.common.utils.ApplicationObjectUtils;
import org.ticketbooking.core.domain.other.Locale;
import org.ticketbooking.core.domain.other.LocaleImpl;

@Repository("localeDao")
public class LocaleDaoImpl implements LocaleDao{

	@PersistenceContext
	EntityManager entityManager;
	
	public void createLocale(Locale locale) {
		entityManager.persist(locale);
	}

	public Locale fetchCountry(Long id) {
		return entityManager.find(LocaleImpl.class, id);
	}

	@SuppressWarnings("unchecked")
	public Locale fetchCountryByName(String name) {
		Query query = entityManager.createNamedQuery("LocaleImpl.fetchByLocaleName");
		query.setParameter("localeName", name);
		List<Locale> locales = query.getResultList();
		return ApplicationObjectUtils.isNull(locales) || locales.isEmpty() ? null : locales.get(0);
	}
	
}
