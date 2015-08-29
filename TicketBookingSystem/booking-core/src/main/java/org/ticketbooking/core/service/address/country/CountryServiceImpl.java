package org.ticketbooking.core.service.address.country;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ticketbooking.core.dao.address.country.CountryDao;
import org.ticketbooking.core.domain.user.CountryImpl;

@Service("countryService")
public class CountryServiceImpl implements CountryService{
	
	@Resource(name="countryDao")
	CountryDao countryDao;

	@Transactional("tbsTransaction")
	public void createCountry(CountryImpl country) {
		countryDao.createCountry(country);
	}

	@Transactional(value="tbsTransaction",readOnly=true)
	public void fetchCountry(Long id) {
		countryDao.fetchCountry(id);
	}

	@Transactional(value="tbsTransaction",readOnly=true)
	public void fetchCountryByName(String name) {
		countryDao.fetchCountryByName(name);
	}

}
