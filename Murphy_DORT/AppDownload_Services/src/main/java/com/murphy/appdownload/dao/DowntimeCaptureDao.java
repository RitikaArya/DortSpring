package com.murphy.appdownload.dao;

import java.util.List;

import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.murphy.appdownload.dto.DowntimeCaptureDto;
import com.murphy.appdownload.entity.DowntimeCaptureDo;
import com.murphy.appdownload.exception.ExecutionFault;
import com.murphy.appdownload.exception.InvalidInputFault;
import com.murphy.appdownload.exception.NoResultFault;
import com.murphy.appdownload.util.ServicesUtil;

public class DowntimeCaptureDao extends BaseDao<DowntimeCaptureDo, DowntimeCaptureDto>{

	private static final Logger logger = LoggerFactory.getLogger(DowntimeCaptureDao.class);

	public DowntimeCaptureDao() {
		super();
	}

	public int fetchMerrickFromDB(String uwiId) throws Exception {
		Query query = this.getSession().createSQLQuery("SELECT MerrickID FROM DBO.CompletionTb WHERE UWI = :uwiId ");
		query.setParameter("uwiId", uwiId);
		return query.getFirstResult();
	}

	@SuppressWarnings("unchecked")
	public DowntimeCaptureDo getDataFromDB(int merrickId, String originalDateEntered) throws Exception {
		DowntimeCaptureDo downtimeCaptureDo = null;
		Query query = this.getSession().createSQLQuery("SELECT * FROM DBO.DowntimeReasonTb WHERE ObjectMerrickID = :merrickId AND OriginalDateEntered = :originalDateEntered ");
		query.setParameter("merrickId", merrickId);
		query.setParameter("originalDateEntered", originalDateEntered);
		
		List<Object[]> list = query.list();
		if(!ServicesUtil.isEmpty(list) && list.size() > 0) {
			downtimeCaptureDo = new DowntimeCaptureDo();
			Object[] object = list.get(0);
			downtimeCaptureDo.setMerrickId(ServicesUtil.isEmpty(object[0]) ? null : (Integer) object[0]);
			downtimeCaptureDo.setObjectType(ServicesUtil.isEmpty(object[1]) ? null : (Integer) object[1]);
			downtimeCaptureDo.setOriginalDateEntered(ServicesUtil.isEmpty(object[2]) ? null : (String) object[2]);
			downtimeCaptureDo.setOriginalTimeEntered(ServicesUtil.isEmpty(object[3]) ? null : (String) object[3]);
			downtimeCaptureDo.setDowntimeCode(ServicesUtil.isEmpty(object[4]) ? null : (Integer) object[4]);
			downtimeCaptureDo.setDowntimeHours(ServicesUtil.isEmpty(object[5]) ? null : (Integer) object[5]);
			downtimeCaptureDo.setStartDate(ServicesUtil.isEmpty(object[6]) ? null : (String) object[6]);
			downtimeCaptureDo.setEndDate(ServicesUtil.isEmpty(object[7]) ? null : (String) object[7]);
			downtimeCaptureDo.setStartTime(ServicesUtil.isEmpty(object[8]) ? null : (String) object[8]);
			downtimeCaptureDo.setEndTime(ServicesUtil.isEmpty(object[9]) ? null : (String) object[9]);
			downtimeCaptureDo.setDeleteFlag(ServicesUtil.isEmpty(object[10]) ? null : (Integer) object[10]);
			downtimeCaptureDo.setComments(ServicesUtil.isEmpty(object[11]) ? null : (String) object[11]);
			logger.error("[getDataFromDB] : INFO  - downtimeCaptureDo" + downtimeCaptureDo);
			
			return downtimeCaptureDo;
		}

		logger.error("[getDataFromDB] : INFO  - No record is present for merricId " + merrickId + " on date " + originalDateEntered);
		return downtimeCaptureDo;
	}

