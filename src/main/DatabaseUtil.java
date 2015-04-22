/**
 * 
 */
package com.veritranspay.cpds.cil.cgw.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mchange.v2.c3p0.DriverManagerDataSource;
import com.veritranspay.cpds.cil.cgw.constants.CoreGatewayConstants;

/**
 * @author Parag.Shende
 * Class creates dataSource and provides its instance to calling code. 
 *
 */
public class DatabaseUtil {

	private static DataSource datasource = null;

	private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseUtil.class);

	/**
	 * Constructor made as private
	 */
	private DatabaseUtil() {
	}

	/**
	 * Method lookups dataSource using JNDI lookup and returns dataSource instance.
	 * @return DataSource is returned.
	 */
	public static DataSource getDataSource() {
		try {
			if (datasource != null) {
				return datasource;
			}
			Context initContext = new InitialContext();
			
			if(initContext.lookup(initContext.INITIAL_CONTEXT_FACTORY).toString().equals("org.apache.camel.util.jndi.CamelInitialContextFactory")) {
				datasource = initializeDatasourceForTestNG();
				LOGGER.debug("getDataSource - Creating new datasource instance for TestNG.");
			}
			else {
				Context envContext = (Context) initContext.lookup(CoreGatewayConstants.CONTEXT_LOOKUP);
				datasource = (DataSource) envContext.lookup(CoreGatewayConstants.JNDI_LOOKUP);
				LOGGER.debug("getDataSource - Creating new datasource instance.");
			}

		} catch (Exception ex) {
			LOGGER.error("Error found in getDataSource() : {}", ex);
		}
		LOGGER.info("Returning Datasource instance");
		return datasource;
	}
	
	private static DriverManagerDataSource initializeDatasourceForTestNG() throws Exception{
		DriverManagerDataSource dataSource;
		try {
			Properties datasourceProps = new Properties();
			InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(CoreGatewayConstants.DATASOURCE_PROPERTIES_FILE);
			datasourceProps.load(in);
			dataSource = new DriverManagerDataSource();
			dataSource.setDriverClass(datasourceProps.getProperty("driverclassname"));
			dataSource.setJdbcUrl(datasourceProps.getProperty("dburl"));
			dataSource.setUser(datasourceProps.getProperty("dbusername"));
			dataSource.setPassword(datasourceProps.getProperty("dbpassword"));
		} catch (IOException ioException) {
			LOGGER.error("Error occured while getting Datasource");
			throw new Exception("Error occured while getting datasource. Error details - : ", ioException);
		}
		
		return dataSource;
	}
}
