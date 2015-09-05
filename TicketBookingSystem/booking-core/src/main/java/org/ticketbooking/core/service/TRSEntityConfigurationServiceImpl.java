package org.ticketbooking.core.service;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service("trsEntityConfigurationService")
public class TRSEntityConfigurationServiceImpl implements TRSEntityConfigurationService{
	
	ApplicationContext applicationContext;
	
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext=applicationContext;
	}
	
	public <T> T createObjectByBeanId(String beanId){
		@SuppressWarnings("unchecked")
		T t = (T) applicationContext.getBean(beanId);
		return t;
	}
	
}
