package com.murphy.appdownload.dao;


import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.murphy.appdownload.dto.BaseDto;
import com.murphy.appdownload.entity.BaseDo;
import com.murphy.appdownload.entity.MeterRunTicketDo;
import com.murphy.appdownload.exception.ExecutionFault;
import com.murphy.appdownload.exception.InvalidInputFault;
import com.murphy.appdownload.exception.NoResultFault;

@Repository("MeterRunTicketDao")
@Transactional
public class MeterRunTicketDao extends BaseDao<BaseDo, BaseDto>{

	private static final Logger logger = LoggerFactory.getLogger(MeterRunTicketDao.class);

	public MeterRunTicketDao() {
		super();
	}

	public void insertRecordinDB(MeterRunTicketDo meterRunTicketDo) throws Exception {
		
		try {
			String queryString = "INSERT dbo.MeterRunTicketTb (MerrickID, RecordDate, RunTicketNumber, DispositionCode, RunOrDispositionFlag, FluidDisposition, Destination, DestinationObjectId" + 
					", DestinationObjectType, OriginationObjectId, OriginationObjectType, SourceID, SourceType, ProductCode, ProductType, DataSourceCode, ActualEstimatedFlag" + 
					", BSAndW, EmulsionPercent, WaxPercent, SaltContentPPM, SulfurContentPPM, WaterVaporContentPPM, RunTicketDate, RunOpenDate, RunOpenTime, RunCloseDate" + 
					", RunCloseTime, OpenOdometer, CloseOdometer, LactMeterFactor, LactCompressibilityFactor, LactDensityCorrection, OpenTemperature, CloseTemperature" + 
					", ObservedTemperature, ActualGravity, ConvertedGravity, ReidVaporPressure, GrossBarrels, NetBarrels, NetWaterBarrels, AllocatedOilBarrels, AllocatedWaterBarrels" + 
					", Hauler, HaulerLoc, HaulerMeterID, HaulerReportedBarrels, HaulerReportedNetBarrels, UseHaulerBarrelsFlag, HaulerStatementDate, Purchaser, PurchaserLoc" + 
					", PurchaserMeterID, UnitsFlag, DeleteFlag, BackgroundTaskFlag, LastTransmission, LastLoadDate, LastLoadTime, TransmitFlag, RunNo, DateInstalled, DateInService" + 
					", SampleDate, DateProved, AdjustedGross, AdjustedNet, WaterCarryOver, GasBlowBy, MeterMalfunction, TemperatureCompensation, MeterFactor, PSIFactor, LinePressure" + 
					", PressureFactor, LineTemperature, Comments, BLogicDateStamp, BLogicTimeStamp, AllocationDateStamp, AllocationTimeStamp, UserDateStamp, UserTimeStamp" + 
					", UserID, PurchaserStatementID, HaulerStatementID, GrossNGL, NetNGL, AllocatedNGL, PurchaserStatementSeq, HaulerStatementSeq, CalculationStatusFlag)" + 
					" VALUES (?, ?, ?, ?, ?, ?, ?, ?" +         //1-8
					", ?, ?, ?, ?, ?, ?, ?, ?, ?" +             //9-17
					",?, ?, ?, ?, ?, ?, ?, ?, ?, ?"+            //18-27
					", ?, ?, ?, ?, ?, ?, ?, ?" +				//28-35
					", ?, ?, ?, ?, ?, ?, ?, ?, ?" +				//36-44
					", ?, ?, ?, ?, ?, ?, ?, ?, ?"+				//45-53
					", ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?"+		//54-64
					", ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?"+		//65-75
					", ?, ?, ?, ?, ?, ?, ?, ?, ?,"+				//76-84
					"?, ?, ?, ?, ?, ?, ?, ?, ?);" ;				//85-93
					
			Query query = this.getSession().createSQLQuery(queryString);
			
			query.setParameter(1, meterRunTicketDo.getMerrickId());
			query.setParameter(2, meterRunTicketDo.getRecordDate());
			query.setParameter(3, meterRunTicketDo.getRunTicketNumber());
			query.setParameter(4, meterRunTicketDo.getDispositionCode());
			query.setParameter(5, meterRunTicketDo.getRunOrDispositionFlag());
			query.setParameter(6, meterRunTicketDo.getFluidDisposition());
			query.setParameter(7, meterRunTicketDo.getDestination());
			query.setParameter(8, meterRunTicketDo.getDestinationObjectId());
			query.setParameter(9, meterRunTicketDo.getDestinationObjectType());
			query.setParameter(10, meterRunTicketDo.getOriginationObjectId() );
			query.setParameter(11, meterRunTicketDo.getOriginationObjectType());
			query.setParameter(12, meterRunTicketDo.getSourceID());
			query.setParameter(13, meterRunTicketDo.getSourceType());
			query.setParameter(14, meterRunTicketDo.getProductCode());
			query.setParameter(15, meterRunTicketDo.getProductType());
			query.setParameter(16, meterRunTicketDo.getDataSourceCode());
			query.setParameter(17, meterRunTicketDo.getActualEstimatedFlag());
			query.setParameter(18, meterRunTicketDo.getbSAndW());
			query.setParameter(19, meterRunTicketDo.getEmulsionPercent());
			query.setParameter(20, meterRunTicketDo.getWaxPercent());
			query.setParameter(21, meterRunTicketDo.getSaltContentPPM());
			query.setParameter(22, meterRunTicketDo.getSulfurContentPPM());
			query.setParameter(23, meterRunTicketDo.getWaterVaporContentPPM());
			query.setParameter(24, meterRunTicketDo.getRunTicketDate());
			query.setParameter(25, meterRunTicketDo.getRunOpenDate());
			query.setParameter(26, meterRunTicketDo.getRunOpenTime());
			query.setParameter(27, meterRunTicketDo.getRunCloseDate());
			query.setParameter(28, meterRunTicketDo.getRunCloseTime());
			query.setParameter(29, meterRunTicketDo.getOpenOdometer());
			query.setParameter(30, meterRunTicketDo.getCloseOdometer());
			query.setParameter(31, meterRunTicketDo.getLactMeterFactor());
			query.setParameter(32, meterRunTicketDo.getLactCompressibilityFactor());
			query.setParameter(33, meterRunTicketDo.getLactDensityCorrection());
			query.setParameter(34, meterRunTicketDo.getOpenTemperature());
			query.setParameter(35, meterRunTicketDo.getCloseTemperature());
			query.setParameter(36, meterRunTicketDo.getObservedTemperature());
			query.setParameter(37, meterRunTicketDo.getActualGravity());
			query.setParameter(38, meterRunTicketDo.getConvertedGravity());
			query.setParameter(39, meterRunTicketDo.getReidVaporPressure());
			query.setParameter(40, meterRunTicketDo.getGrossBarrels());
			query.setParameter(41, meterRunTicketDo.getNetBarrels());
			query.setParameter(42, meterRunTicketDo.getNetWaterBarrels());
			query.setParameter(43, meterRunTicketDo.getAllocatedOilBarrels());
			query.setParameter(44, meterRunTicketDo.getAllocatedWaterBarrels());
			query.setParameter(45, meterRunTicketDo.getHauler());
			query.setParameter(46, meterRunTicketDo.getHaulerLoc());
			query.setParameter(47, meterRunTicketDo.getHaulerMeterID());
			query.setParameter(48, meterRunTicketDo.getHaulerReportedBarrels());
			query.setParameter(49, meterRunTicketDo.getHaulerReportedNetBarrels());
			query.setParameter(50, meterRunTicketDo.getUseHaulerBarrelsFlag());
			query.setParameter(51, meterRunTicketDo.getHaulerStatementDate());
			query.setParameter(52, meterRunTicketDo.getPurchaser());
			query.setParameter(53, meterRunTicketDo.getPurchaserLoc());
			query.setParameter(54, meterRunTicketDo.getPurchaserMeterID());
			query.setParameter(55, meterRunTicketDo.getUnitsFlag());
			query.setParameter(56, meterRunTicketDo.getDeleteFlag());
			query.setParameter(57, meterRunTicketDo.getBackgroundTaskFlag());
			query.setParameter(58, meterRunTicketDo.getLastTransmission());
			query.setParameter(59, meterRunTicketDo.getLastLoadDate());
			query.setParameter(60, meterRunTicketDo.getLastLoadTime());
			query.setParameter(61, meterRunTicketDo.getTransmitFlag());
			query.setParameter(62, meterRunTicketDo.getRunNo());
			query.setParameter(63, meterRunTicketDo.getDateInstalled());
			query.setParameter(64, meterRunTicketDo.getDateInService());
			query.setParameter(65, meterRunTicketDo.getSampleDate());
			query.setParameter(66, meterRunTicketDo.getDateProved());
			query.setParameter(67, meterRunTicketDo.getAdjustedGross());
			query.setParameter(68, meterRunTicketDo.getAdjustedNet());
			query.setParameter(69, meterRunTicketDo.getWaterCarryOver());
			query.setParameter(70, meterRunTicketDo.getGasBlowBy());
			query.setParameter(71, meterRunTicketDo.getMeterMalfunction());
			query.setParameter(72, meterRunTicketDo.getTemperatureCompensation());
			query.setParameter(73, meterRunTicketDo.getMeterFactor());
			query.setParameter(74, meterRunTicketDo.getPsiFactor());
			query.setParameter(75, meterRunTicketDo.getLinePressure());
			query.setParameter(76, meterRunTicketDo.getPressureFactor());
			query.setParameter(77, meterRunTicketDo.getLineTemperature());
			query.setParameter(78, meterRunTicketDo.getComments());
			query.setParameter(79, meterRunTicketDo.getbLogicDateStamp());
			query.setParameter(80, meterRunTicketDo.getbLogicTimeStamp());
			query.setParameter(81, meterRunTicketDo.getAllocationDateStamp());
			query.setParameter(82, meterRunTicketDo.getAllocationTimeStamp());
			query.setParameter(83, meterRunTicketDo.getUserDateStamp());
			query.setParameter(84, meterRunTicketDo.getUserTimeStamp());
			query.setParameter(85, meterRunTicketDo.getUserID());
			query.setParameter(86, meterRunTicketDo.getPurchaserStatementID());
			query.setParameter(87, meterRunTicketDo.getHaulerStatementID());
			query.setParameter(88, meterRunTicketDo.getGrossNGL());
			query.setParameter(89, meterRunTicketDo.getNetNGL());
			query.setParameter(90, meterRunTicketDo.getAllocatedNGL());
			query.setParameter(91, meterRunTicketDo.getPurchaserStatementSeq());
			query.setParameter(92, meterRunTicketDo.getHaulerStatementSeq());
			query.setParameter(93, meterRunTicketDo.getCalculationStatusFlag());
			
			int insertedRowCount = query.executeUpdate();

			if (insertedRowCount > 0) {
				logger.error("[insertRecordinDB] : INFO - Record inserted succesfully");
			}

		} catch (Exception e) {
			logger.error("[insertRecordinDB] : ERROR- Exception while Inserting data in database " + e);
			throw e;
		} 
	}

	@Override
	protected BaseDo importDto(BaseDto fromDto) throws InvalidInputFault, ExecutionFault, NoResultFault {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected BaseDto exportDto(BaseDo entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
