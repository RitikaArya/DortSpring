package com.murphy.appdownload.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.murphy.appdownload.dto.BaseDto;
import com.murphy.appdownload.dto.MeterDto;
import com.murphy.appdownload.entity.BaseDo;
import com.murphy.appdownload.exception.ExecutionFault;
import com.murphy.appdownload.exception.InvalidInputFault;
import com.murphy.appdownload.exception.NoResultFault;
import com.murphy.appdownload.util.ServicesUtil;

@Repository("MeterDao")
@Transactional
public class MeterDao extends BaseDao<BaseDo, BaseDto>{

	private static final Logger logger = LoggerFactory.getLogger(MeterDao.class);

	public MeterDao() {
		super();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<MeterDto> fetchMeters() throws Exception {
		List<MeterDto> meterList = null;
		
		try {
			String queryString = "select MerrickID, MeterName from dbo.MeterTb where dbo.MeterTb.MerrickID IN (4613, 4680, 4827, 5427, 5463, 6263, 6494, 6495, 6542, 6543, 6552, 6179, 316,"
					+ " 7143, 7153, 4680, 11, 12, 488, 489, 490, 491, 493, 494, 759, 1591, 1592, 1779, 1780, 2220, 2711, 2712, 2750, 2751, 2814, 2815, 3255, 3256, 3853, 3891"
					+ ", 4269, 4270, 4315, 4612, 4613, 4890, 4891, 4957, 4958, 5659, 5660, 5768, 5769, 6163, 6164, 6177, 6178, 6244, 6245, 6478, 6479, 6506, 6507, 6978, 6979"
					+ ", 7094)";
			
			Query query = this.getSession().createSQLQuery(queryString);
			List<Object[]> resultList = query.list();

			if(!ServicesUtil.isEmpty(resultList)){
				meterList = new ArrayList<>();
				for (Object[] obj : resultList) {
					MeterDto meterDto = new MeterDto();
					meterDto.setMerrickID((int) obj[0]);
					meterDto.setMeterName((String) obj[1]);
					meterList.add(meterDto);
				}
			}
		} catch (Exception e) {

			logger.error("[fetchMeters] : ERROR- Exception while fetching data from database " + e);
			throw e;
		} 
		logger.error("[fetchMeters] : INFO  - meterList " + meterList);
		return meterList;
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
