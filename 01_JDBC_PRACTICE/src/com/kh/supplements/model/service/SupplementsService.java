package com.kh.supplements.model.service;

import java.util.List;

import com.kh.supplements.model.dao.SupplementsDao;
import com.kh.supplements.model.dto.SupplementsDto;

public class SupplementsService {
	
	private SupplementsDao sdao = new SupplementsDao();
	
	public int save(SupplementsDto sdto) {
		return sdao.save(sdto);
	}
	
	public List<SupplementsDto> findAll(){
		return sdao.findAll();
	}

}
