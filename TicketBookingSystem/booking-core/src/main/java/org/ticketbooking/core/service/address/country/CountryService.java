package org.ticketbooking.core.service.address.country;

import org.ticketbooking.core.domain.user.CountryImpl;

public interface CountryService {
	void createCountry(CountryImpl country);
	void fetchCountry(Long id);
	void fetchCountryByName(String name);
}
