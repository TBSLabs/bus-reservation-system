package org.ticketbooking.core.domain.user;

import java.util.Date;

public interface Address {
	public Long getId();
	public void setId(Long id);
	public String getStreet1();
	public void setStreet1(String street1);
	public String getStree2();
	public void setStree2(String stree2);
	public Long getPin();
	public void setPin(Long pin);
	public Date getCreatedDate();
	public void setCreatedDate(Date createdDate);
	public Date getUpdatedDate();
	public void setUpdatedDate(Date updatedDate);
	public State getState();
	public void setState(StateImpl state);
	public Customer getCustomer();
	public void setCustomer(CustomerImpl customer);

}
