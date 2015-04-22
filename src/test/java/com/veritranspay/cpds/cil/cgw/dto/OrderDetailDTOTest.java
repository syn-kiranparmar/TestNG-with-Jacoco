package com.veritranspay.cpds.cil.cgw.dto;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

public class OrderDetailDTOTest {

	@Test
	public void testOrderDetailDTO() {
		OrderDetailDTO detailDTO = new OrderDetailDTO();
		
		detailDTO.setDummyFlag("true");
		Assert.assertEquals(detailDTO.getDummyFlag(), "true");
		
		detailDTO.setLastResultCode("resultCode");
		Assert.assertEquals(detailDTO.getLastResultCode(), "resultCode");
		
		detailDTO.setLastSuccessTxnType("lastTxnType");
		Assert.assertEquals(detailDTO.getLastSuccessTxnType(), "lastTxnType");
		
		detailDTO.setLastTxnStatus("lastTxnStatus");
		Assert.assertEquals(detailDTO.getLastTxnStatus(), "lastTxnStatus");
		
		detailDTO.setLastTxnType("lastTxnType");
		Assert.assertEquals(detailDTO.getLastTxnType(), "lastTxnType");

		detailDTO.setMemo("memo");
		Assert.assertEquals(detailDTO.getMemo(), "memo");
		
		detailDTO.setProdInfo("prodInfo");
		Assert.assertEquals(detailDTO.getProdInfo(), "prodInfo");
		
		List<TransactionDTO> listDtos = new ArrayList<TransactionDTO>();
		listDtos.add(new TransactionDTO());
		detailDTO.setTransactionList(listDtos);
		Assert.assertEquals(detailDTO.getTransactionList().size(), 1);
		
		detailDTO.setTxnAmountOriginal("txnAmountOriginal");
		Assert.assertEquals(detailDTO.getTxnAmountOriginal(), "txnAmountOriginal");
		
		detailDTO.setTxnAmountRemaining("txnAmountRemaining");
		Assert.assertEquals(detailDTO.getTxnAmountRemaining(), "txnAmountRemaining");
		
		detailDTO.setTxnCurrency("txnCurrency");
		Assert.assertEquals(detailDTO.getTxnCurrency(), "txnCurrency");
	}
}
