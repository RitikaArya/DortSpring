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
import com.murphy.appdownload.service.ProductCodeService;
import com.murphy.appdownload.service.interfaces.ProductCodeLocal;

@RestController
@CrossOrigin
@ComponentScan("com.murphy")
@RequestMapping(value = "/productCode", produces = "application/json")
public class ProductCodeRest {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductCodeRest.class);
	
	@Autowired
	ProductCodeLocal productCodeLocal;
	
	@RequestMapping(value = "/getProduct", method = RequestMethod.POST)
	public UIResponseDto fetchDataFromProductCodeTb(@RequestBody UIRequestDto uiRequestDto) {
		logger.error("[fetchDataFromProductCodeTb] :INFO uiRequestDto" +  uiRequestDto);
		productCodeLocal = new ProductCodeService();
		return productCodeLocal.fetchDataFromProductCodeTb(uiRequestDto);
	}
}
