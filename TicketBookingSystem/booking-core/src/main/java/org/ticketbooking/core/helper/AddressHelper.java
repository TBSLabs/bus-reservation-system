package org.ticketbooking.core.helper;

import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.ticketbooking.common.concurrency.context.TicketBookingContext;
import org.ticketbooking.common.utils.ApplicationObjectUtils;
import org.ticketbooking.core.api.jaxb.user.Address;
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
import org.ticketbooking.core.service.other.LocaleService;

/**
 * <p> This class will take care about the address conversion from the request payload as well as will create the address and its dependent object</p>
 * @author cooligc
 * */
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
	
	@Resource(name="localeService")
	LocaleService localeService;
	
	@Resource(name="trsEntityConfigurationService")
	TRSEntityConfigurationService configurationService;
	
	/**
	 * <p> This method will convert the {@link Address} to {@link org.ticketbooking.core.domain.user.Address} 
	 * which is nothing but will convert the request payload to the domain object</p>
	 * @param address type of {@link Address} which is the request payload
	 * @return {@link org.ticketbooking.core.domain.user.Address}
	 * */
	public Address convertAddress(org.ticketbooking.core.domain.user.Address address){
		Address convertedAddress = new Address();
		convertedAddress.setCountry(address.getState().getCountry().getName());
		convertedAddress.setPin(address.getPin());
		convertedAddress.setState(address.getState().getName());
		convertedAddress.setStreet1(address.getStreet1());
		convertedAddress.setStreet2(address.getStree2());
		return convertedAddress;
	}

	/**
	 * <p> This method will be responsible to create the address object for the user</p?
	 * @param addresses type of List of {@link Address} 
	 * @return set of {@link org.ticketbooking.core.domain.user.Address}
	 * */
	public Set<org.ticketbooking.core.domain.user.Address> convertAddressEntity(List<Address> addresses) {
		Set<org.ticketbooking.core.domain.user.Address> addresses2 = new HashSet<org.ticketbooking.core.domain.user.Address>();
		for (Address address : addresses) {
			org.ticketbooking.core.domain.user.Address address2 = configurationService.createObjectByBeanId("org.ticketbooking.core.domain.user.Address");
			address2.setPin(address.getPin());
			address2.setStreet1(address.getStreet1());
			address2.setStree2(address.getStreet2());			
			Country country = createCountry(address.getCountry());			
			State state = createState(address.getState(), country);
			address2.setState(state);
			addressService.createAddress(address2);
			addresses2.add(address2);
		}
		
		return addresses2;
	}

	/**
	 * <p> This method will check the database for the state name . If there then will return the state else will create one.<p>
	 * @param stateName 
	 * @param country type of {@link Country}
	 * @return state
	 * */
	public State createState(String stateName, Country country) {
		State state = null;
		if(ApplicationObjectUtils.isNotNull(stateName)){
			state = stateService.fetchStateByName(stateName);
			if(ApplicationObjectUtils.isNotNull(state)){
				return state;
			}
		}
		
		state = configurationService.createObjectByBeanId("org.ticketbooking.core.domain.user.State");
		state.setName(stateName);
		state.setCountry(country);
		stateService.createState(state);
		return state;
	}

	/**
	 * <p> This method will check the database for the country name . If there then will return the country else will create one.<p>
	 * @param countryName 
	 * @return {@link Country}
	 * */
	public Country createCountry(String countryName) {
		if(ApplicationObjectUtils.isNull(countryName)){
			countryName = TicketBookingContext.getTicketBookingContext().getLocale().getDisplayCountry();
		}
		Country country=null;
		if(ApplicationObjectUtils.isNotNull(countryName)){
			country = countryService.fetchCountryByName(countryName);
			if(ApplicationObjectUtils.isNotNull(country)){
				return country;
			}
		}
		country = configurationService.createObjectByBeanId("org.ticketbooking.core.domain.user.Country");
		country.setName(countryName);
		org.ticketbooking.core.domain.other.Locale locale = createLocale();
		country.setLocale(locale);
		countryService.createCountry(country);
		return country;
	}


	/**
	 * <p> This method will check the database for the locale name . If there then will return the locale else will create one.<p>
	 * @return {@link LocaleService}
	 * */
	public org.ticketbooking.core.domain.other.Locale createLocale() {
		Locale utilLocale = TicketBookingContext.getTicketBookingContext().getLocale();
		org.ticketbooking.core.domain.other.Locale locale = null;
		if(ApplicationObjectUtils.isNotNull(utilLocale)){
			locale = localeService.fetchLocaleByName(utilLocale.toString());
			if(ApplicationObjectUtils.isNotNull(locale)){
				return locale;
			}
		}
		locale = configurationService.createObjectByBeanId("org.ticketbooking.core.domain.other.Locale");
		locale.setName(utilLocale.toString());
		locale.setTimeZone(TicketBookingContext.getTicketBookingContext().getTimeZone().getID());
		localeService.createLocale(locale);
		return locale;
	}
	
	/**
	 * <p> A transactional method to link the customer to the address </p>
	 * @param customer type of {@link Customer}
	 * @param address type of {@link org.ticketbooking.core.domain.user.Address}
	 * */
	@Transactional("tbsTransaction")
	public void createCustomerAddress(Customer customer,org.ticketbooking.core.domain.user.Address address){
		CustomerAddress customerAddress = configurationService.createObjectByBeanId("org.ticketbooking.core.domain.user.CustomerAddress");
		customerAddress.setCustomer(customerService.findCustomerById(customer.getId()));
		customerAddress.setAddress(addressService.fetchAddress(address.getId()));
		customerAddress.setAddressName("Address created for customer");
		customerAddressService.createCustomerAddress(customerAddress);
	}
}
