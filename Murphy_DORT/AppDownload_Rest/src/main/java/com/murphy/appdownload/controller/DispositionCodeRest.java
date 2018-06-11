package com.murphy.appdownload.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.murphy.appdownload.dto.UIRequestDto;
import com.murphy.appdownload.dto.UIResponseDto;
import com.murphy.appdownload.service.DispositionCodeService;
import com.murphy.appdownload.service.interfaces.DispositionCodeLocal;

@RestController
@CrossOrigin
@ComponentScan("com.murphy")
@RequestMapping(value = "/dispositionCode", produces = "application/json")
public class DispositionCodeRest {
	
	private static final Logger logger = LoggerFactory.getLogger(DispositionCodeRest.class);
	
	@Autowired
	DispositionCodeLocal dispositionCodeLocal;
	
	@RequestMapping(value = "/getDisposition", method = RequestMethod.POST)
	public UIResponseDto fetchDataFromDispositionCodeTb(@RequestBody UIRequestDto uiRequestDto) {
		logger.info("[fetchDataFromDispositionCodeTb] : uiRequestDto" +  uiRequestDto);
		dispositionCodeLocal = new DispositionCodeService();
		return dispositionCodeLocal.fetchDataFromDispositionCodeTb(uiRequestDto);
	}

}
