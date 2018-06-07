package com.murphy.appdownload.dto;

public class ProductCodeDto {
	
	private int merrickID;
	private int productTypeID;
	private String productCodeShort;
	
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
	
	public String getProductCodeShort() {
		return productCodeShort;
	}
	
	public void setProductCodeShort(String productCodeShort) {
		this.productCodeShort = productCodeShort;
	}

	@Override
	public String toString() {
		return "ProductCodeDto [merrickID=" + merrickID + ", productTypeID=" + productTypeID + ", productCodeShort="
				+ productCodeShort + "]";
	}
	
}
