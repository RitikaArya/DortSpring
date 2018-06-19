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
			
			query.setParameter(0, meterRunTicketDo.getMerrickId());
			query.setParameter(1, meterRunTicketDo.getRecordDate());
			query.setParameter(2, meterRunTicketDo.getRunTicketNumber());
			query.setParameter(3, meterRunTicketDo.getDispositionCode());
			query.setParameter(4, meterRunTicketDo.getRunOrDispositionFlag());
			query.setParameter(5, meterRunTicketDo.getFluidDisposition());
			query.setParameter(6, meterRunTicketDo.getDestination());
			query.setParameter(7, meterRunTicketDo.getDestinationObjectId());
			query.setParameter(8, meterRunTicketDo.getDestinationObjectType());
			query.setParameter(9, meterRunTicketDo.getOriginationObjectId() );
			query.setParameter(10, meterRunTicketDo.getOriginationObjectType());
			query.setParameter(11, meterRunTicketDo.getSourceID());
			query.setParameter(12, meterRunTicketDo.getSourceType());
			query.setParameter(13, meterRunTicketDo.getProductCode());
			query.setParameter(14, meterRunTicketDo.getProductType());
			query.setParameter(15, meterRunTicketDo.getDataSourceCode());
			query.setParameter(16, meterRunTicketDo.getActualEstimatedFlag());
			query.setParameter(17, meterRunTicketDo.getbSAndW());
			query.setParameter(18, meterRunTicketDo.getEmulsionPercent());
			query.setParameter(29, meterRunTicketDo.getWaxPercent());
			query.setParameter(20, meterRunTicketDo.getSaltContentPPM());
			query.setParameter(21, meterRunTicketDo.getSulfurContentPPM());
			query.setParameter(22, meterRunTicketDo.getWaterVaporContentPPM());
			query.setParameter(23, meterRunTicketDo.getRunTicketDate());
			query.setParameter(24, meterRunTicketDo.getRunOpenDate());
			query.setParameter(25, meterRunTicketDo.getRunOpenTime());
			query.setParameter(26, meterRunTicketDo.getRunCloseDate());
			query.setParameter(27, meterRunTicketDo.getRunCloseTime());
			query.setParameter(28, meterRunTicketDo.getOpenOdometer());
			query.setParameter(29, meterRunTicketDo.getCloseOdometer());
			query.setParameter(30, meterRunTicketDo.getLactMeterFactor());
			query.setParameter(31, meterRunTicketDo.getLactCompressibilityFactor());
			query.setParameter(32, meterRunTicketDo.getLactDensityCorrection());
			query.setParameter(33, meterRunTicketDo.getOpenTemperature());
			query.setParameter(34, meterRunTicketDo.getCloseTemperature());
			query.setParameter(35, meterRunTicketDo.getObservedTemperature());
			query.setParameter(36, meterRunTicketDo.getActualGravity());
			query.setParameter(37, meterRunTicketDo.getConvertedGravity());
			query.setParameter(38, meterRunTicketDo.getReidVaporPressure());
			query.setParameter(39, meterRunTicketDo.getGrossBarrels());
			query.setParameter(40, meterRunTicketDo.getNetBarrels());
			query.setParameter(41, meterRunTicketDo.getNetWaterBarrels());
			query.setParameter(42, meterRunTicketDo.getAllocatedOilBarrels());
			query.setParameter(43, meterRunTicketDo.getAllocatedWaterBarrels());
			query.setParameter(44, meterRunTicketDo.getHauler());
			query.setParameter(45, meterRunTicketDo.getHaulerLoc());
			query.setParameter(46, meterRunTicketDo.getHaulerMeterID());
			query.setParameter(47, meterRunTicketDo.getHaulerReportedBarrels());
			query.setParameter(48, meterRunTicketDo.getHaulerReportedNetBarrels());
			query.setParameter(49, meterRunTicketDo.getUseHaulerBarrelsFlag());
			query.setParameter(50, meterRunTicketDo.getHaulerStatementDate());
			query.setParameter(51, meterRunTicketDo.getPurchaser());
			query.setParameter(52, meterRunTicketDo.getPurchaserLoc());
			query.setParameter(53, meterRunTicketDo.getPurchaserMeterID());
			query.setParameter(54, meterRunTicketDo.getUnitsFlag());
			query.setParameter(55, meterRunTicketDo.getDeleteFlag());
			query.setParameter(56, meterRunTicketDo.getBackgroundTaskFlag());
			query.setParameter(57, meterRunTicketDo.getLastTransmission());
			query.setParameter(58, meterRunTicketDo.getLastLoadDate());
			query.setParameter(59, meterRunTicketDo.getLastLoadTime());
			query.setParameter(60, meterRunTicketDo.getTransmitFlag());
			query.setParameter(61, meterRunTicketDo.getRunNo());
			query.setParameter(62, meterRunTicketDo.getDateInstalled());
			query.setParameter(63, meterRunTicketDo.getDateInService());
			query.setParameter(64, meterRunTicketDo.getSampleDate());
			query.setParameter(65, meterRunTicketDo.getDateProved());
			query.setParameter(66, meterRunTicketDo.getAdjustedGross());
			query.setParameter(67, meterRunTicketDo.getAdjustedNet());
			query.setParameter(68, meterRunTicketDo.getWaterCarryOver());
			query.setParameter(69, meterRunTicketDo.getGasBlowBy());
			query.setParameter(70, meterRunTicketDo.getMeterMalfunction());
			query.setParameter(71, meterRunTicketDo.getTemperatureCompensation());
			query.setParameter(72, meterRunTicketDo.getMeterFactor());
			query.setParameter(73, meterRunTicketDo.getPsiFactor());
			query.setParameter(74, meterRunTicketDo.getLinePressure());
			query.setParameter(75, meterRunTicketDo.getPressureFactor());
			query.setParameter(76, meterRunTicketDo.getLineTemperature());
			query.setParameter(77, meterRunTicketDo.getComments());
			query.setParameter(78, meterRunTicketDo.getbLogicDateStamp());
			query.setParameter(79, meterRunTicketDo.getbLogicTimeStamp());
			query.setParameter(80, meterRunTicketDo.getAllocationDateStamp());
			query.setParameter(81, meterRunTicketDo.getAllocationTimeStamp());
			query.setParameter(82, meterRunTicketDo.getUserDateStamp());
			query.setParameter(83, meterRunTicketDo.getUserTimeStamp());
			query.setParameter(84, meterRunTicketDo.getUserID());
			query.setParameter(85, meterRunTicketDo.getPurchaserStatementID());
			query.setParameter(86, meterRunTicketDo.getHaulerStatementID());
			query.setParameter(87, meterRunTicketDo.getGrossNGL());
			query.setParameter(88, meterRunTicketDo.getNetNGL());
			query.setParameter(89, meterRunTicketDo.getAllocatedNGL());
			query.setParameter(90, meterRunTicketDo.getPurchaserStatementSeq());
			query.setParameter(91, meterRunTicketDo.getHaulerStatementSeq());
			query.setParameter(92, meterRunTicketDo.getCalculationStatusFlag());
			
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
