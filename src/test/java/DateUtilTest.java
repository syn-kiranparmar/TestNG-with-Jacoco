package com.veritranspay.cpds.cil.cgw.util;


import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DateUtilTest {
	/**
	 * <p>  </p>
	 * @throws Exception 
	 */
	@Test
	public void testGetTodayDateinGMT() throws Exception {
		String currentDateTime = DateUtil.getTodayDateinGMT();
		Assert.assertEquals(currentDateTime, currentDateTime);
	}
	
	/**
	 * <p>  </p>
	 * @throws Exception 
	 */
	@Test
	public void testGetFormattedDate() throws Exception {
		String currentDateTime = DateUtil.getFormattedDate(new Date());
		Assert.assertEquals(currentDateTime, currentDateTime);
	}
	
	/**
	 * <p>  </p>
	 * @throws Exception 
	 */
	@Test
	public void testGetCurrentDateAndTimeInISOFormat() throws Exception {
		String currentDateTime = DateUtil.getCurrentDateAndTimeInISOFormat();
		Assert.assertEquals(currentDateTime, currentDateTime);
	}
}
