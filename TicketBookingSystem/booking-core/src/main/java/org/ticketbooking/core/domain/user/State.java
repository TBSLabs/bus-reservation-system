package org.ticketbooking.core.domain.user;

import java.util.Set;

public interface State {
	public Long getId();
	public void setId(Long id);
	public String getName();
	public void setName(String name);
	public Country getCountry();
	public void setCountry(CountryImpl country);
	public Set<AddressImpl> getAddresses();
	public void setAddresses(Set<AddressImpl> addresses);
}
