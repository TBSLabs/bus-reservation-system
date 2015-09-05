package org.ticketbooking.core.workflow.dto.customer;

import org.ticketbooking.core.domain.user.Customer;
import org.ticketbooking.core.workflow.dto.WorkflowDTO;

public class CustomerWorkflowDTO extends WorkflowDTO {
	private Customer customer;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
