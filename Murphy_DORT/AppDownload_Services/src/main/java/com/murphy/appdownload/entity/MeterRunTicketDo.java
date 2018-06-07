package com.murphy.appdownload.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

public class MeterRunTicketDo {

	private int merrickId;
	private String recordDate;
	private String runTicketNumber;
	private int dispositionCode;
	private int runOrDispositionFlag;
	private int fluidDisposition;
	private String destination;
	private int destinationObjectId;
	private int destinationObjectType;
	private int originationObjectId;
	private int originationObjectType;
	private int sourceID;
	private int sourceType;
	private int productCode;
	private int productType;
	private int dataSourceCode;
	private int actualEstimatedFlag;
	private float bSAndW;
	private float emulsionPercent;
	private float waxPercent;
	private float saltContentPPM;
	private float sulfurContentPPM;
	private float waterVaporContentPPM;
	private String runTicketDate;
	private String runOpenDate;
	private String runOpenTime;
	private String runCloseDate;
	private String runCloseTime;
	private float openOdometer;
	private float closeOdometer;
	private float lactMeterFactor;
	private float lactCompressibilityFactor;
	private float lactDensityCorrection;
	private float openTemperature;
	private float closeTemperature;
	private float observedTemperature;
	private float actualGravity;
	private float convertedGravity;
	private float reidVaporPressure;
	private float grossBarrels;
	private float netBarrels;
	private float netWaterBarrels;
	private float allocatedOilBarrels;
	private float allocatedWaterBarrels;
	private int hauler;
	private int haulerLoc;
	private String haulerMeterID;
	private float haulerReportedBarrels;
	private float haulerReportedNetBarrels;
	private int useHaulerBarrelsFlag;
	private String haulerStatementDate;
	private int purchaser;
	private int purchaserLoc;
	private String purchaserMeterID;
	private int unitsFlag;
	private int deleteFlag;
	private int backgroundTaskFlag;
	private int lastTransmission;
	private String lastLoadDate;
	private String lastLoadTime;
	private int transmitFlag;
	private String runNo;
	private String dateInstalled;
	private String dateInService;
	private String sampleDate;
	private String dateProved;
	private float adjustedGross;
	private float adjustedNet;
	private float waterCarryOver;
	private float gasBlowBy;
	private float meterMalfunction;
	private int temperatureCompensation;
	private int meterFactor;
	private int psiFactor;
	private float linePressure;
	private String pressureFactor;
	private float lineTemperature;
	private String comments;
	private String bLogicDateStamp;
	private String bLogicTimeStamp;
	private String allocationDateStamp;
	private String allocationTimeStamp;
	private String userDateStamp;
	private String userTimeStamp;
	private int userID;
	private int purchaserStatementID;
	private int haulerStatementID;
	private float grossNGL;
	private float netNGL;
	private float allocatedNGL;
	private int purchaserStatementSeq;
	private int haulerStatementSeq;
	private int calculationStatusFlag;
	
