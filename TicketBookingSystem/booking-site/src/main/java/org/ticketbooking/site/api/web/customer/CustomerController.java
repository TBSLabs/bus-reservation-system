package org.ticketbooking.site.api.web.customer;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.ticketbooking.core.api.jaxb.user.Address;
import org.ticketbooking.core.api.jaxb.user.UserDetails;
import org.ticketbooking.core.domain.user.Customer;
import org.ticketbooking.core.helper.AddressHelper;
import org.ticketbooking.core.helper.LinksHelper;
import org.ticketbooking.core.service.customer.CustomerService;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Api(value="CustomerDetails",description="Service to get the details about Customer")
@RestController
@RequestMapping("/user")
public class CustomerController {

	@Resource(name="customerService")
	CustomerService customerService;
	

	@Resource(name="addressHelper")
	AddressHelper addressHelper;
	
	@ApiOperation(httpMethod="GET",responseClass="UserDetails",value="will retrive all the details about the customer based on the username provided")
	@RequestMapping(value="/{username}",produces={"application/json","application/xml"},method=RequestMethod.GET)
	public UserDetails getUserDetails(@ApiParam(name="username",value="Username of the customer",required=true)@PathVariable("username") String username){
		UserDetails userDetails = new UserDetails();
		Customer customer = customerService.findCustomerByUserName(username);
		List<Address> addresses = new ArrayList<Address>();
		//TODO To Implement Address with Customer
		/*for (org.ticketbooking.core.domain.user.Address address : customer.getAddresses()) {
			addresses.add(addressHelper.convertAddress(address));
		}*/
		userDetails.setAddresses(addresses);
		userDetails.setEmail(customer.getEmail());
		userDetails.setFirstName(customer.getFirstName());
		userDetails.setLastName(customer.getLastName());
		userDetails.setMiddleName(customer.getMiddleName());
		userDetails.setUserName(customer.getUsername());
		userDetails.setPhone(customer.getPhone());
		userDetails.setLinks(LinksHelper.createUserLinks(customer.getUsername()));
		return userDetails;
	}
	
	/*@RequestMapping(produces="{application/json,application/xml}",consumes="{application/json,application/xml}",method=RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.CREATED)
	public UserDetails getUserDetails(UserDetails userDetails,HttpServletResponse httpServletResponse){
		Customer customer = new CustomerImpl();
		customer.setUsername(userDetails.getUserName());
		customer.setFirstName(userDetails.getFirstName());
		customer.setLastName(userDetails.getLastName());
		customer.setMiddleName(userDetails.getMiddleName());
		customer.setEmail(userDetails.getEmail());
		customer.setPhone(userDetails.getPhone());
		customer.setPassword(userDetails.getPassword());
		customer.setAddresses(AddressHelper.convertAddressEntity(userDetails.getAddresses()));
		customer.setUsername(userDetails.getUserName());
		customer.setUsername(userDetails.getUserName());
		customerService.createCustomer(customer);
		
		httpServletResponse.setHeader("message", "Customer Created");
		return userDetails;
	}*/
}
