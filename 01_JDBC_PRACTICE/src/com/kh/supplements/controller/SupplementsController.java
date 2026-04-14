package com.kh.supplements.controller;

import java.util.List;

import com.kh.supplements.model.dto.SupplementsDto;
import com.kh.supplements.model.service.SupplementsService;

public class SupplementsController {
	
	private SupplementsService supSer = new SupplementsService();
	
	public int save(SupplementsDto sdto) {
		return supSer.save(sdto);
	}
	
	public List<SupplementsDto> findAll(){
		return supSer.findAll();
	}

}
