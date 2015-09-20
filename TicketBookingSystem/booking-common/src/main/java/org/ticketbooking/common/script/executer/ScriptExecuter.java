package org.ticketbooking.common.script.executer;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.context.ApplicationContextAware;
import org.springframework.jdbc.datasource.init.ScriptException;

public interface ScriptExecuter extends ApplicationContextAware{
	void executeScript() throws ScriptException, SQLException,IOException;
}
