package org.ticketbooking.core.helper;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.ticketbooking.core.api.jaxb.user.Address;
import org.ticketbooking.core.domain.other.LocaleImpl;
import org.ticketbooking.core.domain.user.Country;
import org.ticketbooking.core.domain.user.Customer;
import org.ticketbooking.core.domain.user.CustomerAddress;
import org.ticketbooking.core.domain.user.State;
import org.ticketbooking.core.service.TRSEntityConfigurationService;
import org.ticketbooking.core.service.address.AddressService;
import org.ticketbooking.core.service.address.country.CountryService;
import org.ticketbooking.core.service.address.state.StateService;
import org.ticketbooking.core.service.customer.CustomerService;
import org.ticketbooking.core.service.customer.address.CustomerAddressService;

@Component("addressHelper")
public class AddressHelper {
	
	@Resource(name="addressService")
	AddressService addressService;
	
	@Resource(name="stateService")
	StateService stateService;
	
	@Resource(name="countryService")
	CountryService countryService;

	@Resource(name="customerAddressService")
	CustomerAddressService customerAddressService;
	
	@Resource(name="customerService")
	CustomerService customerService;
	
	@Resource(name="trsEntityConfigurationService")
	TRSEntityConfigurationService configurationService;
	
	public Address convertAddress(org.ticketbooking.core.domain.user.Address address){
		Address convertedAddress = new Address();
		convertedAddress.setCountry(address.getState().getCountry().getName());
		convertedAddress.setPin(address.getPin());
		convertedAddress.setState(address.getState().getName());
		convertedAddress.setStreet1(address.getStreet1());
		convertedAddress.setStreet2(address.getStree2());
		return convertedAddress;
	}

	public Set<org.ticketbooking.core.domain.user.Address> convertAddressEntity(List<Address> addresses) {
		Set<org.ticketbooking.core.domain.user.Address> addresses2 = new HashSet<org.ticketbooking.core.domain.user.Address>();
		for (Address address : addresses) {
			org.ticketbooking.core.domain.user.Address address2 = configurationService.createObjectByBeanId("org.ticketbooking.core.domain.user.Address");
			address2.setPin(address.getPin());
			address2.setStreet1(address.getStreet1());
			address2.setStree2(address.getStreet2());
			
			Country country = configurationService.createObjectByBeanId("org.ticketbooking.core.domain.user.Country");
			country.setName(address.getCountry());
			LocaleImpl locale = new LocaleImpl();
			locale.setName("en-IN");
			locale.setTimeZone("-05:30");
			country.setLocale(locale);
			countryService.createCountry(country);
			
			State state = configurationService.createObjectByBeanId("org.ticketbooking.core.domain.user.State");
			state.setName(address.getState());
			state.setCountry(country);
			stateService.createState(state);
			address2.setState(state);
			addressService.createAddress(address2);
			addresses2.add(address2);
		}
		
		return addresses2;
	}
	
	@Transactional("tbsTransaction")
	public void createCustomerAddress(Customer customer,org.ticketbooking.core.domain.user.Address address){
		CustomerAddress customerAddress = configurationService.createObjectByBeanId("org.ticketbooking.core.domain.user.CustomerAddress");
		customerAddress.setCustomer(customerService.findCustomerById(customer.getId()));
		customerAddress.setAddress(addressService.fetchAddress(address.getId()));
		customerAddress.setAddressName("Address created for customer");
		customerAddressService.createCustomerAddress(customerAddress);
	}
}
