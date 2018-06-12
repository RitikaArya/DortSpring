package com.murphy.appdownload.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.murphy.appdownload.dao.MeterRunTicketDao;
import com.murphy.appdownload.dto.MeterRunTicketDto;
import com.murphy.appdownload.dto.ResponseMessage;
import com.murphy.appdownload.dto.UIResponseDto;
import com.murphy.appdownload.entity.MeterRunTicketDo;
import com.murphy.appdownload.service.interfaces.MeterRunTicketLocal;
import com.murphy.appdownload.util.DortConstant;
import com.murphy.appdownload.util.DowntimeServicesUtil;

@Service
public class MeterRunTicketService implements MeterRunTicketLocal {

	private static final Logger logger = LoggerFactory.getLogger(MeterRunTicketService.class);

	@Override
	public UIResponseDto insertRecordinDB(MeterRunTicketDto meterRunTicketDto) {
		logger.info("[insertRecordinDB] : INFO- Service Started");
		UIResponseDto uiResponseDto = new UIResponseDto();
		ResponseMessage responseMessage = new ResponseMessage();
		MeterRunTicketDao meterRunTicketDao = null;
		if (meterRunTicketDto != null && meterRunTicketDto.getMerrickId() != null) {
			try {
				DowntimeServicesUtil.setupSOCKS();
			} catch (Exception e) {
				logger.error("[fetchDataFromDispositionCodeTb] : ERROR- Exception while setting SOCKS " + e);
			}

				meterRunTicketDao = new MeterRunTicketDao();
				try {
					logger.info("[insertRecordinDB] : INFO- Connection to DB successful");

					meterRunTicketDao.insertRecordinDB(convertDowntimeCaptureDtoToDo(meterRunTicketDto));
					responseMessage.setMessage("Successful");
					responseMessage.setStatus("true");
				} catch (Exception e) {
					logger.error(
							"[insertRecordinDB] : ERROR- Exception while interacting with database " + e);
					responseMessage.setMessage("Server Internal Error. Facing difficulties interacting to DB.");
					responseMessage.setStatus("false");
				} finally {
					try {
						DowntimeServicesUtil.unSetupSOCKS();
					} catch (Exception e) {
						logger.error("[insertRecordinDB] : ERROR- Exception while unsetting SOCKS " + e);
					}
				}
			} else {
				responseMessage.setMessage("Connection to Database is not possible");
				responseMessage.setStatus("false");
			}
		
		logger.info("[insertRecordinDB] : uiResponseDto " + uiResponseDto);
		uiResponseDto.setResponseMessage(responseMessage);
		return uiResponseDto;
	}
	
