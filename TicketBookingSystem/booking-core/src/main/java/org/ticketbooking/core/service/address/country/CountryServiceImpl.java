package org.ticketbooking.core.service.address.country;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ticketbooking.core.dao.address.country.CountryDao;
import org.ticketbooking.core.domain.user.Country;

@Service("countryService")
public class CountryServiceImpl implements CountryService{
	
	@Resource(name="countryDao")
	CountryDao countryDao;

	@Transactional("tbsTransaction")
	public void createCountry(Country country) {
		countryDao.createCountry(country);
	}

	@Transactional(value="tbsTransaction",readOnly=true)
	public Country fetchCountry(Long id) {
		return countryDao.fetchCountry(id);
	}

	@Transactional(value="tbsTransaction",readOnly=true)
	public Country fetchCountryByName(String name) {
		return countryDao.fetchCountryByName(name);
	}
}
