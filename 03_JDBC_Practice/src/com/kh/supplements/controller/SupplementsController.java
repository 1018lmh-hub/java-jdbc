package com.kh.supplements.controller;

import com.kh.supplements.model.dto.SupplementsDto;
import com.kh.supplements.model.service.SupplementsService;

public class SupplementsController {
	
	public int insertSupplements(SupplementsDto supplements) {
		return new SupplementsService().insertSupplements(supplements);
	}

}
