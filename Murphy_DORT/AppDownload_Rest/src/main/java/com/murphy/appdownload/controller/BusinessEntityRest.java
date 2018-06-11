package com.murphy.appdownload.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.murphy.appdownload.dto.UIResponseDto;
import com.murphy.appdownload.service.BusinessEntityService;
import com.murphy.appdownload.service.interfaces.BusinessEntityLocal;

@RestController
@CrossOrigin
@ComponentScan("com.murphy")
@RequestMapping(value = "/businessEntity", produces = "application/json")
public class BusinessEntityRest {
	
	@Autowired
	BusinessEntityLocal businessEntityLocal;

	@RequestMapping(value = "/haulerFlag", method = RequestMethod.GET)
	public UIResponseDto fetchBusinessEntityDtFrHaulerFlag() {
		businessEntityLocal = new BusinessEntityService();
		return businessEntityLocal.fetchBusinessEntityDtFrHaulerFlag();
	}
	
	@RequestMapping(value = "/transporterFlag", method = RequestMethod.GET)
	public UIResponseDto fetchBusinessEntityDtFrTransporterFlag() {
		businessEntityLocal = new BusinessEntityService();
		return businessEntityLocal.fetchBusinessEntityDtFrTransporterFlag();
	}
	
	@RequestMapping(value = "/purchaserFlag", method = RequestMethod.GET)
	public UIResponseDto fetchBusinessEntityDtFrPurchaserFlag() {
		businessEntityLocal = new BusinessEntityService();
		return businessEntityLocal.fetchBusinessEntityDtFrPurchaserFlag();
	}
	
	@RequestMapping(value = "/fetchDt", method = RequestMethod.GET)
	public UIResponseDto fetchBusinessEntityDt() {
		businessEntityLocal = new BusinessEntityService();
		return businessEntityLocal.fetchBusinessEntityDt();
	}
	

}
