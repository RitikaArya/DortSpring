package com.murphy.appdownload.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.murphy.dort.dto.UIResponseDto;
import com.murphy.dort.service.BusinessEntityLocal;
import com.murphy.dort.service.BusinessEntityService;

@Path("/businessEntity")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class BusinessEntityRest {
	

	BusinessEntityLocal businessEntityLocal;

	@GET
	@Path("/haulerFlag")
	public UIResponseDto fetchBusinessEntityDtFrHaulerFlag() {
		businessEntityLocal = new BusinessEntityService();
		return businessEntityLocal.fetchBusinessEntityDtFrHaulerFlag();
	}
	
	@GET
	@Path("/transporterFlag")
	public UIResponseDto fetchBusinessEntityDtFrTransporterFlag() {
		businessEntityLocal = new BusinessEntityService();
		return businessEntityLocal.fetchBusinessEntityDtFrTransporterFlag();
	}
	
	@GET
	@Path("/purchaserFlag")
	public UIResponseDto fetchBusinessEntityDtFrPurchaserFlag() {
		businessEntityLocal = new BusinessEntityService();
		return businessEntityLocal.fetchBusinessEntityDtFrPurchaserFlag();
	}
	
	@GET
	@Path("/fetchDt")
	public UIResponseDto fetchBusinessEntityDt() {
		businessEntityLocal = new BusinessEntityService();
		return businessEntityLocal.fetchBusinessEntityDt();
	}
	

}
