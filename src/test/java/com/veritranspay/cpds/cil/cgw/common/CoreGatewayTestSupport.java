package com.veritranspay.cpds.cil.cgw.common;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.testng.CamelTestSupport;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.LifecycleState;
import org.apache.catalina.startup.Tomcat;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 * Base class for all the test classes of core gateway. Each of the test classes in core gateway will extend from this class.
 * @author Kiran.Parmar
 * 
 */
public class CoreGatewayTestSupport extends CamelTestSupport{
	
	/** The tomcat instance. */
	private Tomcat mTomcat;
	/** The temporary directory in which Tomcat and the app are deployed. */
	private String mWorkingDir = "D:\\Embedded_Tomcat_Temp"; //System.getProperty("java.io.tmpdir");	
	
	@BeforeSuite
	public void setUpSuite() throws LifecycleException, IOException, NamingException {
		//createInitialContext();
		mTomcat = new Tomcat();
		mTomcat.setPort(8080);
		mTomcat.setBaseDir(mWorkingDir);
		mTomcat.getHost().setAppBase(mWorkingDir);
		mTomcat.getHost().setAutoDeploy(true);
		mTomcat.getHost().setDeployOnStartup(true);
		
		String contextPath = "/" + getApplicationId();
		File webApp = new File(mWorkingDir, getApplicationId());
		
		Context context = mTomcat.addWebapp(mTomcat.getHost(), contextPath, webApp.getAbsolutePath());
		//File configFile = new File("WebContent/META-INF/context.xml");
		//context.setConfigFile(configFile.toURI().toURL());
		mTomcat.start();
		//mTomcat.enableNaming();
	}
	
	@AfterSuite
	public void cleanUpSuite() throws Exception {
		if (mTomcat.getServer() != null
	            && mTomcat.getServer().getState() != LifecycleState.DESTROYED) {
	        if (mTomcat.getServer().getState() != LifecycleState.STOPPED) {
	              mTomcat.stop();
	        }
	        mTomcat.destroy();
	    }
	}

	private String getApplicationId() {
		return "cpds-upop-cil-cgw.war";
	}	
	
	/**
	 * Overridden method from CamelTestSupport to tell Camel test-kit that it should only create CamelContext once (per class), so we will
     * re-use the CamelContext between each test method in this class. This will save test execution time.
	 */
	@Override
    public boolean isCreateCamelContextPerClass() {
        return true;
    }
	
	
}
