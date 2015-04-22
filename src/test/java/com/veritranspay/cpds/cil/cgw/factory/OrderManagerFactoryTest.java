package com.veritranspay.cpds.cil.cgw.factory;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.veritranspay.cpds.cil.cgw.constants.CoreGatewayConstants;
import com.veritranspay.cpds.cil.cgw.manager.interfaces.OrderManager;
import com.veritranspay.cpds.common.exception.BaseException;

public class OrderManagerFactoryTest {
	/**
	 * <p> It checks whether the instance created returned by the OrderManagerFactory class is valid or not. </p>
	 * <Input> ENDPOINT_AUTHORIZE = "servlet:///authorize/api/v1" </Input>
	 * <Output> AuthorizeOrderManager instance should get created </Output>
	 */
	@Test
	public void testGetValidatorForAuthorize() {
		OrderManagerFactory orderManagerFactory = OrderManagerFactory.getInstance();
		OrderManager authorizeOrderManager = orderManagerFactory.getManager(CoreGatewayConstants.ENDPOINT_AUTHORIZE);
		Assert.assertEquals(true, authorizeOrderManager instanceof OrderManager);
	}

	/**
	 * <p> It checks whether the instance created returned by the OrderManagerFactory class is valid or not. </p>
	 * <Input> ENDPOINT_CAPTURE = "servlet:///capture/api/v1" </Input>
	 * <Output> CaptureOrderManager instance should get created </Output>
	 */
	@Test
	public void testGetValidatorForCapture() {
		OrderManagerFactory orderManagerFactory = OrderManagerFactory.getInstance();
		OrderManager captureOrderManager = orderManagerFactory.getManager(CoreGatewayConstants.ENDPOINT_CAPTURE);
		Assert.assertEquals(true, captureOrderManager instanceof OrderManager);
	}

	/**
	 * <p> It checks whether the instance created returned by the OrderManagerFactory class is valid or not. </p>
	 * <Input> ENDPOINT_CANCEL = "servlet:///cancel/api/v1" </Input>
	 * <Output> CancelOrderManager instance should get created </Output>
	 */
	@Test
	public void testGetValidatorForCancel() {
		OrderManagerFactory orderManagerFactory = OrderManagerFactory.getInstance();
		OrderManager cancelOrderManager = orderManagerFactory.getManager(CoreGatewayConstants.ENDPOINT_CANCEL);
		Assert.assertEquals(true, cancelOrderManager instanceof OrderManager);
	}

	/**
	 * <p> It checks whether the instance created returned by the OrderManagerFactory class is valid or not. </p>
	 * <Input> ENDPOINT_INQUIRY = "servlet:///inquiry/api/v1" </Input>
	 * <Output> InquiryOrderManager instance should get created </Output>
	 */
	@Test
	public void testGetValidatorForInquiry() {
		OrderManagerFactory orderManagerFactory = OrderManagerFactory.getInstance();
		OrderManager inquiryOrderManager = orderManagerFactory.getManager(CoreGatewayConstants.ENDPOINT_INQUIRY);
		Assert.assertEquals(true, inquiryOrderManager instanceof OrderManager);
	}
	
	@Test
	public void testGetValidatorException() {
		OrderManagerFactory orderManagerFactory = OrderManagerFactory.getInstance();
		try{
			OrderManager inquiryOrderManager = orderManagerFactory.getManager("");
		}
		catch(Exception e){
			Assert.assertTrue(e instanceof BaseException);
		}
	}
}
