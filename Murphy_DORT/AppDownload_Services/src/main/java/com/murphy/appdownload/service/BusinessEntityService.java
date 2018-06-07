package com.murphy.appdownload.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.murphy.dort.dao.BusinessEntityDao;
import com.murphy.dort.dto.ResponseMessage;
import com.murphy.dort.dto.UIResponseDto;
import com.murphy.downtime.util.DBConnection;
import com.murphy.downtime.util.DowntimeServicesUtil;

public class BusinessEntityService implements BusinessEntityLocal {

	private static final Logger logger = LoggerFactory.getLogger(BusinessEntityService.class);

	
	@Override
	public UIResponseDto fetchBusinessEntityDt() {
		// TODO Auto-generated method stub
		logger.info("[fetchBusinessEntityDt] : INFO- Service Started");
		UIResponseDto uiResponseDto = new UIResponseDto();
		ResponseMessage responseMessage = new ResponseMessage();
		BusinessEntityDao businessEntityDao = null;

		try {
			DowntimeServicesUtil.setupSOCKS();
		} catch (Exception e) {
			logger.error("[fetchDataFromDispositionCodeTb] : ERROR- Exception while setting SOCKS " + e);
		}
		Connection connection = DBConnection.getConnection();

		if (connection != null) {
			businessEntityDao = new BusinessEntityDao();
			try {
				logger.info("[fetchBusinessEntityDt] : INFO- Connection to DB successful");

				uiResponseDto
						.setBusinessEntityList(businessEntityDao.fetchBusinessEntityDt(connection));
				responseMessage.setMessage("Successful");
				responseMessage.setStatus("true");
			} catch (Exception e) {
				logger.error(
						"[fetchBusinessEntityDt] : ERROR- Exception while interacting with database " + e);
				responseMessage.setMessage("Server Internal Error. Facing difficulties interacting to DB.");
				responseMessage.setStatus("false");
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					logger.error(
							"[fetchBusinessEntityDt] : ERROR- Exception while closing Connection " + e);
				}
				try {
					DowntimeServicesUtil.unSetupSOCKS();
				} catch (Exception e) {
					logger.error("[fetchBusinessEntityDt] : ERROR- Exception while unsetting SOCKS " + e);
				}
			}
		} else {
			responseMessage.setMessage("Connection to Database is not possible");
			responseMessage.setStatus("false");
		}

