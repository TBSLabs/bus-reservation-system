package org.ticketbooking.core.domain.user;

import java.util.Date;
import java.util.Set;

public interface Customer {
	public Long getId();
	public void setId(Long id);
	public String getUsername();
	public void setUsername(String username);
	public String getPassword();
	public void setPassword(String password);
	public String getFirstName();
	public void setFirstName(String firstName);
	public String getLastName();
	public void setLastName(String lastName);
	public String getMiddleName();
	public void setMiddleName(String middleName);
	public String getEmail();
	public void setEmail(String email);
	public String getPhone();
	public void setPhone(String phone);
	public Date getCreatedDate();
	public void setCreatedDate(Date createdDate);
	public Date getLastUpdated();
	public void setLastUpdated(Date lastUpdated);
	public Set<AddressImpl> getAddresses();
	public void setAddresses(Set<AddressImpl> addresses);
}
