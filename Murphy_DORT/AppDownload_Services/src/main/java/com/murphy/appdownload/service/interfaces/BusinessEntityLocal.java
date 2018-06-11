package com.murphy.appdownload.service.interfaces;

import com.murphy.appdownload.dto.UIResponseDto;

public interface BusinessEntityLocal {
	public UIResponseDto fetchBusinessEntityDtFrHaulerFlag();
	public UIResponseDto fetchBusinessEntityDtFrTransporterFlag();
	public UIResponseDto fetchBusinessEntityDtFrPurchaserFlag();
	public UIResponseDto fetchBusinessEntityDt();
}
