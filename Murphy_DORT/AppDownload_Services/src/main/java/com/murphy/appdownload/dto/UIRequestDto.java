package com.murphy.appdownload.dto;

import java.util.List;

public class UIRequestDto {

	private List<Integer> merrickIdList;

	public List<Integer> getMerrickIdList() {
		return merrickIdList;
	}

	public void setMerrickIdList(List<Integer> merrickIdList) {
		this.merrickIdList = merrickIdList;
	}

	@Override
	public String toString() {
		return "UIRequestDto [merrickIdList=" + merrickIdList + "]";
	}
	
}
