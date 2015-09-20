package org.ticketbooking.core.domain.user;

import java.io.Serializable;

public interface CustomerAdditionalDetails extends Serializable {
	Long getId();

	void setId(Long id);

	Customer getCustomer();

	void setCustomer(Customer customer);

	String getName();

	void setName(String name);

	String getValue();

	void setValue(String value);

}
