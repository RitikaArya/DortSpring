package com.murphy.dort.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.murphy.dort.dto.BusinessEntityDto;

public class BusinessEntityDao {

	private static final Logger logger = LoggerFactory.getLogger(BusinessEntityDao.class);

	public BusinessEntityDao() {
		super();
	}
	
	
	public List<BusinessEntityDto> fetchBusinessEntityDt(Connection connection) throws Exception {
		List<BusinessEntityDto> businessEntityList = null;
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		try {
			stmt = connection.prepareStatement(
					"SELECT MerrickID, CompanyName, HaulerFlag, TransporterFlag, PurchaserFlag FROM procount_test.dbo.BusinessEntityTb WHERE HaulerFlag = 1 OR " 
					+ "TransporterFlag = 1 OR PurchaserFlag = 1");
			resultSet = stmt.executeQuery();

			boolean hasNext = resultSet.next();

			if (resultSet != null && hasNext) {
				businessEntityList = new ArrayList<>();
				while (hasNext) {
					BusinessEntityDto businessEntityDto = new BusinessEntityDto();
					businessEntityDto.setMerrickID(resultSet.getInt("MerrickID"));
					businessEntityDto.setCompanyName(resultSet.getString("CompanyName"));
					businessEntityDto.setHaulerFlag(resultSet.getInt("HaulerFlag"));
					businessEntityDto.setTransporterFlag(resultSet.getInt("TransporterFlag"));
					businessEntityDto.setPurchaserFlag(resultSet.getInt("PurchaserFlag"));
					
					logger.error("[fetchDataFromProductCodeTb] : INFO  - businessEntityDto" + businessEntityDto);
					businessEntityList.add(businessEntityDto);
					hasNext = resultSet.next();
				}
			}
		} catch (Exception e) {

			logger.error("[fetchBusinessEntityDtFrHaulerFlag] : ERROR- Exception while fetching data from database " + e);
			throw e;

		} finally {
			try {
				stmt.close();
				resultSet.close();
			} catch (SQLException e) {
				logger.error("[fetchBusinessEntityDtFrHaulerFlag] : ERROR- Exception while cleaning environment" + e);
			}
		}
		logger.error("[fetchBusinessEntityDtFrHaulerFlag] : INFO  - dispositionCodeDtoList " + businessEntityList);
		return businessEntityList;
	}
	

	public List<BusinessEntityDto> fetchBusinessEntityDtFrHaulerFlag(Connection connection) throws Exception {
		List<BusinessEntityDto> businessEntityList = null;
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		try {
			stmt = connection.prepareStatement(
					"select MerrickID, CompanyName from procount_test.dbo.BusinessEntityTb where procount_test.dbo.BusinessEntityTb.HaulerFlag = 1");
			resultSet = stmt.executeQuery();

			boolean hasNext = resultSet.next();

			if (resultSet != null && hasNext) {
				businessEntityList = new ArrayList<>();
				while (hasNext) {
					BusinessEntityDto businessEntityDto = new BusinessEntityDto();
					businessEntityDto.setMerrickID(resultSet.getInt("MerrickID"));
					businessEntityDto.setCompanyName(resultSet.getString("CompanyName"));
					logger.error("[fetchDataFromProductCodeTb] : INFO  - businessEntityDto" + businessEntityDto);
					businessEntityList.add(businessEntityDto);
					hasNext = resultSet.next();
				}
			}
		} catch (Exception e) {

			logger.error("[fetchBusinessEntityDtFrHaulerFlag] : ERROR- Exception while fetching data from database " + e);
			throw e;

		} finally {
			try {
				stmt.close();
				resultSet.close();
			} catch (SQLException e) {
				logger.error("[fetchBusinessEntityDtFrHaulerFlag] : ERROR- Exception while cleaning environment" + e);
			}
		}
		logger.error("[fetchBusinessEntityDtFrHaulerFlag] : INFO  - dispositionCodeDtoList " + businessEntityList);
		return businessEntityList;
	}

	public List<BusinessEntityDto> fetchBusinessEntityDtFrTransporterFlag(Connection connection) throws Exception {
		List<BusinessEntityDto> businessEntityList = null;
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		try {
			stmt = connection.prepareStatement(
					"select MerrickID, CompanyName from procount_test.dbo.BusinessEntityTb where procount_test.dbo.BusinessEntityTb.TransporterFlag = 1");
			resultSet = stmt.executeQuery();

			boolean hasNext = resultSet.next();

			if (resultSet != null && hasNext) {
				businessEntityList = new ArrayList<>();
				while (hasNext) {
					BusinessEntityDto businessEntityDto = new BusinessEntityDto();
					businessEntityDto.setMerrickID(resultSet.getInt("MerrickID"));
					businessEntityDto.setCompanyName(resultSet.getString("CompanyName"));
					logger.error("[fetchBusinessEntityDtFrTransporterFlag] : INFO  - businessEntityDto" + businessEntityDto);
					businessEntityList.add(businessEntityDto);
					hasNext = resultSet.next();
				}
			}
		} catch (Exception e) {

			logger.error("[fetchBusinessEntityDtFrTransporterFlag] : ERROR- Exception while fetching data from database " + e);
			throw e;

		} finally {
			try {
				stmt.close();
				resultSet.close();
			} catch (SQLException e) {
				logger.error("[fetchBusinessEntityDtFrTransporterFlag] : ERROR- Exception while cleaning environment" + e);
			}
		}
		logger.error("[fetchBusinessEntityDtFrTransporterFlag] : INFO  - dispositionCodeDtoList " + businessEntityList);
		return businessEntityList;
	}

	public List<BusinessEntityDto> fetchBusinessEntityDtFrPurchaserFlag(Connection connection) throws Exception {
		List<BusinessEntityDto> businessEntityList = null;
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		try {
			stmt = connection.prepareStatement(
					"select MerrickID, CompanyName from procount_test.dbo.BusinessEntityTb where procount_test.dbo.BusinessEntityTb.PurchaserFlag = 1");
			resultSet = stmt.executeQuery();

			boolean hasNext = resultSet.next();

			if (resultSet != null && hasNext) {
				businessEntityList = new ArrayList<>();
				while (hasNext) {
					BusinessEntityDto businessEntityDto = new BusinessEntityDto();
					businessEntityDto.setMerrickID(resultSet.getInt("MerrickID"));
					businessEntityDto.setCompanyName(resultSet.getString("CompanyName"));
					logger.error("[fetchBusinessEntityDtFrPurchaserFlag] : INFO  - businessEntityDto" + businessEntityDto);
					businessEntityList.add(businessEntityDto);
					hasNext = resultSet.next();
				}
			}
		} catch (Exception e) {

			logger.error("[fetchBusinessEntityDtFrPurchaserFlag] : ERROR- Exception while fetching data from database " + e);
			throw e;

		} finally {
			try {
				stmt.close();
				resultSet.close();
			} catch (SQLException e) {
				logger.error("[fetchBusinessEntityDtFrPurchaserFlag] : ERROR- Exception while cleaning environment" + e);
			}
		}
		logger.error("[fetchBusinessEntityDtFrPurchaserFlag] : INFO  - dispositionCodeDtoList " + businessEntityList);
		return businessEntityList;
	}

}
