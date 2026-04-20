package com.kh.supplements.model.service;

import java.sql.Connection;

import static com.kh.supplements.common.JdbcTemplate.close;
import static com.kh.supplements.common.JdbcTemplate.commit;
import static com.kh.supplements.common.JdbcTemplate.getConnection;

import com.kh.supplements.model.dao.SupplementsDao;
import com.kh.supplements.model.dto.SupplementsDto;

public class SupplementsService {
	
	SupplementsDao sd = new SupplementsDao();
	
	public int insertSupplements(SupplementsDto supplements) {
		int result = 0;
		Connection conn = getConnection();
		sd.insertSupplements(supplements);
		
		
		return result;
	}

}