	private MeterRunTicketDo convertDowntimeCaptureDtoToDo(MeterRunTicketDto meterRunTicketDto) {
		MeterRunTicketDo meterRunTicketDo = new MeterRunTicketDo();
		meterRunTicketDo.setActualEstimatedFlag(DortConstant.ACTUAL_ESTIMATED_FLAG);
		meterRunTicketDo.setActualGravity(meterRunTicketDto.getActualGravity());
		meterRunTicketDo.setAdjustedGross(DortConstant.ADJUSTED_GROSS);
		meterRunTicketDo.setAdjustedNet(DortConstant.ADJUSTED_NET);
		meterRunTicketDo.setAllocatedNGL(DortConstant.ALLOCATED_NGL);
		meterRunTicketDo.setAllocatedOilBarrels(DortConstant.ALLOCATED_OIL_BARRELS);
		meterRunTicketDo.setAllocatedWaterBarrels(DortConstant.ALLOCATED_WATER_BARRELS);
		meterRunTicketDo.setAllocationDateStamp(DortConstant.ALLOCATION_DATESTAMP);
		meterRunTicketDo.setAllocationTimeStamp(DortConstant.ALLOCATION_TIMESTAMP);
		meterRunTicketDo.setBackgroundTaskFlag(DortConstant.BACKGROUND_TASKFLAG);
		meterRunTicketDo.setbLogicDateStamp(DortConstant.BLOGIC_DATESTAMP);
		meterRunTicketDo.setbLogicTimeStamp(DortConstant.BLOGIC_TIMESTAMP);
		meterRunTicketDo.setbSAndW(meterRunTicketDto.getBsandW());
		meterRunTicketDo.setCalculationStatusFlag(DortConstant.CALCULATION_STATUSFLAG);
		meterRunTicketDo.setCloseOdometer(meterRunTicketDto.getCloseOdometer());
		meterRunTicketDo.setCloseTemperature(meterRunTicketDto.getCloseTemperature());
		meterRunTicketDo.setComments(DortConstant.COMMENTS);
		meterRunTicketDo.setConvertedGravity(DortConstant.CONVERTED_GRAVITY);
		meterRunTicketDo.setDataSourceCode(DortConstant.DATA_SOURCECODE);
		meterRunTicketDo.setDateInService(DortConstant.DATE_INSERVICE);
		meterRunTicketDo.setDateInstalled(DortConstant.DATE_INSTALLED);
		meterRunTicketDo.setDateProved(DortConstant.DATE_PROVED);
		meterRunTicketDo.setDeleteFlag(DortConstant.DELETE_FLAG);
		meterRunTicketDo.setDestination(DortConstant.DESTINATION);
		meterRunTicketDo.setDestinationObjectId(DortConstant.DESTINATION_OBJECTID);
		meterRunTicketDo.setDestinationObjectType(DortConstant.DESTINATION_OBJECTTYPE);
		meterRunTicketDo.setDispositionCode(meterRunTicketDto.getDispositionCode());
		meterRunTicketDo.setEmulsionPercent(DortConstant.EMULSION_PERCENT);
		meterRunTicketDo.setFluidDisposition(DortConstant.FLUID_DISPOSITION);
		meterRunTicketDo.setGasBlowBy(DortConstant.GAS_BLOWBY);
		meterRunTicketDo.setGrossBarrels(meterRunTicketDto.getGrossBarrels());
		meterRunTicketDo.setGrossNGL(DortConstant.GROSS_NGL);
		meterRunTicketDo.setHauler(meterRunTicketDto.getHauler());
		meterRunTicketDo.setHaulerLoc(DortConstant.HAULER_LOC);
		meterRunTicketDo.setHaulerMeterID(DortConstant.HAULER_METERID);
		meterRunTicketDo.setHaulerReportedBarrels(DortConstant.HAULER_REPORTED_BARRELS);
		meterRunTicketDo.setHaulerReportedNetBarrels(DortConstant.HAULER_REPORTED_NETBARRELS);
		meterRunTicketDo.setHaulerStatementDate(meterRunTicketDto.getRunOpenDate());
		meterRunTicketDo.setHaulerStatementID(DortConstant.HAULER_STATEMENT_ID);
		meterRunTicketDo.setHaulerStatementSeq(DortConstant.HAULER_STATEMENT_SEQ);
		meterRunTicketDo.setLactCompressibilityFactor(meterRunTicketDto.getLactCompressibilityFactor());
		meterRunTicketDo.setLactDensityCorrection(DortConstant.LACT_DENSITY_CORRECTION);
		meterRunTicketDo.setLactMeterFactor(meterRunTicketDto.getLactMeterFactor());
		meterRunTicketDo.setLastLoadDate(DortConstant.LAST_LOAD_DATE);
		meterRunTicketDo.setLastLoadTime(DortConstant.LAST_LOAD_TIME);
		meterRunTicketDo.setLastTransmission(DortConstant.LAST_TRANSMISSION);
		meterRunTicketDo.setLinePressure(DortConstant.LINE_PRESSURE);
		meterRunTicketDo.setLineTemperature(DortConstant.LINE_TEMPERATURE);
		meterRunTicketDo.setMerrickId(meterRunTicketDto.getMerrickId());
		meterRunTicketDo.setMeterFactor(DortConstant.METER_FACTOR);
		meterRunTicketDo.setMeterMalfunction(DortConstant.METER_MALFUNCTION);
		meterRunTicketDo.setNetBarrels(meterRunTicketDto.getNetBarrels());
		meterRunTicketDo.setNetNGL(DortConstant.NET_NGL);
		meterRunTicketDo.setNetWaterBarrels(DortConstant.NET_WATER_BARRELS);
		meterRunTicketDo.setObservedTemperature(meterRunTicketDto.getObservedTemperature());
		meterRunTicketDo.setOpenOdometer(meterRunTicketDto.getOpenOdometer());
		meterRunTicketDo.setOpenTemperature(meterRunTicketDto.getOpenTemperature());
		meterRunTicketDo.setOriginationObjectId(DortConstant.ORIGINATION_OBJECTID);
		meterRunTicketDo.setOriginationObjectType(DortConstant.ORIGINATION_OBJECTTYPE);
		meterRunTicketDo.setPressureFactor(DortConstant.PRESSURE_FACTOR);
		meterRunTicketDo.setProductCode(meterRunTicketDto.getProductCode());
		meterRunTicketDo.setProductType(DortConstant.PRODUCT_TYPE);
		meterRunTicketDo.setPsiFactor(DortConstant.PSI_FACTOR);
		meterRunTicketDo.setPurchaser(meterRunTicketDto.getPurchaser());
		meterRunTicketDo.setPurchaserLoc(DortConstant.PURCHASER_LOC);
		meterRunTicketDo.setPurchaserMeterID(DortConstant.PURCHASER_METERID);
		meterRunTicketDo.setPurchaserStatementID(DortConstant.PURCHASER_STATEMENTID);
		meterRunTicketDo.setPurchaserStatementSeq(DortConstant.PURCHASER_STATEMENTSEQ);
		meterRunTicketDo.setRecordDate(meterRunTicketDto.getRunOpenDate());
		meterRunTicketDo.setReidVaporPressure(DortConstant.REID_VAPOR_PRESSURE);
		meterRunTicketDo.setRunCloseDate(meterRunTicketDto.getRunCloseDate());
		meterRunTicketDo.setRunCloseTime(meterRunTicketDto.getRunCloseTime());
		meterRunTicketDo.setRunNo(DortConstant.RUN_NO);
		meterRunTicketDo.setRunOpenDate(meterRunTicketDto.getRunOpenDate());
		meterRunTicketDo.setRunOpenTime(meterRunTicketDto.getRunOpenTime());
		meterRunTicketDo.setRunOrDispositionFlag(DortConstant.RUN_OR_DISPOSITION_FLAG);
		meterRunTicketDo.setRunTicketDate(meterRunTicketDto.getRunOpenDate());
		meterRunTicketDo.setRunTicketNumber(meterRunTicketDto.getRunTicketNumber());
		meterRunTicketDo.setSaltContentPPM(DortConstant.SALT_CONTENT_PPM);
		meterRunTicketDo.setSampleDate(DortConstant.SAMPLE_DATE);
		meterRunTicketDo.setSourceID(DortConstant.SOURCE_ID);
		meterRunTicketDo.setSourceType(DortConstant.SOURCE_TYPE);
		meterRunTicketDo.setSulfurContentPPM(DortConstant.SULFUR_CONTENT_PPM);
		meterRunTicketDo.setTemperatureCompensation(DortConstant.TEMPERATURE_COMPENSATION);
		meterRunTicketDo.setTransmitFlag(DortConstant.TRANSMIT_FLAG);
		meterRunTicketDo.setUnitsFlag(DortConstant.UNITS_FLAG);
		meterRunTicketDo.setUseHaulerBarrelsFlag(DortConstant.USE_HAULER_BARRELSFLAG);
		meterRunTicketDo.setUserDateStamp(DortConstant.USER_DATESTAMP);
		meterRunTicketDo.setUserID(DortConstant.USER_ID);
		meterRunTicketDo.setUserTimeStamp(DortConstant.USER_TIMESTAMP);
		meterRunTicketDo.setWaterCarryOver(DortConstant.WATER_CARRY_OVER);
		meterRunTicketDo.setWaterVaporContentPPM(DortConstant.WATERVAPOR_CONTENT_PPM);
		meterRunTicketDo.setWaxPercent(DortConstant.WAX_PERCENT);
		return meterRunTicketDo;
	}
}
