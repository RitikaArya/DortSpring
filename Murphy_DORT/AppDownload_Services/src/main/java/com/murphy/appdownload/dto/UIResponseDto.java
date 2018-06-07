package com.murphy.appdownload.dto;

import java.util.List;

public class UIResponseDto {

	private List<BusinessEntityDto> businessEntityList;
	private List<ProductCodeDto> productCodeDtoList;
	private List<DispositionCodeDto> dispositionCodeDtoList;
	private List<MeterDto> meterDtoList;
	private ResponseMessage responseMessage;

	public List<DispositionCodeDto> getDispositionCodeDtoList() {
		return dispositionCodeDtoList;
	}

	public void setDispositionCodeDtoList(List<DispositionCodeDto> dispositionCodeDtoList) {
		this.dispositionCodeDtoList = dispositionCodeDtoList;
	}

	public ResponseMessage getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(ResponseMessage responseMessage) {
		this.responseMessage = responseMessage;
	}

	public List<ProductCodeDto> getProductCodeDtoList() {
		return productCodeDtoList;
	}

	public void setProductCodeDtoList(List<ProductCodeDto> productCodeDtoList) {
		this.productCodeDtoList = productCodeDtoList;
	}

	public List<BusinessEntityDto> getBusinessEntityList() {
		return businessEntityList;
	}

	public void setBusinessEntityList(List<BusinessEntityDto> businessEntityList) {
		this.businessEntityList = businessEntityList;
	}

	public List<MeterDto> getMeterDtoList() {
		return meterDtoList;
	}

	public void setMeterDtoList(List<MeterDto> meterDtoList) {
		this.meterDtoList = meterDtoList;
	}

	@Override
	public String toString() {
		return "UIResponseDto [businessEntityList=" + businessEntityList + ", productCodeDtoList=" + productCodeDtoList
				+ ", dispositionCodeDtoList=" + dispositionCodeDtoList + ", responseMessage=" + responseMessage + "]";
	}

}
