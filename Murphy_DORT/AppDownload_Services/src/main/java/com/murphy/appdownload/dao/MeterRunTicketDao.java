package com.murphy.appdownload.dao;


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
			this.getSession().persist(meterRunTicketDo);
			logger.error("[insertRecordinDB] : INFO - Record inserted succesfully");
		} catch (Exception e) {
			logger.error("[insertRecordinDB] : ERROR- Exception while Inserting data in database " + e);
			throw e;
		}
	}

	@Override
	protected BaseDo importDto(BaseDto fromDto) throws InvalidInputFault, ExecutionFault, NoResultFault {
		return null;
	}

	@Override
	protected BaseDto exportDto(BaseDo entity) {
		return null;
	}

}
