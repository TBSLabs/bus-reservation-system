package org.ticketbooking.core.workflow.activity;

import org.ticketbooking.core.workflow.context.Context;
import org.ticketbooking.core.workflow.dto.WorkflowDTO;

@SuppressWarnings({"rawtypes","unchecked"})
public class Activity {
	private Context<? extends WorkflowDTO> context;
	
	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}
	
	public Context<WorkflowDTO> process(Context<WorkflowDTO> context){
		return null;
	}
}
