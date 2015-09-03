package org.ticketbooking.core.domain.user;

import java.io.Serializable;

public interface Address extends Serializable{
	public Long getId();
	public void setId(Long id);
	public String getStreet1();
	public void setStreet1(String street1);
	public String getStree2();
	public void setStree2(String stree2);
	public Long getPin();
	public void setPin(Long pin);
	public State getState();
	public void setState(StateImpl state);
	public boolean isDefaultAddress();
	public void setDefaultAddress(boolean isDefaultAddress);
	public boolean isActiveAddress();
	public void setActiveAddress(boolean isActiveAddress);
}
