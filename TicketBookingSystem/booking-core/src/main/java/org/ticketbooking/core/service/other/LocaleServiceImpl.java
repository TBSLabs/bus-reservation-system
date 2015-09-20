package org.ticketbooking.core.service.other;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ticketbooking.core.dao.other.LocaleDao;
import org.ticketbooking.core.domain.other.Locale;

@Service("localeService")
public class LocaleServiceImpl implements LocaleService{
	
	@Resource(name="localeDao")
	LocaleDao localeDao;
	
	@Transactional("tbsTransaction")
	public void createLocale(Locale locale) {
		localeDao.createLocale(locale);
	}

	@Transactional(value="tbsTransaction",readOnly=true)
	public Locale fetchLocale(Long id) {
		return localeDao.fetchCountry(id);
	}

	@Transactional(value="tbsTransaction",readOnly=true)
	public Locale fetchLocaleByName(String name) {
		return localeDao.fetchCountryByName(name);
	}

}
