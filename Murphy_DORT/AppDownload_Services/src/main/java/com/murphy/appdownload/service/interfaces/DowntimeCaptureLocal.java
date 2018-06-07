package com.murphy.appdownload.service.interfaces;

import java.util.Date;

import com.murphy.appdownload.dto.DowntimeCaptureDto;
import com.murphy.appdownload.dto.DowntimeCaptureFetchResponseDto;
import com.murphy.appdownload.dto.ResponseMessage;

public interface DowntimeCaptureLocal {
	ResponseMessage insertOrUpdateCounts(DowntimeCaptureDto downtimeCaptureDto);

	DowntimeCaptureFetchResponseDto fetchRecordForProvidedUwiIdAndDate(Date originalDateEntered, String uwiId);
}