	public int getMerrickId() {
		return merrickId;
	}
	public void setMerrickId(int merrickId) {
		this.merrickId = merrickId;
	}
	public String getRunTicketNumber() {
		return runTicketNumber;
	}
	public void setRunTicketNumber(String runTicketNumber) {
		this.runTicketNumber = runTicketNumber;
	}
	public int getDispositionCode() {
		return dispositionCode;
	}
	public void setDispositionCode(int dispositionCode) {
		this.dispositionCode = dispositionCode;
	}
	public int getRunOrDispositionFlag() {
		return runOrDispositionFlag;
	}
	public void setRunOrDispositionFlag(int runOrDispositionFlag) {
		this.runOrDispositionFlag = runOrDispositionFlag;
	}
	public int getFluidDisposition() {
		return fluidDisposition;
	}
	public void setFluidDisposition(int fluidDisposition) {
		this.fluidDisposition = fluidDisposition;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getDestinationObjectId() {
		return destinationObjectId;
	}
	public void setDestinationObjectId(int destinationObjectId) {
		this.destinationObjectId = destinationObjectId;
	}
	public int getDestinationObjectType() {
		return destinationObjectType;
	}
	public void setDestinationObjectType(int destinationObjectType) {
		this.destinationObjectType = destinationObjectType;
	}
	public int getOriginationObjectId() {
		return originationObjectId;
	}
	public void setOriginationObjectId(int originationObjectId) {
		this.originationObjectId = originationObjectId;
	}
	public int getOriginationObjectType() {
		return originationObjectType;
	}
	public void setOriginationObjectType(int originationObjectType) {
		this.originationObjectType = originationObjectType;
	}
	public int getSourceID() {
		return sourceID;
	}
	public void setSourceID(int sourceID) {
		this.sourceID = sourceID;
	}
	public int getSourceType() {
		return sourceType;
	}
	public void setSourceType(int sourceType) {
		this.sourceType = sourceType;
	}
	public int getProductCode() {
		return productCode;
	}
	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}
	public int getProductType() {
		return productType;
	}
	public void setProductType(int productType) {
		this.productType = productType;
	}
	public int getDataSourceCode() {
		return dataSourceCode;
	}
	public void setDataSourceCode(int dataSourceCode) {
		this.dataSourceCode = dataSourceCode;
	}
	public int getActualEstimatedFlag() {
		return actualEstimatedFlag;
	}
	public void setActualEstimatedFlag(int actualEstimatedFlag) {
		this.actualEstimatedFlag = actualEstimatedFlag;
	}
	public float getbSAndW() {
		return bSAndW;
	}
	public void setbSAndW(float bSAndW) {
		this.bSAndW = bSAndW;
	}
	public float getEmulsionPercent() {
		return emulsionPercent;
	}
	public void setEmulsionPercent(float emulsionPercent) {
		this.emulsionPercent = emulsionPercent;
	}
	public float getWaxPercent() {
		return waxPercent;
	}
	public void setWaxPercent(float waxPercent) {
		this.waxPercent = waxPercent;
	}
	public float getSaltContentPPM() {
		return saltContentPPM;
	}
	public void setSaltContentPPM(float saltContentPPM) {
		this.saltContentPPM = saltContentPPM;
	}
	public float getSulfurContentPPM() {
		return sulfurContentPPM;
	}
	public void setSulfurContentPPM(float sulfurContentPPM) {
		this.sulfurContentPPM = sulfurContentPPM;
	}
	public float getWaterVaporContentPPM() {
		return waterVaporContentPPM;
	}
	public void setWaterVaporContentPPM(float waterVaporContentPPM) {
		this.waterVaporContentPPM = waterVaporContentPPM;
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
	public float getLactDensityCorrection() {
		return lactDensityCorrection;
	}
	public void setLactDensityCorrection(float lactDensityCorrection) {
		this.lactDensityCorrection = lactDensityCorrection;
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
	public float getObservedTemperature() {
		return observedTemperature;
	}
	public void setObservedTemperature(float observedTemperature) {
		this.observedTemperature = observedTemperature;
	}
	public float getActualGravity() {
		return actualGravity;
	}
	public void setActualGravity(float actualGravity) {
		this.actualGravity = actualGravity;
	}
	public float getConvertedGravity() {
		return convertedGravity;
	}
	public void setConvertedGravity(float convertedGravity) {
		this.convertedGravity = convertedGravity;
	}
	public float getReidVaporPressure() {
		return reidVaporPressure;
	}
	public void setReidVaporPressure(float reidVaporPressure) {
		this.reidVaporPressure = reidVaporPressure;
	}
	public float getGrossBarrels() {
		return grossBarrels;
	}
	public void setGrossBarrels(float grossBarrels) {
		this.grossBarrels = grossBarrels;
	}
	public float getNetBarrels() {
		return netBarrels;
	}
	public void setNetBarrels(float netBarrels) {
		this.netBarrels = netBarrels;
	}
	public float getNetWaterBarrels() {
		return netWaterBarrels;
	}
	public void setNetWaterBarrels(float netWaterBarrels) {
		this.netWaterBarrels = netWaterBarrels;
	}
	public float getAllocatedOilBarrels() {
		return allocatedOilBarrels;
	}
	public void setAllocatedOilBarrels(float allocatedOilBarrels) {
		this.allocatedOilBarrels = allocatedOilBarrels;
	}
	public float getAllocatedWaterBarrels() {
		return allocatedWaterBarrels;
	}
	public void setAllocatedWaterBarrels(float allocatedWaterBarrels) {
		this.allocatedWaterBarrels = allocatedWaterBarrels;
	}
	public int getHauler() {
		return hauler;
	}
	public void setHauler(int hauler) {
		this.hauler = hauler;
	}
	public int getHaulerLoc() {
		return haulerLoc;
	}
	public void setHaulerLoc(int haulerLoc) {
		this.haulerLoc = haulerLoc;
	}
	public String getHaulerMeterID() {
		return haulerMeterID;
	}
	public void setHaulerMeterID(String haulerMeterID) {
		this.haulerMeterID = haulerMeterID;
	}
	public float getHaulerReportedBarrels() {
		return haulerReportedBarrels;
	}
	public void setHaulerReportedBarrels(float haulerReportedBarrels) {
		this.haulerReportedBarrels = haulerReportedBarrels;
	}
	public float getHaulerReportedNetBarrels() {
		return haulerReportedNetBarrels;
	}
	public void setHaulerReportedNetBarrels(float haulerReportedNetBarrels) {
		this.haulerReportedNetBarrels = haulerReportedNetBarrels;
	}
	public int getUseHaulerBarrelsFlag() {
		return useHaulerBarrelsFlag;
	}
	public void setUseHaulerBarrelsFlag(int useHaulerBarrelsFlag) {
		this.useHaulerBarrelsFlag = useHaulerBarrelsFlag;
	}
	public int getPurchaser() {
		return purchaser;
	}
	public void setPurchaser(int purchaser) {
		this.purchaser = purchaser;
	}
	public int getPurchaserLoc() {
		return purchaserLoc;
	}
	public void setPurchaserLoc(int purchaserLoc) {
		this.purchaserLoc = purchaserLoc;
	}
	public String getPurchaserMeterID() {
		return purchaserMeterID;
	}
	public void setPurchaserMeterID(String purchaserMeterID) {
		this.purchaserMeterID = purchaserMeterID;
	}
	public int getUnitsFlag() {
		return unitsFlag;
	}
	public void setUnitsFlag(int unitsFlag) {
		this.unitsFlag = unitsFlag;
	}
	public int getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public int getBackgroundTaskFlag() {
		return backgroundTaskFlag;
	}
	public void setBackgroundTaskFlag(int backgroundTaskFlag) {
		this.backgroundTaskFlag = backgroundTaskFlag;
	}
	public int getLastTransmission() {
		return lastTransmission;
	}
	public void setLastTransmission(int lastTransmission) {
		this.lastTransmission = lastTransmission;
	}
	public String getLastLoadTime() {
		return lastLoadTime;
	}
	public void setLastLoadTime(String lastLoadTime) {
		this.lastLoadTime = lastLoadTime;
	}
	public int getTransmitFlag() {
		return transmitFlag;
	}
	public void setTransmitFlag(int transmitFlag) {
		this.transmitFlag = transmitFlag;
	}
	public String getRunNo() {
		return runNo;
	}
	public void setRunNo(String runNo) {
		this.runNo = runNo;
	}
	public float getAdjustedGross() {
		return adjustedGross;
	}
	public void setAdjustedGross(float adjustedGross) {
		this.adjustedGross = adjustedGross;
	}
	public float getAdjustedNet() {
		return adjustedNet;
	}
	public void setAdjustedNet(float adjustedNet) {
		this.adjustedNet = adjustedNet;
	}
	public float getWaterCarryOver() {
		return waterCarryOver;
	}
	public void setWaterCarryOver(float waterCarryOver) {
		this.waterCarryOver = waterCarryOver;
	}
	public float getGasBlowBy() {
		return gasBlowBy;
	}
	public void setGasBlowBy(float gasBlowBy) {
		this.gasBlowBy = gasBlowBy;
	}
	public float getMeterMalfunction() {
		return meterMalfunction;
	}
	public void setMeterMalfunction(float meterMalfunction) {
		this.meterMalfunction = meterMalfunction;
	}
	public int getTemperatureCompensation() {
		return temperatureCompensation;
	}
	public void setTemperatureCompensation(int temperatureCompensation) {
		this.temperatureCompensation = temperatureCompensation;
	}
	public int getMeterFactor() {
		return meterFactor;
	}
	public void setMeterFactor(int meterFactor) {
		this.meterFactor = meterFactor;
	}
	public int getPsiFactor() {
		return psiFactor;
	}
	public void setPsiFactor(int psiFactor) {
		this.psiFactor = psiFactor;
	}
	public float getLinePressure() {
		return linePressure;
	}
	public void setLinePressure(float linePressure) {
		this.linePressure = linePressure;
	}
	public String getPressureFactor() {
		return pressureFactor;
	}
	public void setPressureFactor(String pressureFactor) {
		this.pressureFactor = pressureFactor;
	}
	public float getLineTemperature() {
		return lineTemperature;
	}
	public void setLineTemperature(float lineTemperature) {
		this.lineTemperature = lineTemperature;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getbLogicTimeStamp() {
		return bLogicTimeStamp;
	}
	public void setbLogicTimeStamp(String bLogicTimeStamp) {
		this.bLogicTimeStamp = bLogicTimeStamp;
	}
	public String getAllocationTimeStamp() {
		return allocationTimeStamp;
	}
	public void setAllocationTimeStamp(String allocationTimeStamp) {
		this.allocationTimeStamp = allocationTimeStamp;
	}
	public String getUserTimeStamp() {
		return userTimeStamp;
	}
	public void setUserTimeStamp(String userTimeStamp) {
		this.userTimeStamp = userTimeStamp;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getPurchaserStatementID() {
		return purchaserStatementID;
	}
	public void setPurchaserStatementID(int purchaserStatementID) {
		this.purchaserStatementID = purchaserStatementID;
	}
	public int getHaulerStatementID() {
		return haulerStatementID;
	}
	public void setHaulerStatementID(int haulerStatementID) {
		this.haulerStatementID = haulerStatementID;
	}
	public float getGrossNGL() {
		return grossNGL;
	}
	public void setGrossNGL(float grossNGL) {
		this.grossNGL = grossNGL;
	}
	public float getNetNGL() {
		return netNGL;
	}
	public void setNetNGL(float netNGL) {
		this.netNGL = netNGL;
	}
	public float getAllocatedNGL() {
		return allocatedNGL;
	}
	public void setAllocatedNGL(float allocatedNGL) {
		this.allocatedNGL = allocatedNGL;
	}
	public int getPurchaserStatementSeq() {
		return purchaserStatementSeq;
	}
	public void setPurchaserStatementSeq(int purchaserStatementSeq) {
		this.purchaserStatementSeq = purchaserStatementSeq;
	}
	public int getHaulerStatementSeq() {
		return haulerStatementSeq;
	}
	public void setHaulerStatementSeq(int haulerStatementSeq) {
		this.haulerStatementSeq = haulerStatementSeq;
	}
	public int getCalculationStatusFlag() {
		return calculationStatusFlag;
	}
	public void setCalculationStatusFlag(int calculationStatusFlag) {
		this.calculationStatusFlag = calculationStatusFlag;
	}
	public String getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(String recordDate) {
		this.recordDate = recordDate;
	}
	public String getRunTicketDate() {
		return runTicketDate;
	}
	public void setRunTicketDate(String runTicketDate) {
		this.runTicketDate = runTicketDate;
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
	public String getHaulerStatementDate() {
		return haulerStatementDate;
	}
	public void setHaulerStatementDate(String haulerStatementDate) {
		this.haulerStatementDate = haulerStatementDate;
	}
	public String getLastLoadDate() {
		return lastLoadDate;
	}
	public void setLastLoadDate(String lastLoadDate) {
		this.lastLoadDate = lastLoadDate;
	}
	public String getDateInstalled() {
		return dateInstalled;
	}
	public void setDateInstalled(String dateInstalled) {
		this.dateInstalled = dateInstalled;
	}
	public String getDateInService() {
		return dateInService;
	}
	public void setDateInService(String dateInService) {
		this.dateInService = dateInService;
	}
	public String getSampleDate() {
		return sampleDate;
	}
	public void setSampleDate(String sampleDate) {
		this.sampleDate = sampleDate;
	}
	public String getDateProved() {
		return dateProved;
	}
	public void setDateProved(String dateProved) {
		this.dateProved = dateProved;
	}
	public String getbLogicDateStamp() {
		return bLogicDateStamp;
	}
	public void setbLogicDateStamp(String bLogicDateStamp) {
		this.bLogicDateStamp = bLogicDateStamp;
	}
	public String getAllocationDateStamp() {
		return allocationDateStamp;
	}
	public void setAllocationDateStamp(String allocationDateStamp) {
		this.allocationDateStamp = allocationDateStamp;
	}
	public String getUserDateStamp() {
		return userDateStamp;
	}
	public void setUserDateStamp(String userDateStamp) {
		this.userDateStamp = userDateStamp;
	}
	
}
