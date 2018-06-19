/*package com.murphy.appdownload.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.murphy.appdownload.dto.AppFileDto;
import com.murphy.appdownload.dto.DownloadResponse;
import com.murphy.appdownload.dto.FileVersionDto;
import com.murphy.appdownload.service.interfaces.AppFileFacadeLocal;

@RestController
@CrossOrigin
@ComponentScan("com.murphy")
@RequestMapping(value = "/appFile", produces = "application/json")
public class AppFileRestController {
	
	@Autowired
	private AppFileFacadeLocal fileLocal;
	
	@RequestMapping(value="/download", method=RequestMethod.GET)
	public DownloadResponse getDownloadResponse(@RequestParam(value ="fileType") String fileType, @RequestParam(value ="application") String application) {
		DownloadResponse downloadResponse = new DownloadResponse();
		AppFileDto dto = fileLocal.getFile(fileType, null, application);
		downloadResponse.setUrl(dto.getFileUrl());
		downloadResponse.setVersion(dto.getFileVersion());
		return downloadResponse;
	}
	
	@RequestMapping(value="/version", method=RequestMethod.GET)
	public FileVersionDto getVersion(@RequestParam(value ="fileType") String fileType, @RequestParam(value ="application") String application) {
		return fileLocal.getFileVersion(fileType, application);
	}
}
*/