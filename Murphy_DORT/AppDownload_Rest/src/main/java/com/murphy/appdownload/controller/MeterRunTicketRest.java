package com.murphy.appdownload.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.murphy.appdownload.dto.MeterRunTicketDto;
import com.murphy.appdownload.dto.UIResponseDto;
import com.murphy.appdownload.service.interfaces.MeterRunTicketLocal;

@RestController
@CrossOrigin
@ComponentScan("com.murphy")
@RequestMapping(value = "/meterRunTicket", produces = "application/json")
public class MeterRunTicketRest {
	
	@Autowired
	MeterRunTicketLocal meterRunTicketLocal;
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public UIResponseDto createTaskFromTemplate(@RequestBody MeterRunTicketDto meterRunTicketDto) {
		
		return meterRunTicketLocal.insertRecordinDB(meterRunTicketDto);
	}

}
