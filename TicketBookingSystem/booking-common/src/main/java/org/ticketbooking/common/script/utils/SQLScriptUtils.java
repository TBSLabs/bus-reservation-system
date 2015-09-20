package org.ticketbooking.common.script.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;
import org.ticketbooking.common.constants.ApplicationConstants;
import org.ticketbooking.common.utils.ApplicationObjectUtils;

/**
 * <p> This class is mainly for running the seed-data into the application</p>
 * @author cooligc
 * */
public class SQLScriptUtils {
	
	static final Logger LOGGER = Logger.getLogger(SQLScriptUtils.class);
	
	/**
	 * <p>First it'll check the seed data are present in the database or not. if not present then will execute the batch seed data as batch Transaction</p>
	 * <p> If all record are executed successfully, then it'll commit the transaction else roll it back.</p>
	 * @param connection type of {@link Connection}
	 * @param script is the seed-data in {@link String} format
	 * @param isCommentIncluded is the flag to identify whether sql comment are inside the seed-data or not
	 * @return {@link Integer} If seed-data are not executed, return 0 else 1
	 * */
	public static int executeScript(Connection connection,String script,boolean isCommentIncluded){
		return executeSQLScript(connection,script,ApplicationConstants.END_OF_SCRIPT_DELIM,isCommentIncluded);
	}
	
	/**
	 * <p>First it'll check the seed data are present in the database or not. if not present then will execute the batch seed data as batch Transaction</p>
	 * <p> If all record are executed successfully, then it'll commit the transaction else roll it back.</p>
	 * @param connection type of {@link Connection}
	 * @param scriptFile is the seed-data in a {@link File} 
	 * @param isCommentIncluded is the flag to identify whether sql comment are inside the seed-data or not
	 * @return {@link Integer} If seed-data are not executed, return 0 else 1
	 * */
	public static int executeScript(Connection connection, File scriptFile,boolean isCommenetIncluded){
		if(hasAlreadySeedData(connection)){
			nullifyDatabaseObjects(connection, null, null);
			return 0;
		}
		FileInputStream fis = null;
		String script="";
		try {
			fis = new FileInputStream(scriptFile);
			int content;
			while ((content = fis.read()) != -1) {
				script+=(char) content+"";
			}
		}catch(IOException e){
			LOGGER.error(e);
		}finally{
			try {
				if (fis != null)
					fis.close();
			} catch (IOException ex) {
				LOGGER.error(ex);
			}
		}
		return executeScript(connection, script, isCommenetIncluded);
	}
	
	/**
	 * <p> Method to check the seed-data are exist in the database or not
	 * @param connection type of {@link Connection}
	 * @return {@link Boolean}
	 * */
	private static boolean hasAlreadySeedData(Connection connection) {
		Statement statement = null;
		ResultSet resultSet=null;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM TBS_LOCALE");
			if(resultSet.next()){
				return true;
			}
		} catch (SQLException e) {
			LOGGER.error("Unable to execute the SQL");
		}
		nullifyDatabaseObjects(null, statement,resultSet);
		return false;
	}

	/**
	 * <p> Method is having business logic to put the seed-data into the database as a transaction.</p>
	 * */
	private static int executeSQLScript(Connection connection,String script,String endOfScriptDelim, boolean isCommentIncluded) {
		if(isCommentIncluded){
			//TODO Logic to be implemented if there is a comment in the SQL file
		}
		String[] tinyScript = readSQLScript(script);
		Statement statement =null;
		try {
			connection.setAutoCommit(Boolean.FALSE);
			statement = connection.createStatement();
			for (String sql : tinyScript) {
				statement.addBatch(sql);
			}
			int[] executedBatch = statement.executeBatch();
			if(tinyScript.length!=executedBatch.length){
				LOGGER.trace("Seed data execution failed");
				connection.rollback();
			}else{
				LOGGER.info("Seed data successfully executed");
				connection.commit();
			}
		} catch (SQLException e) {
			LOGGER.error(e);
			return 0;
		}
		nullifyDatabaseObjects(connection, statement,null);
		return 1;
	}

	/**
	 * <p> This method will nullify all the database object </p>
	 * */
	private static void nullifyDatabaseObjects(Connection connection,Statement statement,ResultSet resultSet) {
		try {
			if(ApplicationObjectUtils.isNotNull(resultSet)){
				resultSet.close();
			}
			if(ApplicationObjectUtils.isNotNull(statement)){
				statement.close();
			}
			if(ApplicationObjectUtils.isNotNull(connection)){
				connection.close();
			}
			LOGGER.info("All database object are closed successfully");
		} catch (SQLException e) {
			LOGGER.error("Unable to return the connection to the pool : "+e);
		}
	}

	private static String[] readSQLScript(String script) {
		return script.split(ApplicationConstants.END_OF_SCRIPT_DELIM);
	}
}
