package com.murphy.appdownload.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.murphy.appdownload.dao.AppFileDao;
import com.murphy.appdownload.dto.AppFileDto;
import com.murphy.appdownload.dto.FileVersionDto;
import com.murphy.appdownload.dto.ResponseMessage;
import com.murphy.appdownload.exception.ExecutionFault;
import com.murphy.appdownload.service.interfaces.AppFileFacadeLocal;

@Service
public class AppFileFacade implements AppFileFacadeLocal {

	@Autowired
	private AppFileDao appFileDao;

	@Override
	public ResponseMessage saveFile(AppFileDto dto) {
		ResponseMessage responseMessage = new ResponseMessage();
		responseMessage.setMessage("Failed to Save File");
		responseMessage.setStatus("FAILURE");
		responseMessage.setStatusCode("1");
		try {
			responseMessage = appFileDao.insertFile(dto);
		} catch (ExecutionFault e) {
			e.printStackTrace();
		}
		return responseMessage;
	}

	@Override
	public AppFileDto getFile(String fileType, String fileVersion, String application) {
		return appFileDao.getFile(fileType, fileVersion, application);
	}
	
	@Override
	public FileVersionDto getFileVersion(String fileType, String application) {
		return appFileDao.getVersionList(fileType, null, application);
	}


}
