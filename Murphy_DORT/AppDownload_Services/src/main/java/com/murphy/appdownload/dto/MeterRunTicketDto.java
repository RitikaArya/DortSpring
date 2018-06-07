package com.murphy.appdownload.dto;

import org.codehaus.jackson.annotate.JsonAutoDetect;

@JsonAutoDetect
public class MeterRunTicketDto {

	private Integer merrickId;
	private String runOpenDate;
	private String runOpenTime;
	private String runCloseDate;
	private String runCloseTime;
	private int productCode;
	private int dispositionCode;
	private int purchaser;
	private int hauler;
	private String runTicketNumber;
	private float openOdometer;
	private float closeOdometer;
	private float openTemperature;
	private float closeTemperature;
	private float lactMeterFactor;
	private float lactCompressibilityFactor;
	private float grossBarrels;
	private float bsandW;
	private float actualGravity;
	private float observedTemperature;
	private float netBarrels;
	
	public Integer getMerrickId() {
		return merrickId;
	}
	public void setMerrickId(Integer merrickId) {
		this.merrickId = merrickId;
	}
	public String getRunOpenTime() {
		return runOpenTime;
	}
	public void setRunOpenTime(String runOpenTime) {
		this.runOpenTime = runOpenTime;
	}
	public String getRunCloseTime() {
		return runCloseTime;
	}
	public void setRunCloseTime(String runCloseTime) {
		this.runCloseTime = runCloseTime;
	}
	public int getProductCode() {
		return productCode;
	}
	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}
	public int getDispositionCode() {
		return dispositionCode;
	}
	public void setDispositionCode(int dispositionCode) {
		this.dispositionCode = dispositionCode;
	}
	public int getPurchaser() {
		return purchaser;
	}
	public void setPurchaser(int purchaser) {
		this.purchaser = purchaser;
	}
	public int getHauler() {
		return hauler;
	}
	public void setHauler(int hauler) {
		this.hauler = hauler;
	}
	public String getRunTicketNumber() {
		return runTicketNumber;
	}
	public void setRunTicketNumber(String runTicketNumber) {
		this.runTicketNumber = runTicketNumber;
	}
	public float getOpenOdometer() {
		return openOdometer;
	}
	public void setOpenOdometer(float openOdometer) {
		this.openOdometer = openOdometer;
	}
	public float getCloseOdometer() {
		return closeOdometer;
	}
	public void setCloseOdometer(float closeOdometer) {
		this.closeOdometer = closeOdometer;
	}
	public float getOpenTemperature() {
		return openTemperature;
	}
	public void setOpenTemperature(float openTemperature) {
		this.openTemperature = openTemperature;
	}
	public float getCloseTemperature() {
		return closeTemperature;
	}
	public void setCloseTemperature(float closeTemperature) {
		this.closeTemperature = closeTemperature;
	}
	public float getLactMeterFactor() {
		return lactMeterFactor;
	}
	public void setLactMeterFactor(float lactMeterFactor) {
		this.lactMeterFactor = lactMeterFactor;
	}
	public float getLactCompressibilityFactor() {
		return lactCompressibilityFactor;
	}
	public void setLactCompressibilityFactor(float lactCompressibilityFactor) {
		this.lactCompressibilityFactor = lactCompressibilityFactor;
	}
	public float getGrossBarrels() {
		return grossBarrels;
	}
	public void setGrossBarrels(float grossBarrels) {
		this.grossBarrels = grossBarrels;
	}
	public float getBsandW() {
		return bsandW;
	}
	public void setBsandW(float bsandW) {
		this.bsandW = bsandW;
	}
	public float getActualGravity() {
		return actualGravity;
	}
	public void setActualGravity(float actualGravity) {
		this.actualGravity = actualGravity;
	}
	public float getObservedTemperature() {
		return observedTemperature;
	}
	public void setObservedTemperature(float observedTemperature) {
		this.observedTemperature = observedTemperature;
	}
	public float getNetBarrels() {
		return netBarrels;
	}
	public void setNetBarrels(float netBarrels) {
		this.netBarrels = netBarrels;
	}
	public String getRunOpenDate() {
		return runOpenDate;
	}
	public void setRunOpenDate(String runOpenDate) {
		this.runOpenDate = runOpenDate;
	}
	public String getRunCloseDate() {
		return runCloseDate;
	}
	public void setRunCloseDate(String runCloseDate) {
		this.runCloseDate = runCloseDate;
	}
	@Override
	public String toString() {
		return "MeterRunTicketDto [merrickId=" + merrickId + ", runOpenDate=" + runOpenDate + ", runOpenTime="
				+ runOpenTime + ", runCloseDate=" + runCloseDate + ", runCloseTime=" + runCloseTime + ", productCode="
				+ productCode + ", dispositionCode=" + dispositionCode + ", purchaser=" + purchaser + ", hauler="
				+ hauler + ", RunTicketNumber=" + runTicketNumber + ", OpenOdometer=" + openOdometer
				+ ", CloseOdometer=" + closeOdometer + ", OpenTemperature=" + openTemperature + ", CloseTemperature="
				+ closeTemperature + ", LactMeterFactor=" + lactMeterFactor + ", LactCompressibilityFactor="
				+ lactCompressibilityFactor + ", GrossBarrels=" + grossBarrels + ", BSAndW=" + bsandW
				+ ", ActualGravity=" + actualGravity + ", ObservedTemperature=" + observedTemperature + ", NetBarrels="
				+ netBarrels + "]";
	}

}
