package org.ticketbooking.core.service.address;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ticketbooking.core.dao.address.AddressDao;
import org.ticketbooking.core.domain.user.Address;

@Service("addressService")
public class AddressServiceImpl implements AddressService{

	@Resource(name="addressDao")
	AddressDao addressDao;
	
	@Transactional("tbsTransaction")
	public void createAddress(Address address) {
		addressDao.createAddress(address);
	}

	@Transactional("tbsTransaction")
	public void deleteAddress(Long id) {
		addressDao.deleteAddress(id);
	}


	@Transactional(value="tbsTransaction",readOnly=true)
	public Address fetchAddress(Long id) {
		return addressDao.fetchAddress(id);
	}


	/*@Transactional(value="tbsTransaction",readOnly=true)
	public List<AddressImpl> fetchAddressByCustomer(Long customerId) {
		return addressDao.fetchAddressByCustomer(customerId);
	}*/

	@Transactional("tbsTransaction")
	public void updateAddress(Address address) {
		addressDao.updateAddress(address);
	}

}
