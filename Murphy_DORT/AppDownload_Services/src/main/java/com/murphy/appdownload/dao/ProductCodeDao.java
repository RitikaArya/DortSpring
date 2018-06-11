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
import com.murphy.appdownload.dto.ProductCodeDto;
import com.murphy.appdownload.dto.UIRequestDto;
import com.murphy.appdownload.entity.BaseDo;
import com.murphy.appdownload.exception.ExecutionFault;
import com.murphy.appdownload.exception.InvalidInputFault;
import com.murphy.appdownload.exception.NoResultFault;
import com.murphy.appdownload.util.DowntimeServicesUtil;
import com.murphy.appdownload.util.ServicesUtil;

@Repository("ProductCodeDao")
@Transactional
public class ProductCodeDao extends BaseDao<BaseDo, BaseDto>{

	private static final Logger logger = LoggerFactory.getLogger(ProductCodeDao.class);

	public ProductCodeDao() {
		super();
	}

	@SuppressWarnings("unchecked")
	public List<ProductCodeDto> fetchDataFromProductCodeTb(UIRequestDto uiRequestDto) throws Exception {
		List<ProductCodeDto> productCodeDtoList = null;

		try {
			String merricIdListQuery = DowntimeServicesUtil.getQueryString(new HashSet<Integer>(uiRequestDto.getMerrickIdList()), "MerrickID", new ArrayList<Integer>());
			
			logger.error("[fetchDataFromProductCodeTb] : INFO  - merricIdListQuery" + merricIdListQuery);
			logger.error("[fetchDataFromProductCodeTb] : INFO  - Query - SELECT ProductTypeID, ProductCodeShort, MerrickID FROM dbo.ProductCodeTb WHERE "+ merricIdListQuery);
			
			String queryString = "SELECT ProductTypeID, ProductCodeShort, MerrickID FROM dbo.ProductCodeTb WHERE "+ merricIdListQuery;
			Query query = this.getSession().createSQLQuery(queryString);
			List<Object[]> resultList = query.list();

			if(ServicesUtil.isEmpty(resultList)){
				productCodeDtoList = new ArrayList<>();
				for (Object[] obj : resultList) {
					ProductCodeDto productCodeDto = new ProductCodeDto();
					productCodeDto.setProductTypeID((int) obj[1]);
					productCodeDto.setProductCodeShort((String) obj[2]);
					productCodeDto.setMerrickID((int) obj[3]);
					logger.error("[fetchDataFromProductCodeTb] : INFO  - productCodeDto" + productCodeDto);
					productCodeDtoList.add(productCodeDto);
				}
			}
		} catch (Exception e) {

			logger.error("[fetchDataFromProductCodeTb] : ERROR- Exception while fetching data from database " + e);
			throw e;

		} 
		logger.error("[fetchDataFromProductCodeTb] : INFO  - productCodeDtoList " + productCodeDtoList);
		return productCodeDtoList;
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
