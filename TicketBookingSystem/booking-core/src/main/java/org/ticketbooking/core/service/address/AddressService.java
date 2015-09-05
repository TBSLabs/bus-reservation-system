package org.ticketbooking.core.service.address;

import org.ticketbooking.core.domain.user.Address;

public interface AddressService {
	void createAddress(Address address);
	void deleteAddress(Long id);
	Address fetchAddress(Long id);
//	List<AddressImpl> fetchAddressByCustomer(Long customerId);
	void updateAddress(Address address);
}
