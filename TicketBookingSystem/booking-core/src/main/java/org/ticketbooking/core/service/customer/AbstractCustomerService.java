package org.ticketbooking.core.service.customer;

import java.util.Set;

import javax.annotation.Resource;

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
		return customerDao.updateCustomer(customer);
	}
	
	public void deleteCustomer(Long id) {
		customerDao.deleteCustomer(id);
	}
	
	public Customer performCustomerCreation(UserDetails userDetails){
		Customer customer = createCustomerFromPayload(userDetails);
		processCustomerWorkflow(customer);
		return customer;
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
	protected void processCustomerWorkflow(Customer customer) {
		CustomerWorkflowDTO customerWorkflowDTO = new CustomerWorkflowDTO();
		customerWorkflowDTO.setCustomer(customer);
		customerWorkflowDTO.setUserName(customer.getUsername());
		Context<WorkflowDTO> context = new ProcessContext<WorkflowDTO>();
		context.setWorkflowDto(customerWorkflowDTO);
		
		customerProcessor.doActivities(context);
	}

	
}
