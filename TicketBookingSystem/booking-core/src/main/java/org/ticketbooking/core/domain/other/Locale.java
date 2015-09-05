package org.ticketbooking.core.domain.other;

import java.io.Serializable;

import org.ticketbooking.core.domain.user.Country;


public interface Locale extends Serializable{
	public Long getId();
	public void setId(Long id);
	public String getName();
	public void setName(String name);
	public String getTimeZone();
	public void setTimeZone(String timeZone);
	public Country getCountry();
	public void setCountry(Country country);
}
