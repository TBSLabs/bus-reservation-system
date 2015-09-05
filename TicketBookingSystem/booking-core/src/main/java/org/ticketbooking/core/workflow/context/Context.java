package org.ticketbooking.core.workflow.context;

import java.util.Map;

import org.ticketbooking.core.workflow.dto.WorkflowDTO;

public interface Context<T extends WorkflowDTO> {
	Map<String,Object> getAttributes();
	void setAttributes(Map<String,Object> attributes);
	public T getWorkflowDto();
	public void setWorkflowDto(T workflowDto);
}
