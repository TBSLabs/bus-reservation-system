package org.ticketbooking.core.script.executer.sql;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.datasource.init.ScriptException;
import org.springframework.stereotype.Component;
import org.ticketbooking.common.annotation.log.Log;
import org.ticketbooking.common.script.executer.ScriptExecuter;
import org.ticketbooking.common.script.utils.SQLScriptUtils;

@Component("trsSqlExecuter")
public class TRSSQLExecuterServiceImpl implements ScriptExecuter {

	@Log
	Logger log;
	ApplicationContext applicationContext;

	@Resource(name = "dataSource")
	DataSource dataSource;

	@Value("${seed.data.sql.path}")
	String sqlPath;

	public void executeScript() throws ScriptException, SQLException, IOException {
		File directory = applicationContext.getResource(sqlPath).getFile();
		File[] files = directory.listFiles();
		for (File file : files) {
			log.info("Script file " + file.getPath()+ " is going to executed");
			SQLScriptUtils.executeScript(dataSource.getConnection(), file, false);
			log.info("Script file " + file.getAbsolutePath()+ " is executed successfully");
		}
	}

	public void setApplicationContext(ApplicationContext applicationContext)throws BeansException {
		this.applicationContext=applicationContext;
	}
}
