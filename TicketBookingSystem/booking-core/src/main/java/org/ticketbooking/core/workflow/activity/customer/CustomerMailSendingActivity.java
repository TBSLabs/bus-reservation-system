package org.ticketbooking.core.workflow.activity.customer;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.ticketbooking.core.domain.user.Customer;
import org.ticketbooking.core.services.EmailService;
import org.ticketbooking.core.workflow.activity.Activity;
import org.ticketbooking.core.workflow.context.Context;
import org.ticketbooking.core.workflow.dto.WorkflowDTO;
import org.ticketbooking.core.workflow.dto.customer.CustomerWorkflowDTO;

public class CustomerMailSendingActivity extends Activity {
	
	@Resource(name="emailService")
	EmailService emailService;
	
    @Override
    public Context<WorkflowDTO> process(Context<WorkflowDTO> context) {
    	CustomerWorkflowDTO workflowDTO = (CustomerWorkflowDTO) context.getWorkflowDto();
    	Customer customer = workflowDTO.getCustomer();
    	Map<String,String> mailAttributes = new HashMap<String,String>();
    	mailAttributes.put("mail_to", customer.getEmail());
    	mailAttributes.put("mail_subject", "Registration Confirmation Details");
    	mailAttributes.put("mail_template", "RegistrationConfirmationMail.vm");
    	mailAttributes.put("firstname", customer.getFirstName());
    	mailAttributes.put("lastname", customer.getLastName());
    	mailAttributes.put("confirmation_link", "http://localhost:8080/user/confirmation/"+customer.getUsername());
    	emailService.sendEmail(mailAttributes);
    	context.setWorkflowDto(workflowDTO);
    	return context;
    }
}
