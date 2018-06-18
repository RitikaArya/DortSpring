package com.murphy.appdownload.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.murphy.appdownload.dao.DispositionCodeDao;
import com.murphy.appdownload.dto.ResponseMessage;
import com.murphy.appdownload.dto.UIRequestDto;
import com.murphy.appdownload.dto.UIResponseDto;
import com.murphy.appdownload.service.interfaces.DispositionCodeLocal;
import com.murphy.appdownload.util.DowntimeServicesUtil;

@Service
public class DispositionCodeService implements DispositionCodeLocal {

	private static final Logger logger = LoggerFactory.getLogger(DispositionCodeService.class);

	@Autowired
	DispositionCodeDao dispositionCodeDao;
	
	@Override
	public UIResponseDto fetchDataFromDispositionCodeTb(UIRequestDto uiRequestDto) {
		logger.info("[fetchDataFromDispositionCodeTb] : INFO- Service Started");
		UIResponseDto uiResponseDto = new UIResponseDto();
		ResponseMessage responseMessage = new ResponseMessage();
//		DispositionCodeDao dispositionCodeDao = null;
		if (uiRequestDto != null && uiRequestDto.getMerrickIdList() != null && uiRequestDto.getMerrickIdList().size()>0) {
			try {
				DowntimeServicesUtil.setupSOCKS();
			} catch (Exception e) {
				logger.error("[fetchDataFromDispositionCodeTb] : ERROR- Exception while setting SOCKS " + e);
			}

//				dispositionCodeDao = new DispositionCodeDao();
				try {
					logger.info("[fetchDataFromDispositionCodeTb] : INFO- Connection to DB successful");
					
					uiResponseDto.setDispositionCodeDtoList(
							dispositionCodeDao.fetchDataFromDispositionCodeTb(uiRequestDto));
					responseMessage.setMessage("Successful");
					responseMessage.setStatus("true");
				} catch (Exception e) {
					logger.error(
							"[fetchDataFromDispositionCodeTb] : ERROR- Exception while interacting with database " + e);
					responseMessage.setMessage("Server Internal Error. Facing difficulties interacting to DB.");
					responseMessage.setStatus("false");
				} finally {
					try {
						DowntimeServicesUtil.unSetupSOCKS();
					} catch (Exception e) {
						logger.error("[fetchDataFromDispositionCodeTb] : ERROR- Exception while unsetting SOCKS " + e);
					}
				}
			} else {
				responseMessage.setMessage("Connection to Database is not possible");
				responseMessage.setStatus("false");
			}
		
		logger.info("[fetchDataFromDispositionCodeTb] : DispositionCodeUIRespDto " + uiResponseDto);
		uiResponseDto.setResponseMessage(responseMessage);
		return uiResponseDto;

	}
}