	public void insertDataInDB(DowntimeCaptureDo downtimeCaptureDo) throws Exception {
		Query query = this.getSession().createSQLQuery("INSERT INTO DBO.DowntimeReasonTb(ObjectMerrickID,ObjectType,OriginalDateEntered,OriginalTimeEntered,UpDownFlag,DateEntryFlag"
							+ ",DowntimeCode,DowntimeHours,RepairCosts,LostProduction,CalcDowntimeFlag,StartDate,EndDate,StartTime,EndTime,StartProductionDate"
							+ ",EndProductionDate,Comments,Reason,MessageSendFlag,DestinationPerson,RioDowntimeID,LastDayHoursDown,DeleteFlag,LastTransmission"
							+ ",LastLoadDate,LastLoadTime,TransmitFlag,DateTimeStamp,BLogicDateStamp,BLogicTimeStamp,UserDateStamp,UserTimeStamp,UserID) "
							+ "VALUES (?, ?,'" + downtimeCaptureDo.getOriginalDateEntered()
							+ "', ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?," + " ?, ?, ?, ?, ?, ?, ?)");
		
		query.setParameter(1, downtimeCaptureDo.getMerrickId());
		query.setParameter(2, downtimeCaptureDo.getObjectType());
		query.setParameter(3, downtimeCaptureDo.getOriginalTimeEntered());
		query.setParameter(4, downtimeCaptureDo.getUpDownFlag());
		query.setParameter(5, downtimeCaptureDo.getDateEntryFlag());
		query.setParameter(6, downtimeCaptureDo.getDowntimeCode());
		query.setParameter(7, downtimeCaptureDo.getDowntimeHours());
		query.setParameter(8, downtimeCaptureDo.getRepairCosts());
		query.setParameter(9, downtimeCaptureDo.getLostProduction());
		query.setParameter(10, downtimeCaptureDo.getCalCDowntimeFlag());
		logger.error("[insertDataInDB] : INFO - StartDate " + downtimeCaptureDo.getStartDate() + " EndDate " + downtimeCaptureDo.getEndDate());
		query.setParameter(11, downtimeCaptureDo.getStartDate());
		query.setParameter(12, downtimeCaptureDo.getEndDate());
		query.setParameter(13, downtimeCaptureDo.getStartTime());
		query.setParameter(14, downtimeCaptureDo.getEndTime());
		query.setParameter(15, downtimeCaptureDo.getStartProductionDate());
		query.setParameter(16, downtimeCaptureDo.getEndProductionDate());
		query.setParameter(17, downtimeCaptureDo.getComments());
		query.setParameter(18, downtimeCaptureDo.getReason());
		query.setParameter(19, downtimeCaptureDo.getMessageSendFlag());
		query.setParameter(20, downtimeCaptureDo.getDestinationPerson());
		query.setParameter(21, downtimeCaptureDo.getRioDowntimeId());
		query.setParameter(22, downtimeCaptureDo.getLastDayHoursDown());
		query.setParameter(23, downtimeCaptureDo.getDeleteFlag());
		query.setParameter(24, downtimeCaptureDo.getLastTransmission());
		query.setParameter(25, downtimeCaptureDo.getLastLoadDate());
		query.setParameter(26, downtimeCaptureDo.getLastLoadTime());
		query.setParameter(27, downtimeCaptureDo.getTransmitFlag());
		query.setParameter(28, downtimeCaptureDo.getDateTimeStamp());
		query.setParameter(29, downtimeCaptureDo.getbLogicDateStamp());
		query.setParameter(30, downtimeCaptureDo.getbLogicTimeStamp());
		query.setParameter(31, downtimeCaptureDo.getUserDateStamp());
		query.setParameter(32, downtimeCaptureDo.getUserTimeStamp());
		query.setParameter(33, downtimeCaptureDo.getUserId());
		
		int insertedRowCount = query.executeUpdate();
		
		if (insertedRowCount > 0) {
			logger.error("[insertDataInDB] : INFO - Record inserted succesfully");
		}
	}

	public void updateDataInDB(DowntimeCaptureDo downtimeCaptureDo) throws Exception {
		Query query = this.getSession().createSQLQuery("UPDATE DBO.DowntimeReasonTb SET DowntimeHours = ?, StartDate = ?, EndDate= ?, StartTime=? , EndTime=?, DowntimeCode=? , Comments=?"
							+ " WHERE ObjectMerrickID = ? AND OriginalDateEntered= ?");
		
		query.setParameter(1, downtimeCaptureDo.getDowntimeHours());
		logger.error("[updateDataInDB] : INFO - StartDate " + downtimeCaptureDo.getStartDate() + " EndDate " + downtimeCaptureDo.getEndDate());
		query.setParameter(2, downtimeCaptureDo.getStartDate());
		query.setParameter(3, downtimeCaptureDo.getEndDate());
		query.setParameter(4, downtimeCaptureDo.getStartTime());
		query.setParameter(5, downtimeCaptureDo.getEndTime());
		query.setParameter(6, downtimeCaptureDo.getDowntimeCode());
		query.setParameter(7, downtimeCaptureDo.getComments());
		query.setParameter(8, downtimeCaptureDo.getMerrickId());
		query.setParameter(9, downtimeCaptureDo.getOriginalDateEntered());
		
		int updatedRowCount = query.executeUpdate();

		if (updatedRowCount > 0) {
			logger.error("[updateDataInDB] : INFO - Record updated succesfully");
		}
	}

	public void deleteDataFromDB(int merrickId, String originalDateEntered) throws Exception {
		Query query = this.getSession().createSQLQuery("DELETE DBO.DowntimeReasonTb WHERE ObjectMerrickID = :merrickId AND OriginalDateEntered= :originalDateEntered ");
		query.setParameter("merrickId", merrickId);
		query.setParameter("originalDateEntered", originalDateEntered);
		
		int updatedRowCount = query.executeUpdate();
		
		if (updatedRowCount > 0) {
			logger.error("[deleteDataInDB] : INFO - Record Deleted succesfully");
		}
	}

	@Override
	protected DowntimeCaptureDo importDto(DowntimeCaptureDto fromDto)
			throws InvalidInputFault, ExecutionFault, NoResultFault {
		return null;
	}

	@Override
	protected DowntimeCaptureDto exportDto(DowntimeCaptureDo entity) {
		return null;
	}

}
