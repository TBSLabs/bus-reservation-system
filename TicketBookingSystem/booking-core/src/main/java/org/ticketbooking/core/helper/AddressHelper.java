package org.ticketbooking.core.helper;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.ticketbooking.core.api.jaxb.user.Address;
import org.ticketbooking.core.domain.other.LocaleImpl;
import org.ticketbooking.core.domain.user.AddressImpl;
import org.ticketbooking.core.domain.user.CountryImpl;
import org.ticketbooking.core.domain.user.StateImpl;
import org.ticketbooking.core.service.address.AddressService;
import org.ticketbooking.core.service.address.country.CountryService;
import org.ticketbooking.core.service.address.state.StateService;

@Component("addressHelper")
public class AddressHelper {
	
	@Resource(name="addressService")
	AddressService addressService;
	
	@Resource(name="stateService")
	StateService stateService;
	
	@Resource(name="countryService")
	CountryService countryService;
	
	public Address convertAddress(org.ticketbooking.core.domain.user.Address address){
		Address convertedAddress = new Address();
		convertedAddress.setCountry(address.getState().getCountry().getName());
		convertedAddress.setPin(address.getPin());
		convertedAddress.setState(address.getState().getName());
		convertedAddress.setStreet1(address.getStreet1());
		convertedAddress.setStreet2(address.getStree2());
		return convertedAddress;
	}

	public Set<AddressImpl> convertAddressEntity(List<Address> addresses) {
		Set<AddressImpl> addresses2 = new HashSet<AddressImpl>();
		for (Address address : addresses) {
			AddressImpl address2 = new AddressImpl();
			address2.setCreatedDate(new Date());
			address2.setUpdatedDate(new Date());
			address2.setPin(address.getPin());
			address2.setStreet1(address.getStreet1());
			address2.setStree2(address.getStreet2());
			
			CountryImpl country = new CountryImpl();
			country.setName(address.getCountry());
			LocaleImpl locale = new LocaleImpl();
			locale.setName("en-IN");
			locale.setTimeZone("-05:30");
			country.setLocale(locale);
			countryService.createCountry(country);
			
			StateImpl state = new StateImpl();
			state.setName(address.getState());
			state.setCountry(country);
			stateService.createState(state);
			address2.setState(state);
			addressService.createAddress(address2);
			addresses2.add(address2);
		}
		
		return addresses2;
	}
}
