package org.ticketbooking.core.workflow.context;

import java.util.Map;

import org.ticketbooking.core.workflow.dto.WorkflowDTO;


@SuppressWarnings({ "unchecked", "rawtypes" })
public class ProcessContext<T extends WorkflowDTO> implements Context {
	
	private Map<String,Object> attributes;
	private T workflowDto;
	
	public Map getAttributes() {
		return attributes;
	}
	public void setAttributes(Map attributes) {
		this.attributes=attributes;
	}
	public WorkflowDTO getWorkflowDto() {
		return workflowDto;
	}
	public void setWorkflowDto(WorkflowDTO workflowDto) {
		this.workflowDto=(T) workflowDto;
	}
	
	

}
