package org.ticketbooking.core.service.other;

import org.ticketbooking.core.domain.other.Locale;

public interface LocaleService {
	void createLocale(Locale locale);
	Locale fetchLocale(Long id);
	Locale fetchLocaleByName(String name);
}
