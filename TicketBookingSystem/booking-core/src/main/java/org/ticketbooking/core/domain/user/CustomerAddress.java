package org.ticketbooking.core.domain.user;

import java.io.Serializable;

public interface CustomerAddress extends Serializable {
	public Long getId();
	public void setId(Long id);
	public String getAddressName();
	public void setAddressName(String addressName);
	public Customer getCustomer();
	public void setCustomer(Customer customer);
	public Address getAddress();
	public void setAddress(Address address);
}
