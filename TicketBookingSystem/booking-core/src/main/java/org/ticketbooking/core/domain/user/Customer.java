package org.ticketbooking.core.domain.user;

import java.io.Serializable;
import java.util.Map;

import org.ticketbooking.core.domain.common.audit.Auditable;


public interface Customer extends Serializable {
	Long getId();

	void setId(Long id);

	String getUsername();

	void setUsername(String username);

	String getPassword();

	void setPassword(String password);

	String getFirstName();

	void setFirstName(String firstName);

	String getLastName();

	void setLastName(String lastName);

	String getMiddleName();

	void setMiddleName(String middleName);

	String getEmail();

	void setEmail(String email);

	String getPhone();

	void setPhone(String phone);

	boolean isActive();

	void setActive(boolean isActive);

	boolean isVarified();

	void setVarified(boolean isVarified);

	Auditable getAuditable();

	void setAuditable(Auditable auditable);

	Map<String, CustomerAdditionalDetails> getCustomerAdditional();

	void setCustomerAdditional(Map<String, CustomerAdditionalDetails> customerAdditional);

}
