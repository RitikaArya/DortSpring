package com.murphy.appdownload.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.murphy.appdownload.dao.BusinessEntityDao;
import com.murphy.appdownload.dto.ResponseMessage;
import com.murphy.appdownload.dto.UIResponseDto;
import com.murphy.appdownload.service.interfaces.BusinessEntityLocal;
import com.murphy.appdownload.util.DowntimeServicesUtil;

@Service
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

			businessEntityDao = new BusinessEntityDao();
			try {
				logger.info("[fetchBusinessEntityDt] : INFO- Connection to DB successful");

				uiResponseDto
						.setBusinessEntityList(businessEntityDao.fetchBusinessEntityDt());
				responseMessage.setMessage("Successful");
				responseMessage.setStatus("true");
			} catch (Exception e) {
				logger.error(
						"[fetchBusinessEntityDt] : ERROR- Exception while interacting with database " + e);
				responseMessage.setMessage("Server Internal Error. Facing difficulties interacting to DB.");
				responseMessage.setStatus("false");
			} finally {
				try {
					DowntimeServicesUtil.unSetupSOCKS();
				} catch (Exception e) {
					logger.error("[fetchBusinessEntityDt] : ERROR- Exception while unsetting SOCKS " + e);
				}
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

			businessEntityDao = new BusinessEntityDao();
			try {
				logger.info("[fetchBusinessEntityDtFrHaulerFlag] : INFO- Connection to DB successful");

				uiResponseDto
						.setBusinessEntityList(businessEntityDao.fetchBusinessEntityDtFrHaulerFlag());
				responseMessage.setMessage("Successful");
				responseMessage.setStatus("true");
			} catch (Exception e) {
				logger.error(
						"[fetchBusinessEntityDtFrHaulerFlag] : ERROR- Exception while interacting with database " + e);
				responseMessage.setMessage("Server Internal Error. Facing difficulties interacting to DB.");
				responseMessage.setStatus("false");
			} finally {
				try {
					DowntimeServicesUtil.unSetupSOCKS();
				} catch (Exception e) {
					logger.error("[fetchBusinessEntityDtFrHaulerFlag] : ERROR- Exception while unsetting SOCKS " + e);
				}
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

			businessEntityDao = new BusinessEntityDao();
			try {
				logger.info("[fetchBusinessEntityDtFrTransporterFlag] : INFO- Connection to DB successful");

				uiResponseDto
						.setBusinessEntityList(businessEntityDao.fetchBusinessEntityDtFrTransporterFlag());
				responseMessage.setMessage("Successful");
				responseMessage.setStatus("true");
			} catch (Exception e) {
				logger.error(
						"[fetchBusinessEntityDtFrTransporterFlag] : ERROR- Exception while interacting with database " + e);
				responseMessage.setMessage("Server Internal Error. Facing difficulties interacting to DB.");
				responseMessage.setStatus("false");
			} finally {
				try {
					DowntimeServicesUtil.unSetupSOCKS();
				} catch (Exception e) {
					logger.error("[fetchBusinessEntityDtFrTransporterFlag] : ERROR- Exception while unsetting SOCKS " + e);
				}
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

			businessEntityDao = new BusinessEntityDao();
			try {
				logger.info("[fetchBusinessEntityDtFrPurchaserFlag] : INFO- Connection to DB successful");

				uiResponseDto
						.setBusinessEntityList(businessEntityDao.fetchBusinessEntityDtFrPurchaserFlag());
				responseMessage.setMessage("Successful");
				responseMessage.setStatus("true");
			} catch (Exception e) {
				logger.error(
						"[fetchBusinessEntityDtFrPurchaserFlag] : ERROR- Exception while interacting with database " + e);
				responseMessage.setMessage("Server Internal Error. Facing difficulties interacting to DB.");
				responseMessage.setStatus("false");
			} finally {
				try {
					DowntimeServicesUtil.unSetupSOCKS();
				} catch (Exception e) {
					logger.error("[fetchBusinessEntityDtFrPurchaserFlag] : ERROR- Exception while unsetting SOCKS " + e);
				}
			}

		logger.info("[fetchBusinessEntityDtFrPurchaserFlag] : UIResponseDto " + uiResponseDto);
		uiResponseDto.setResponseMessage(responseMessage);
		return uiResponseDto;
	
	}
}
