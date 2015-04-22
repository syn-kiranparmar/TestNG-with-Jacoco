package com.veritranspay.cpds.cil.cgw.dto;

import org.testng.Assert;
import org.testng.annotations.Test;

public class InquiryResponseDTOTest {
	@Test
	public void testInquiryResponseDTO() {
		InquiryResponseDTO inquiryResponseDTO = new InquiryResponseDTO();
		
		inquiryResponseDTO.setErrorType("errorType");
		Assert.assertEquals(inquiryResponseDTO.getErrorType(), "errorType");
		
		inquiryResponseDTO.setMerchantId("merchantId");
		Assert.assertEquals(inquiryResponseDTO.getMerchantId(), "merchantId");
		
		OrderDetailDTO orderDetailDto = new OrderDetailDTO();
		inquiryResponseDTO.setOrderDetailDto(orderDetailDto);
		Assert.assertEquals(inquiryResponseDTO.getOrderDetailDto(), orderDetailDto);
		
		inquiryResponseDTO.setOrderId("orderId");
		Assert.assertEquals(inquiryResponseDTO.getOrderId(), "orderId");
		
		inquiryResponseDTO.setRespDateTime("respDateTime");
		Assert.assertEquals(inquiryResponseDTO.getRespDateTime(), "respDateTime");
		
		inquiryResponseDTO.setResultCode("resultCode");
		Assert.assertEquals(inquiryResponseDTO.getResultCode(), "resultCode");
		
		inquiryResponseDTO.setResultMessage("resultMessage");
		Assert.assertEquals(inquiryResponseDTO.getResultMessage(), "resultMessage");		
	}
}
