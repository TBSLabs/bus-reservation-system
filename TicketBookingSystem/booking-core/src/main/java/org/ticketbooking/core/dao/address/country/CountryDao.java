package org.ticketbooking.core.dao.address.country;

import org.ticketbooking.core.domain.user.Country;
import org.ticketbooking.core.domain.user.CountryImpl;

public interface CountryDao {
	void createCountry(Country country);
	CountryImpl fetchCountry(Long id);
	CountryImpl fetchCountryByName(String name);
}
