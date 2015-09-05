package org.ticketbooking.core.domain.user;

import org.ticketbooking.core.domain.other.Locale;

public interface Country {
	public Long getId();
	public void setId(Long id);
	public String getName();
	public void setName(String name);
	public Locale getLocale();
	public void setLocale(Locale locale);
	public State getState();
	public void setState(State state);
}
