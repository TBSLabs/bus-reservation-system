package org.ticketbooking.common.annotation.processor.log;

import java.lang.reflect.Field;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.ReflectionUtils.FieldCallback;
import org.ticketbooking.common.annotation.log.Log;

@Component("trsLogProcessor")
public class LogProcessor implements BeanPostProcessor {

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	public Object postProcessBeforeInitialization(final Object bean, String beanName)	throws BeansException {
		ReflectionUtils.doWithFields(bean.getClass(), new FieldCallback() {
			
			public void doWith(Field field) throws IllegalArgumentException,IllegalAccessException {
				if(field.getAnnotation(Log.class) != null){
					Logger logger = Logger.getLogger(bean.getClass());
					field.setAccessible(true);
					field.set(bean, logger);
					field.setAccessible(false);
				}
			}
		});
		return bean;
	}

}
