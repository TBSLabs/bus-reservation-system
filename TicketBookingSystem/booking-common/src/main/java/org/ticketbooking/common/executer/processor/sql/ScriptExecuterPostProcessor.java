package org.ticketbooking.common.executer.processor.sql;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.jdbc.datasource.init.ScriptException;
import org.springframework.stereotype.Component;
import org.ticketbooking.common.annotation.log.Log;
import org.ticketbooking.common.script.executer.ScriptExecuter;

@Component("sqlExecuter")
public class ScriptExecuterPostProcessor implements BeanPostProcessor {
	@Log
	Logger logger;

	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		return bean;
	}

	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		if (bean instanceof ScriptExecuter) {
			ScriptExecuter scriptExecuter = (ScriptExecuter) bean;
			try {
				scriptExecuter.executeScript();
			} catch (IOException e) {
				logger.error(e);
			} catch (ScriptException e) {
				logger.error(e);
			} catch (SQLException e) {
				logger.error(e);
			}
		}
		return bean;
	}

}
