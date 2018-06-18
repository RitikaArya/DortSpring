package com.murphy.appdownload.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.murphy.appdownload.service.interfaces.ProductCodeLocal;
import com.murphy.appdownload.dao.ProductCodeDao;
import com.murphy.appdownload.dto.ResponseMessage;
import com.murphy.appdownload.dto.UIRequestDto;
import com.murphy.appdownload.dto.UIResponseDto;
import com.murphy.appdownload.util.DowntimeServicesUtil;

@Service
public class ProductCodeService implements ProductCodeLocal {

	private static final Logger logger = LoggerFactory.getLogger(ProductCodeService.class);

	@Autowired
	ProductCodeDao productCodeDao;
	
	@Override
	public UIResponseDto fetchDataFromProductCodeTb(UIRequestDto uiRequestDto) {

		logger.info("[fetchDataFromProductCodeTb] : INFO- Service Started");
		UIResponseDto uiResponseDto = new UIResponseDto();
		ResponseMessage responseMessage = new ResponseMessage();
//		ProductCodeDao productCodeDao = null;

		try {
			DowntimeServicesUtil.setupSOCKS();
		} catch (Exception e) {
			logger.error("[fetchDataFromProductCodeTb] : ERROR- Exception while setting SOCKS " + e);
		}
		
//			productCodeDao = new ProductCodeDao();
			try {
				logger.info("[fetchDataFromProductCodeTb] : INFO- Connection to DB successful");
				uiResponseDto.setProductCodeDtoList(productCodeDao.fetchDataFromProductCodeTb(uiRequestDto));
				responseMessage.setMessage("Successful");
				responseMessage.setStatus("true");
			} catch (Exception e) {
				logger.error("[fetchDataFromProductCodeTb] : ERROR- Exception while interacting with database " + e);
				responseMessage.setMessage("Server Internal Error. Facing difficulties interacting to DB.");
				responseMessage.setStatus("false");
			} finally {
				try {
					DowntimeServicesUtil.unSetupSOCKS();
				} catch (Exception e) {
					logger.error("[fetchDataFromProductCodeTb] : ERROR- Exception while unsetting SOCKS " + e);
				}
			}

		logger.info("[fetchDataFromProductCodeTb] : productCodeUIRespDto " + uiResponseDto);
		uiResponseDto.setResponseMessage(responseMessage);
		return uiResponseDto;
	}

}