		logger.info("[fetchBusinessEntityDt] : UIResponseDto " + uiResponseDto);
		uiResponseDto.setResponseMessage(responseMessage);
		return uiResponseDto;
	}

	
	@Override
	public UIResponseDto fetchBusinessEntityDtFrHaulerFlag() {
		// TODO Auto-generated method stub
		logger.info("[fetchBusinessEntityDtFrHaulerFlag] : INFO- Service Started");
		UIResponseDto uiResponseDto = new UIResponseDto();
		ResponseMessage responseMessage = new ResponseMessage();
		BusinessEntityDao businessEntityDao = null;

		try {
			DowntimeServicesUtil.setupSOCKS();
		} catch (Exception e) {
			logger.error("[fetchDataFromDispositionCodeTb] : ERROR- Exception while setting SOCKS " + e);
		}
		Connection connection = DBConnection.getConnection();

		if (connection != null) {
			businessEntityDao = new BusinessEntityDao();
			try {
				logger.info("[fetchBusinessEntityDtFrHaulerFlag] : INFO- Connection to DB successful");

				uiResponseDto
						.setBusinessEntityList(businessEntityDao.fetchBusinessEntityDtFrHaulerFlag(connection));
				responseMessage.setMessage("Successful");
				responseMessage.setStatus("true");
			} catch (Exception e) {
				logger.error(
						"[fetchBusinessEntityDtFrHaulerFlag] : ERROR- Exception while interacting with database " + e);
				responseMessage.setMessage("Server Internal Error. Facing difficulties interacting to DB.");
				responseMessage.setStatus("false");
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					logger.error(
							"[fetchBusinessEntityDtFrHaulerFlag] : ERROR- Exception while closing Connection " + e);
				}
				try {
					DowntimeServicesUtil.unSetupSOCKS();
				} catch (Exception e) {
					logger.error("[fetchBusinessEntityDtFrHaulerFlag] : ERROR- Exception while unsetting SOCKS " + e);
				}
			}
		} else {
			responseMessage.setMessage("Connection to Database is not possible");
			responseMessage.setStatus("false");
		}

		logger.info("[fetchBusinessEntityDtFrHaulerFlag] : UIResponseDto " + uiResponseDto);
		uiResponseDto.setResponseMessage(responseMessage);
		return uiResponseDto;
	}

	@Override
	public UIResponseDto fetchBusinessEntityDtFrTransporterFlag() {

		// TODO Auto-generated method stub
		logger.info("[fetchBusinessEntityDtFrTransporterFlag] : INFO- Service Started");
		UIResponseDto uiResponseDto = new UIResponseDto();
		ResponseMessage responseMessage = new ResponseMessage();
		BusinessEntityDao businessEntityDao = null;

		try {
			DowntimeServicesUtil.setupSOCKS();
		} catch (Exception e) {
			logger.error("[fetchDataFromDispositionCodeTb] : ERROR- Exception while  setting SOCKS " + e);
		}
		Connection connection = DBConnection.getConnection();

		if (connection != null) {
			businessEntityDao = new BusinessEntityDao();
			try {
				logger.info("[fetchBusinessEntityDtFrTransporterFlag] : INFO- Connection to DB successful");

				uiResponseDto
						.setBusinessEntityList(businessEntityDao.fetchBusinessEntityDtFrTransporterFlag(connection));
				responseMessage.setMessage("Successful");
				responseMessage.setStatus("true");
			} catch (Exception e) {
				logger.error(
						"[fetchBusinessEntityDtFrTransporterFlag] : ERROR- Exception while interacting with database " + e);
				responseMessage.setMessage("Server Internal Error. Facing difficulties interacting to DB.");
				responseMessage.setStatus("false");
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					logger.error(
							"[fetchBusinessEntityDtFrTransporterFlag] : ERROR- Exception while closing Connection " + e);
				}
				try {
					DowntimeServicesUtil.unSetupSOCKS();
				} catch (Exception e) {
					logger.error("[fetchBusinessEntityDtFrTransporterFlag] : ERROR- Exception while unsetting SOCKS " + e);
				}
			}
		} else {
			responseMessage.setMessage("Connection to Database is not possible");
			responseMessage.setStatus("false");
		}

		logger.info("[fetchBusinessEntityDtFrTransporterFlag] : UIResponseDto " + uiResponseDto);
		uiResponseDto.setResponseMessage(responseMessage);
		return uiResponseDto;
	
	}

	@Override
	public UIResponseDto fetchBusinessEntityDtFrPurchaserFlag() {

		// TODO Auto-generated method stub
		logger.info("[fetchBusinessEntityDtFrPurchaserFlag] : INFO- Service Started");
		UIResponseDto uiResponseDto = new UIResponseDto();
		ResponseMessage responseMessage = new ResponseMessage();
		BusinessEntityDao businessEntityDao = null;

		try {
			DowntimeServicesUtil.setupSOCKS();
		} catch (Exception e) {
			logger.error("[fetchDataFromDispositionCodeTb] : ERROR- Exception while setting SOCKS " + e);
		}
		Connection connection = DBConnection.getConnection();

		if (connection != null) {
			businessEntityDao = new BusinessEntityDao();
			try {
				logger.info("[fetchBusinessEntityDtFrPurchaserFlag] : INFO- Connection to DB successful");

				uiResponseDto
						.setBusinessEntityList(businessEntityDao.fetchBusinessEntityDtFrPurchaserFlag(connection));
				responseMessage.setMessage("Successful");
				responseMessage.setStatus("true");
			} catch (Exception e) {
				logger.error(
						"[fetchBusinessEntityDtFrPurchaserFlag] : ERROR- Exception while interacting with database " + e);
				responseMessage.setMessage("Server Internal Error. Facing difficulties interacting to DB.");
				responseMessage.setStatus("false");
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					logger.error(
							"[fetchBusinessEntityDtFrPurchaserFlag] : ERROR- Exception while closing Connection " + e);
				}
				try {
					DowntimeServicesUtil.unSetupSOCKS();
				} catch (Exception e) {
					logger.error("[fetchBusinessEntityDtFrPurchaserFlag] : ERROR- Exception while unsetting SOCKS " + e);
				}
			}
		} else {
			responseMessage.setMessage("Connection to Database is not possible");
			responseMessage.setStatus("false");
		}

		logger.info("[fetchBusinessEntityDtFrPurchaserFlag] : UIResponseDto " + uiResponseDto);
		uiResponseDto.setResponseMessage(responseMessage);
		return uiResponseDto;
	
	}
}
