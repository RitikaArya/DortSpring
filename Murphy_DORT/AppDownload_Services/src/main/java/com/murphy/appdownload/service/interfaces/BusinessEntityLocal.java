package com.murphy.dort.service;

import com.murphy.dort.dto.UIResponseDto;

public interface BusinessEntityLocal {
	public UIResponseDto fetchBusinessEntityDtFrHaulerFlag();
	public UIResponseDto fetchBusinessEntityDtFrTransporterFlag();
	public UIResponseDto fetchBusinessEntityDtFrPurchaserFlag();
	public UIResponseDto fetchBusinessEntityDt();
}
