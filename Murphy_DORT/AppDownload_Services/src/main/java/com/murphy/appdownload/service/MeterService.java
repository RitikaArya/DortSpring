package com.murphy.appdownload.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.murphy.appdownload.dao.MeterDao;
import com.murphy.appdownload.dto.ResponseMessage;
import com.murphy.appdownload.dto.UIResponseDto;
import com.murphy.appdownload.service.interfaces.MeterServiceLocal;
import com.murphy.appdownload.util.DowntimeServicesUtil;

public class MeterService implements MeterServiceLocal {

	private static final Logger logger = LoggerFactory.getLogger(MeterService.class);

	
	@Override
	public UIResponseDto fetchMetersDt() {
		// TODO Auto-generated method stub
		logger.info("[fetchMeters] : INFO- Service Started");
		UIResponseDto uiResponseDto = new UIResponseDto();
		ResponseMessage responseMessage = new ResponseMessage();
		MeterDao meterDao = null;

		try {
			DowntimeServicesUtil.setupSOCKS();
		} catch (Exception e) {
			logger.error("[fetchDataFromDispositionCodeTb] : ERROR- Exception while setting SOCKS " + e);
		}

			meterDao = new MeterDao();
			try {
				logger.info("[fetchMetersDt] : INFO- Connection to DB successful");

				uiResponseDto
						.setMeterDtoList(meterDao.fetchMeters());
				responseMessage.setMessage("Successful");
				responseMessage.setStatus("true");
			} catch (Exception e) {
				logger.error(
						"[fetchMetersDt] : ERROR- Exception while interacting with database " + e);
				responseMessage.setMessage("Server Internal Error. Facing difficulties interacting to DB.");
				responseMessage.setStatus("false");
			} finally {
				try {
					DowntimeServicesUtil.unSetupSOCKS();
				} catch (Exception e) {
					logger.error("[fetchMetersDt] : ERROR- Exception while unsetting SOCKS " + e);
				}
			}

		logger.info("[fetchMetersDt] : UIResponseDto " + uiResponseDto);
		uiResponseDto.setResponseMessage(responseMessage);
		return uiResponseDto;
	}

	
}
