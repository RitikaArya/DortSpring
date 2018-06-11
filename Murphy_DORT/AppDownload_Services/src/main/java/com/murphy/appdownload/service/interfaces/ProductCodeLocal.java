package com.murphy.appdownload.service.interfaces;

import com.murphy.appdownload.dto.UIRequestDto;
import com.murphy.appdownload.dto.UIResponseDto;

public interface ProductCodeLocal {

	public UIResponseDto fetchDataFromProductCodeTb(UIRequestDto uiRequestDto);
}
