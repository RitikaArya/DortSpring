package com.murphy.appdownload.dto;

public class BusinessEntityDto {

	private int merrickID;
	private String CompanyName;
	private int haulerFlag;
	private int TransporterFlag;
	private int PurchaserFlag;
	
	public int getMerrickID() {
		return merrickID;
	}
	
	public void setMerrickID(int merrickID) {
		this.merrickID = merrickID;
	}

	public String getCompanyName() {
		return CompanyName;
	}

	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}

	public int getHaulerFlag() {
		return haulerFlag;
	}

	public void setHaulerFlag(int haulerFlag) {
		this.haulerFlag = haulerFlag;
	}

	public int getTransporterFlag() {
		return TransporterFlag;
	}

	public void setTransporterFlag(int transporterFlag) {
		TransporterFlag = transporterFlag;
	}

	public int getPurchaserFlag() {
		return PurchaserFlag;
	}

	public void setPurchaserFlag(int purchaserFlag) {
		PurchaserFlag = purchaserFlag;
	}

	@Override
	public String toString() {
		return "BusinessEntityDto [merrickID=" + merrickID + ", CompanyName=" + CompanyName + ", haulerFlag="
				+ haulerFlag + ", TransporterFlag=" + TransporterFlag + ", PurchaserFlag=" + PurchaserFlag + "]";
	}

}
