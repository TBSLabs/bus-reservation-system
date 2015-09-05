package org.ticketbooking.core.workflow.processor;

import org.ticketbooking.core.workflow.context.Context;
import org.ticketbooking.core.workflow.dto.WorkflowDTO;

public interface Processor {
    void doActivities(Context<WorkflowDTO> context);
}
