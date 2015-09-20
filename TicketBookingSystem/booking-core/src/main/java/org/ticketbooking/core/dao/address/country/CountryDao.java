package org.ticketbooking.core.dao.address.country;

import org.ticketbooking.core.domain.user.Country;

public interface CountryDao {
	void createCountry(Country country);
	Country fetchCountry(Long id);
	Country fetchCountryByName(String name);
}
