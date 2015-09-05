package org.ticketbooking.core.service;

import org.springframework.context.ApplicationContextAware;

public interface TRSEntityConfigurationService extends ApplicationContextAware{
	<T> T createObjectByBeanId(String beanId);
}
