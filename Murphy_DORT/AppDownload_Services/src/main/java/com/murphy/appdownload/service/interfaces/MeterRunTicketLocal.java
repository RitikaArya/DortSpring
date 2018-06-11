package com.murphy.appdownload.service.interfaces;

import com.murphy.appdownload.dto.MeterRunTicketDto;
import com.murphy.appdownload.dto.UIResponseDto;

public interface MeterRunTicketLocal {

	public UIResponseDto insertRecordinDB(MeterRunTicketDto meterRunTicketDto);
}
