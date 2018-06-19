package com.murphy.appdownload.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.murphy.appdownload.dto.DowntimeCaptureDto;
import com.murphy.appdownload.dto.DowntimeCaptureFetchResponseDto;
import com.murphy.appdownload.dto.ResponseMessage;
import com.murphy.appdownload.service.interfaces.DowntimeCaptureLocal;

@RestController
@CrossOrigin
@ComponentScan("com.murphy")
@RequestMapping(value = "/downtimeCapture", produces = "application/json")
public class DowntimeCaptureRest {
	
	@Autowired
	DowntimeCaptureLocal downtimeCaptureLocal;
	
	@RequestMapping(value = "/updateDowntimeCapture", method = RequestMethod.POST)
	public ResponseMessage createTaskFromTemplate(@RequestBody DowntimeCaptureDto downtimeCaptureDto) {
		return downtimeCaptureLocal.insertOrUpdateCounts(downtimeCaptureDto);
	}

	@RequestMapping(value = "/getDowntimeCapture", method = RequestMethod.GET)
	public DowntimeCaptureFetchResponseDto fetchDowntimeCapture(@RequestParam("originalDateEntered") String originalDateEntered, @RequestParam("uwiId") String uwiId) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		Date originalDate = null;
		DowntimeCaptureFetchResponseDto responseDto = null;
		try {
			originalDate = df.parse(originalDateEntered);
			responseDto = downtimeCaptureLocal.fetchRecordForProvidedUwiIdAndDate(originalDate, uwiId);
		} catch (ParseException e) {
			System.err.println("Exception : "+e.getMessage());
		}
		// LOGGER.info("Inside delivery data creation");
		return responseDto;
	}
	
	public static void main(String[] args) throws ParseException {
		String d = "2018-04-20T00:00:00";
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		Date date = df.parse(d);
		System.out.println(date);
	}

}
