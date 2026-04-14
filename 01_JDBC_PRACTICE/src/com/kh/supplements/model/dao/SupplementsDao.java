package com.kh.supplements.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kh.supplements.model.dto.SupplementsDto;

public class SupplementsDao {
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int save(SupplementsDto sdto) {
		int result = 0;
		
		String sql = "INSERT "
					 + "INTO "
						  + "SUPPLEMENTS "
					+ "VALUES "
					   	  + "("	
						  + "SEQ_SUP_ID.NEXTVAL"
						+ ", '"+ sdto.getSupName() + "'"
						+ ", " + sdto.getSupPrice()
						+ ", " + sdto.getPills() 
						  + ")";
		
//		
		
		try (
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "C##MH", "MH");
			Statement stmt = conn.createStatement()) {
			conn.setAutoCommit(false);
			result = stmt.executeUpdate(sql);
			if(result > 0) {
				conn.commit();
			}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public int update() {
		int result = 0;
		
		
		return result;
		
	}
	
	public List<SupplementsDto> findAll() {
		List<SupplementsDto> list = new ArrayList();
		
		String sql = """
						 SELECT
						 		SUP_NO
						 	  , SUP_NAME
						 	  , SUP_PRICE
						 	  , PILLS
						   FROM
						        SUPPLEMENTS
						  ORDER
						     BY
						        SUP_NO
					 """;
		
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "C##MH", "MH");
			Statement stmt = conn.createStatement()) {
			
			ResultSet rset = stmt.executeQuery(sql);
			while(rset.next()) {
				SupplementsDto sdto = new SupplementsDto();
				sdto.setSupNo(rset.getInt("SUP_NO"));
				sdto.setSupName(rset.getString("SUP_NAME"));
				sdto.setSupPrice(rset.getInt("SUP_PRICE"));
				sdto.setPills(rset.getInt("PILLS"));
				
//				System.out.println(sdto);
				list.add(sdto);
				
			}
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
		
	}
		
	public int delete() {
		int result = 0;
		
		return result;
		
	}
		
		
	
	

}
