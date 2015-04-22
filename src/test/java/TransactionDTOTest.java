package com.veritranspay.cpds.cil.cgw.dto;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TransactionDTOTest {
	@Test
	public void testTransactionDTO() {
		TransactionDTO transactionDTO = new TransactionDTO();
		
		transactionDTO.setTransactionAmount("transactionAmount");
		Assert.assertEquals(transactionDTO.getTransactionAmount(), "transactionAmount");
		
		transactionDTO.setTransactionDateTime("transactionDateTime");
		Assert.assertEquals(transactionDTO.getTransactionDateTime(), "transactionDateTime");
		
		transactionDTO.setTransactionId("transactionId");
		Assert.assertEquals(transactionDTO.getTransactionId(), "transactionId");
		
		transactionDTO.setTransactionResultCode("transactionResultCode");
		Assert.assertEquals(transactionDTO.getTransactionResultCode(), "transactionResultCode");
		
		transactionDTO.setTransactionStatus("transactionStatus");
		Assert.assertEquals(transactionDTO.getTransactionStatus(), "transactionStatus");
		
		transactionDTO.setTransactionTypeCode("transactionTypeCode");
		Assert.assertEquals(transactionDTO.getTransactionTypeCode(), "transactionTypeCode");
	}
}
