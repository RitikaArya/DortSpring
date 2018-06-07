package com.murphy.appdownload.dto;

public class DispositionCodeDto {

	private int merrickID;
	private int productTypeID;
	private String dispositionCodeShort;
	
	public int getMerrickID() {
		return merrickID;
	}
	
	public void setMerrickID(int merrickID) {
		this.merrickID = merrickID;
	}

	public int getProductTypeID() {
		return productTypeID;
	}

	public void setProductTypeID(int productTypeID) {
		this.productTypeID = productTypeID;
	}

	public String getDispositionCodeShort() {
		return dispositionCodeShort;
	}

	public void setDispositionCodeShort(String dispositionCodeShort) {
		this.dispositionCodeShort = dispositionCodeShort;
	}

	@Override
	public String toString() {
		return "DispositionCodeDto [merrickID=" + merrickID + ", productTypeID=" + productTypeID
				+ ", dispositionCodeShort=" + dispositionCodeShort + "]";
	}
	
}
