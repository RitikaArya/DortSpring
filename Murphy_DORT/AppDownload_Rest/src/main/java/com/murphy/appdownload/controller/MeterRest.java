package com.murphy.appdownload.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.murphy.appdownload.dto.UIResponseDto;
import com.murphy.appdownload.service.MeterService;
import com.murphy.appdownload.service.interfaces.MeterServiceLocal;

@RestController
@CrossOrigin
@ComponentScan("com.murphy")
@RequestMapping(value = "/meterRest", produces = "application/json")
public class MeterRest {
	
	@Autowired
	MeterServiceLocal meterServiceLocal;

	@RequestMapping(value = "/fetchMeters", method = RequestMethod.GET)
	public UIResponseDto fetchMetersDt() {
		meterServiceLocal = new MeterService();
		return meterServiceLocal.fetchMetersDt();
	}
	

}
