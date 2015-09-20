package org.ticketbooking.core.service.address.country;

import org.ticketbooking.core.domain.user.Country;

public interface CountryService {
	void createCountry(Country country);
	Country fetchCountry(Long id);
	Country fetchCountryByName(String name);
}
