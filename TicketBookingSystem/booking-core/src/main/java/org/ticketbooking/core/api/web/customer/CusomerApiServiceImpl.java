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
import org.ticketbooking.core.service.customer.CustomerService;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Api(value="CustomerDetails",description="Service to get the details about Customer")
@Path("/user")
@Service("apiCustomer")
public class CusomerApiServiceImpl  extends AbstractCustomerApiService {
	
	@Resource(name="customerService")
	CustomerService customerService;
	
	
	@ApiOperation(httpMethod="POST",value="To create a customer")
	@POST
	@Produces(value={MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Consumes(value={MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response createCustomer(@ApiParam(name="userDetails",value="XML/JSON for creating user")UserDetails userDetails) {
		performCustomerCreation(userDetails);
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
