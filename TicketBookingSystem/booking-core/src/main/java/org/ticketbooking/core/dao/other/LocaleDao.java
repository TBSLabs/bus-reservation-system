package org.ticketbooking.core.dao.other;

import org.ticketbooking.core.domain.other.Locale;

public interface LocaleDao {
	void createLocale(Locale locale);
	Locale fetchCountry(Long id);
	Locale fetchCountryByName(String name);
}
