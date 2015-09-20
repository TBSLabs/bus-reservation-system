package org.ticketbooking.core.service.customer;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.ticketbooking.common.utils.ApplicationObjectUtils;
import org.ticketbooking.core.api.jaxb.user.UserDetails;
import org.ticketbooking.core.dao.customer.CustomerDao;
import org.ticketbooking.core.domain.user.Address;
import org.ticketbooking.core.domain.user.Customer;
import org.ticketbooking.core.helper.AddressHelper;
import org.ticketbooking.core.service.TRSEntityConfigurationService;
import org.ticketbooking.core.workflow.context.Context;
import org.ticketbooking.core.workflow.context.ProcessContext;
import org.ticketbooking.core.workflow.dto.WorkflowDTO;
import org.ticketbooking.core.workflow.dto.customer.CustomerWorkflowDTO;
import org.ticketbooking.core.workflow.processor.Processor;

public abstract class AbstractCustomerService implements CustomerService{
	
	@Resource(name = "customerDao")
	protected CustomerDao customerDao;
	
	@Resource(name="addressHelper")
	protected AddressHelper addressHelper;
	
	@Resource(name="trsEntityConfigurationService")
	protected TRSEntityConfigurationService configuration;
	
	@Resource(name="customerWorkflow")
	protected Processor customerProcessor;
	
	
	public Customer findCustomerById(Long id) {
		return customerDao.findCustomerById(id);
	}
	
	public Customer findCustomerByUserName(String username) {
		return customerDao.findCustomerByUserName(username);
	}

	public void createCustomer(Customer customer) {
		customerDao.createCustomer(customer);
	}
	
	
	public Customer updateCustomer(Customer customer) {
		Customer updatedCustomer = customerDao.updateCustomer(customer);
		//TODO Update workflow to be included
//		processCustomerUpdateWorkflow(updatedCustomer);
		return updatedCustomer;
	}
	

	public void deleteCustomer(Long id) {
		customerDao.deleteCustomer(id);
	}
	
	public Customer performCustomerCreation(UserDetails userDetails){
		Customer customer = createCustomerFromPayload(userDetails);
		processCustomerCreateWorkflow(customer);
		return customer;
	}
	
	public Customer performCustomerUpdation(UserDetails details) {
		Customer customer = findCustomerByUserName(details.getUserName());
		if(ApplicationObjectUtils.isNotNull(details.getPassword()) && !customer.getPassword().equalsIgnoreCase(details.getPassword())){
			customer.setPassword(details.getPassword());
		}
		if(ApplicationObjectUtils.isNotNull(details.getEmail()) && !customer.getEmail().equalsIgnoreCase(details.getEmail())){
			customer.setEmail(details.getEmail());
		}
		if(ApplicationObjectUtils.isNotNull(details.getFirstName()) && !customer.getFirstName().equalsIgnoreCase(details.getFirstName())){
			customer.setFirstName(details.getFirstName());
		}
		if(ApplicationObjectUtils.isNotNull(details.getLastName()) && !customer.getLastName().equalsIgnoreCase(details.getLastName())){
			customer.setLastName(details.getLastName());
		}
		if(ApplicationObjectUtils.isNotNull(details.getMiddleName()) && !customer.getMiddleName().endsWith(details.getMiddleName())){
			customer.setMiddleName(details.getMiddleName());
		}
		return updateCustomer(customer);
	}
	protected Customer createCustomerFromPayload(UserDetails userDetails) {
		Customer customer = configuration.createObjectByBeanId("org.ticketbooking.core.domain.user.Customer");
		customer.setUsername(userDetails.getUserName());
		customer.setFirstName(userDetails.getFirstName());
		customer.setLastName(userDetails.getLastName());
		customer.setMiddleName(userDetails.getMiddleName());
		customer.setEmail(userDetails.getEmail());
		customer.setPhone(userDetails.getPhone());
		customer.setPassword(userDetails.getPassword());
		customer.setUsername(userDetails.getUserName());
		createCustomer(customer);
		Set<Address> address = addressHelper.convertAddressEntity(userDetails.getAddresses());
		//TODO Logic to be changed
		addressHelper.createCustomerAddress(customer,address.iterator().next());
		return customer;
	}
	
	@SuppressWarnings("unchecked")
	protected void processCustomerCreateWorkflow(Customer customer) {
		CustomerWorkflowDTO customerWorkflowDTO = new CustomerWorkflowDTO();
		customerWorkflowDTO.setCustomer(customer);
		customerWorkflowDTO.setUserName(customer.getUsername());
		Context<WorkflowDTO> context = new ProcessContext<WorkflowDTO>();
		context.setWorkflowDto(customerWorkflowDTO);
		customerProcessor.doActivities(context);
	}
	
	@SuppressWarnings({ "unchecked", "unused" })
	private void processCustomerUpdateWorkflow(Customer updatedCustomer) {
		CustomerWorkflowDTO customerWorkflowDTO = new CustomerWorkflowDTO();
		customerWorkflowDTO.setCustomer(updatedCustomer);
		customerWorkflowDTO.setUserName(updatedCustomer.getUsername());
		Context<WorkflowDTO> context = new ProcessContext<WorkflowDTO>();
		context.setWorkflowDto(customerWorkflowDTO);
		Map<String,Object> attributes = new HashMap<String, Object>();
		attributes.put("isUpdate", Boolean.TRUE);
		context.setAttributes(attributes);
		customerProcessor.doActivities(context);
	}

	
}
