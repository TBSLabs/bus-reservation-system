package org.ticketbooking.core.dao.address.country;

import org.ticketbooking.core.domain.user.CountryImpl;

public interface CountryDao {
	void createCountry(CountryImpl country);
	CountryImpl fetchCountry(Long id);
	CountryImpl fetchCountryByName(String name);
}
