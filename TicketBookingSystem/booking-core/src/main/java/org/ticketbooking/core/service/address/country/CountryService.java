package org.ticketbooking.core.service.address.country;

import org.ticketbooking.core.domain.user.Country;

public interface CountryService {
	void createCountry(Country country);
	void fetchCountry(Long id);
	void fetchCountryByName(String name);
}
