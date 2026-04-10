package com.kh.start.run;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectSaveRun {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = """
						SELECT
				       		   MEM_NO
				     		 , SUP_NO
				     		 , SAVE_DATE
				  		  FROM
				       		   SAVE
						 ORDER
				   			BY
				       		   MEM_NO
					""";		
		
		
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE",
					"C##MH",
					"MH");
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			
			while(rset.next()) {
				int memNo = rset.getInt("MEM_NO");
				int supNo = rset.getInt("SUP_NO");
				String saveDate = rset.getString("SAVE_DATE");
				
				System.out.println("회원번호 : " + memNo
						   + ", 영양제 번호 : " + supNo 
						   + ", 저장일자 : " + saveDate);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rset != null && !rset.isClosed()) {
				rset.close();
				}
				if(stmt != null && stmt.isClosed()) {
				stmt.close();
				}
				if(conn !=null && conn.isClosed()) {
				conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		
		
			
		}
	
		
	}

}
