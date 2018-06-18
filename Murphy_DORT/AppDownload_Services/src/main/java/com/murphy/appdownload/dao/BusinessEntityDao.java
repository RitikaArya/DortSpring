package com.murphy.appdownload.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.murphy.appdownload.dto.BaseDto;
import com.murphy.appdownload.dto.BusinessEntityDto;
import com.murphy.appdownload.entity.BaseDo;
import com.murphy.appdownload.exception.ExecutionFault;
import com.murphy.appdownload.exception.InvalidInputFault;
import com.murphy.appdownload.exception.NoResultFault;
import com.murphy.appdownload.util.ServicesUtil;

@Repository("BusinessEntityDao")
@Transactional
public class BusinessEntityDao extends BaseDao<BaseDo, BaseDto>{

	private static final Logger logger = LoggerFactory.getLogger(BusinessEntityDao.class);

	public BusinessEntityDao() {
		super();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<BusinessEntityDto> fetchBusinessEntityDt() throws Exception {
		List<BusinessEntityDto> businessEntityList = null;
		
		try {
			String queryString = "SELECT MerrickID, CompanyName, HaulerFlag, TransporterFlag, PurchaserFlag FROM dbo.BusinessEntityTb WHERE HaulerFlag = 1 OR " 
					+ "TransporterFlag = 1 OR PurchaserFlag = 1" ;
			Query query = this.getSession().createSQLQuery(queryString);
			List<Object[]> resultList = query.list();
			
			if(!ServicesUtil.isEmpty(resultList)){
				businessEntityList = new ArrayList<>();
				for (Object[] obj : resultList) {
					BusinessEntityDto businessEntityDto = new BusinessEntityDto();
					businessEntityDto.setMerrickID((int) obj[1]);
					businessEntityDto.setCompanyName((String) obj[2]);
					businessEntityDto.setHaulerFlag((int) obj[3]);
					businessEntityDto.setTransporterFlag((int) obj[4]);
					businessEntityDto.setPurchaserFlag((int) obj[5]);
					
					logger.error("[BusinessEntityTb] : INFO  - businessEntityDto" + businessEntityDto);
					businessEntityList.add(businessEntityDto);
				}
			}
		} catch (Exception e) {

			logger.error("[fetchBusinessEntityDt] : ERROR- Exception while fetching data from database " + e);
			throw e;

		} 
		logger.error("[fetchBusinessEntityDt] : INFO  - dispositionCodeDtoList " + businessEntityList);
		return businessEntityList;
	}
	

	@SuppressWarnings("unchecked")
	public List<BusinessEntityDto> fetchBusinessEntityDtFrHaulerFlag() throws Exception {
		List<BusinessEntityDto> businessEntityList = null;
		
		try {
			String queryString = "select MerrickID, CompanyName from dbo.BusinessEntityTb where dbo.BusinessEntityTb.HaulerFlag = 1";
			Query query = this.getSession().createSQLQuery(queryString);
			List<Object[]> resultList = query.list();

			if(!ServicesUtil.isEmpty(resultList)){
				businessEntityList = new ArrayList<>();
				for (Object[] obj : resultList) {
					BusinessEntityDto businessEntityDto = new BusinessEntityDto();
					businessEntityDto.setMerrickID((int) obj[1]);
					businessEntityDto.setCompanyName((String) obj[1]);
					logger.error("[fetchDataFromBusinessEntityTb] : INFO  - businessEntityDto" + businessEntityDto);
					businessEntityList.add(businessEntityDto);
				}
			}
		} catch (Exception e) {

			logger.error("[fetchBusinessEntityDtFrHaulerFlag] : ERROR- Exception while fetching data from database " + e);
			throw e;

		} 
		logger.error("[fetchBusinessEntityDtFrHaulerFlag] : INFO  - dispositionCodeDtoList " + businessEntityList);
		return businessEntityList;
	}

	@SuppressWarnings("unchecked")
	public List<BusinessEntityDto> fetchBusinessEntityDtFrTransporterFlag() throws Exception {
		List<BusinessEntityDto> businessEntityList = null;
		
		try {
			String queryString = "select MerrickID, CompanyName from dbo.BusinessEntityTb where dbo.BusinessEntityTb.TransporterFlag = 1";
			Query query = this.getSession().createSQLQuery(queryString);
			List<Object[]> resultList = query.list();

			if(!ServicesUtil.isEmpty(resultList)){
				businessEntityList = new ArrayList<>();
				for (Object[] obj : resultList) {
					BusinessEntityDto businessEntityDto = new BusinessEntityDto();
					businessEntityDto.setMerrickID((int) obj[1]);
					businessEntityDto.setCompanyName((String) obj[2]);
					logger.error("[fetchBusinessEntityDtFrTransporterFlag] : INFO  - businessEntityDto" + businessEntityDto);
					businessEntityList.add(businessEntityDto);
				}
			}
		} catch (Exception e) {

			logger.error("[fetchBusinessEntityDtFrTransporterFlag] : ERROR- Exception while fetching data from database " + e);
			throw e;

		}
		logger.error("[fetchBusinessEntityDtFrTransporterFlag] : INFO  - dispositionCodeDtoList " + businessEntityList);
		return businessEntityList;
	}

	@SuppressWarnings("unchecked")
	public List<BusinessEntityDto> fetchBusinessEntityDtFrPurchaserFlag() throws Exception {
		List<BusinessEntityDto> businessEntityList = null;
		
		try {
			String queryString = "select MerrickID, CompanyName from dbo.BusinessEntityTb where dbo.BusinessEntityTb.PurchaserFlag = 1";
			Query query = this.getSession().createSQLQuery(queryString);
			List<Object[]> resultList = query.list();

			if(!ServicesUtil.isEmpty(resultList)){
				businessEntityList = new ArrayList<>();
				for (Object[] obj : resultList) {
					BusinessEntityDto businessEntityDto = new BusinessEntityDto();
					businessEntityDto.setMerrickID((int) obj[1]);
					businessEntityDto.setCompanyName((String) obj[1]);
					logger.error("[fetchBusinessEntityDtFrPurchaserFlag] : INFO  - businessEntityDto" + businessEntityDto);
					businessEntityList.add(businessEntityDto);
				}
			}
		} catch (Exception e) {

			logger.error("[fetchBusinessEntityDtFrPurchaserFlag] : ERROR- Exception while fetching data from database " + e);
			throw e;
		} 
		logger.error("[fetchBusinessEntityDtFrPurchaserFlag] : INFO  - dispositionCodeDtoList " + businessEntityList);
		return businessEntityList;
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
