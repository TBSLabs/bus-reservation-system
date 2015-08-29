package org.ticketbooking.core.dao.address;

import java.util.List;

import org.ticketbooking.core.domain.user.AddressImpl;

public interface AddressDao {
	void createAddress(AddressImpl address);
	void deleteAddress(Long id);
	AddressImpl fetchAddress(Long id);
	List<AddressImpl> fetchAddressByCustomer(Long customerId);
	void updateAddress(AddressImpl address);
}
