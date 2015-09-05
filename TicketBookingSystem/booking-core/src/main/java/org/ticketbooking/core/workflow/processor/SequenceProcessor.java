package org.ticketbooking.core.workflow.processor;

import java.util.List;

import org.ticketbooking.core.workflow.activity.Activity;
import org.ticketbooking.core.workflow.context.Context;
import org.ticketbooking.core.workflow.dto.WorkflowDTO;

public class SequenceProcessor implements Processor{
	private List<? extends Activity> activities;

	public List<? extends Activity> getActivities() {
		return activities;
	}

	public void setActivities(List<? extends Activity> activities) {
		this.activities = activities;
	}

	public void doActivities(Context<WorkflowDTO> context) {
		for (Activity activity : activities) {
			activity.process(context);
		}
	}
	
	
}
