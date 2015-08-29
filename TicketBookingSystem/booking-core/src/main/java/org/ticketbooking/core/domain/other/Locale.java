package org.ticketbooking.core.domain.other;

import org.ticketbooking.core.domain.user.Country;
import org.ticketbooking.core.domain.user.CountryImpl;


public interface Locale {
	public Long getId();
	public void setId(Long id);
	public String getName();
	public void setName(String name);
	public String getTimeZone();
	public void setTimeZone(String timeZone);
	public Country getCountry();
	public void setCountry(CountryImpl country);
}
