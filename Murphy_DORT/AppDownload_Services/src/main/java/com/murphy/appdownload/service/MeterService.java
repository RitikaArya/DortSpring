package com.murphy.appdownload.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.murphy.appdownload.dao.MeterDao;
import com.murphy.appdownload.dto.ResponseMessage;
import com.murphy.appdownload.dto.UIResponseDto;
import com.murphy.appdownload.service.interfaces.MeterServiceLocal;
import com.murphy.appdownload.util.DowntimeServicesUtil;

@Service("MeterService")
public class MeterService implements MeterServiceLocal {

	private static final Logger logger = LoggerFactory.getLogger(MeterService.class);

	@Autowired
	MeterDao meterDao;
	
	@Override
	public UIResponseDto fetchMetersDt() {
		
		logger.info("[fetchMeters] : INFO- Service Started");
		UIResponseDto uiResponseDto = new UIResponseDto();
		ResponseMessage responseMessage = new ResponseMessage();

		try {
			DowntimeServicesUtil.setupSOCKS();
		} catch (Exception e) {
			logger.error("[fetchDataFromDispositionCodeTb] : ERROR- Exception while setting SOCKS " + e);
		}

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
