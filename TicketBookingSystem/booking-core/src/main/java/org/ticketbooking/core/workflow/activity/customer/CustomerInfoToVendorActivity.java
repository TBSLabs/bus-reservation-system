package org.ticketbooking.core.workflow.activity.customer;

import org.ticketbooking.core.workflow.activity.Activity;
import org.ticketbooking.core.workflow.context.Context;
import org.ticketbooking.core.workflow.dto.WorkflowDTO;
import org.ticketbooking.core.workflow.dto.customer.CustomerWorkflowDTO;

public class CustomerInfoToVendorActivity extends Activity{
	
	@Override
	public Context<WorkflowDTO> process(Context<WorkflowDTO> context) {
		CustomerWorkflowDTO customerWorkflowDTO = (CustomerWorkflowDTO) context.getWorkflowDto();
		System.out.println("Customer Info Activity Added "+customerWorkflowDTO);
		context.setWorkflowDto(customerWorkflowDTO);
		return context;
	}
}
