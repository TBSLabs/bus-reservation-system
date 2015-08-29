package org.ticketbooking.core.service.address;

import java.util.List;

import org.ticketbooking.core.domain.user.AddressImpl;

public interface AddressService {
	void createAddress(AddressImpl address);
	void deleteAddress(Long id);
	AddressImpl fetchAddress(Long id);
	List<AddressImpl> fetchAddressByCustomer(Long customerId);
	void updateAddress(AddressImpl address);
}
