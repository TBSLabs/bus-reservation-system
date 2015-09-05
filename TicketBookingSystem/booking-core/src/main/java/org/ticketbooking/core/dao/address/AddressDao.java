package org.ticketbooking.core.dao.address;

import org.ticketbooking.core.domain.user.Address;

public interface AddressDao {
	void createAddress(Address address);
	void deleteAddress(Long id);
	Address fetchAddress(Long id);
	//List<AddressImpl> fetchAddressByCustomer(Long customerId);
	void updateAddress(Address address);
}
