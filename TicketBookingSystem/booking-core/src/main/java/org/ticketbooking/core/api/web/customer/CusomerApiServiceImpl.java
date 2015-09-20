package org.ticketbooking.core.api.web.customer;

import javax.annotation.Resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.ticketbooking.common.annotation.log.Log;
import org.ticketbooking.common.utils.ApplicationObjectUtils;
import org.ticketbooking.core.api.jaxb.user.UserDetails;
import org.ticketbooking.core.domain.user.Customer;
import org.ticketbooking.core.service.customer.CustomerService;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Api(value="CustomerDetails",description="Service to get the details about Customer")
@Path("/user")
@Service("apiCustomer")
public class CusomerApiServiceImpl  extends AbstractCustomerApiService {
	
	@Log
	Logger log;
	
	@Resource(name="customerService")
	CustomerService customerService;
	
	
	@ApiOperation(httpMethod="POST",value="To create a customer")
	@POST
	@Produces(value={MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Consumes(value={MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response createCustomer(@ApiParam(name="userDetails",value="XML/JSON for creating user")UserDetails userDetails) {
		log.info("Customer is going to be created");
		performCustomerCreation(userDetails);
		return Response.status(Status.CREATED).header("X-header-message", "User created").build();
	}

	

	
	@Path("/{username}")
	@PUT
	@Produces(value={MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Consumes(value={MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response updateCustomer(@PathParam("username") String username,UserDetails details) {
		Customer customer = customerService.findCustomerByUserName(username);
		if(ApplicationObjectUtils.isNull(details.getUserName())){
			details.setUserName(username);
		}
		if(ApplicationObjectUtils.isNull(customer)){
			return createCustomer(details);
		}
		//TODO Performance Improvement . Need to pass the customer Object
		super.performCustomerUpdation(details);
		return Response.status(Status.OK).header("X-header-message", "User updated successfully").build();
	}

}
