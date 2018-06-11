package com.murphy.appdownload.service.interfaces;

import com.murphy.appdownload.dto.UIRequestDto;
import com.murphy.appdownload.dto.UIResponseDto;

public interface DispositionCodeLocal {

	public UIResponseDto fetchDataFromDispositionCodeTb(UIRequestDto uiRequestDto);
}
