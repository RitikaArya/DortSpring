package com.murphy.appdownload.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.murphy.appdownload.dto.BaseDto;
import com.murphy.appdownload.dto.DispositionCodeDto;
import com.murphy.appdownload.dto.UIRequestDto;
import com.murphy.appdownload.entity.BaseDo;
import com.murphy.appdownload.exception.ExecutionFault;
import com.murphy.appdownload.exception.InvalidInputFault;
import com.murphy.appdownload.exception.NoResultFault;
import com.murphy.appdownload.util.DowntimeServicesUtil;
import com.murphy.appdownload.util.ServicesUtil;

@Repository("DispositionCodeDao")
@Transactional
public class DispositionCodeDao extends BaseDao<BaseDo, BaseDto>{

	private static final Logger logger = LoggerFactory.getLogger(DispositionCodeDao.class);

	public DispositionCodeDao() {
		super();
	}

	@SuppressWarnings("unchecked")
	public List<DispositionCodeDto> fetchDataFromDispositionCodeTb(UIRequestDto uiRequestDto) throws Exception {
		List<DispositionCodeDto> dispositionCodeDtoList = null;

		try {
			String merricIdListQuery = DowntimeServicesUtil.getQueryString(new HashSet<Integer>(uiRequestDto.getMerrickIdList()), "dbo.DispositionCodeTb.MerrickID", new ArrayList<Integer>());
			logger.error("[fetchDataFromDispositionCodeTb] : INFO  - merricIdListQuery" + merricIdListQuery);
			logger.error("[fetchDataFromDispositionCodeTb] : INFO  - Query - SELECT ProductTypeID, DispositionCodeShort, MerrickID FROM dbo.DispositionCodeTb WHERE "+ merricIdListQuery);
			
			String queryString = "SELECT ProductTypeID, DispositionCodeShort, MerrickID FROM dbo.DispositionCodeTb WHERE "+ merricIdListQuery;
			Query query = this.getSession().createSQLQuery(queryString);
			List<Object[]> resultList = query.list();
			
			if(!ServicesUtil.isEmpty(resultList)){
				dispositionCodeDtoList = new ArrayList<>();
				for (Object[] obj : resultList) {
					DispositionCodeDto dispositionCodeDto = new DispositionCodeDto();
					dispositionCodeDto.setProductTypeID((int) obj[0]);
					dispositionCodeDto.setDispositionCodeShort((String) obj[1]);
					dispositionCodeDto.setMerrickID((int) obj[2]);
					logger.error("[fetchDataFromDispositionCodeTb] : INFO  - dispositionCodeDto" + dispositionCodeDto);
					dispositionCodeDtoList.add(dispositionCodeDto);
				}
			}
		} catch (Exception e) {

			logger.error("[fetchDataFromDispositionCodeTb] : ERROR- Exception while fetching data from database " + e);
			throw e;

		} 
		logger.error("[fetchDataFromDispositionCodeTb] : INFO  - dispositionCodeDtoList " + dispositionCodeDtoList);
		return dispositionCodeDtoList;
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
