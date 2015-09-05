package org.ticketbooking.core.domain.user;

import java.io.Serializable;

public interface Customer extends Serializable {
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
	public boolean isActive();
	public void setActive(boolean isActive);
	public boolean isVarified();
	public void setVarified(boolean isVarified);
}
