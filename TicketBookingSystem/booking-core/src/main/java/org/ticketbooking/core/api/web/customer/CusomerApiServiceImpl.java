package org.ticketbooking.core.api.web.customer;

import javax.annotation.Resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.stereotype.Service;
import org.ticketbooking.core.api.jaxb.user.UserDetails;
import org.ticketbooking.core.domain.user.Customer;
import org.ticketbooking.core.domain.user.CustomerImpl;
import org.ticketbooking.core.helper.AddressHelper;
import org.ticketbooking.core.service.customer.CustomerService;

@Path("/user")
@Service("apiCustomer")
public class CusomerApiServiceImpl implements CustomerApiService{
	
	@Resource(name="customerService")
	CustomerService customerService;
	
	@Resource(name="addressHelper")
	AddressHelper addressHelper;
	
	@POST
	@Produces(value={MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Consumes(value={MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response createCustomer(UserDetails userDetails) {

		Customer customer = new CustomerImpl();
		customer.setUsername(userDetails.getUserName());
		customer.setFirstName(userDetails.getFirstName());
		customer.setLastName(userDetails.getLastName());
		customer.setMiddleName(userDetails.getMiddleName());
		customer.setEmail(userDetails.getEmail());
		customer.setPhone(userDetails.getPhone());
		customer.setPassword(userDetails.getPassword());
		customer.setAddresses(addressHelper.convertAddressEntity(userDetails.getAddresses()));
		customer.setUsername(userDetails.getUserName());
		customer.setUsername(userDetails.getUserName());
		customerService.createCustomer(customer);
		
		return Response.status(Status.CREATED).header("X-header-message", "User created").build();
	}

	@Path("/{username}")
	@PUT
	@Produces(value={MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Consumes(value={MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response updateCustomer(UserDetails details) {
		return null;
	}

}
