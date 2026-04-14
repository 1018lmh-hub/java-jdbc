package com.kh.start.run;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectMemberRun {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;

		String sql = """
						SELECT
						       MEM_NO
						     , MEM_NAME
						     , MEM_ID
						     , MEM_PWD
						     , MEM_ADDRESS
						     , ACCOUNT_NUM
						     , BANK_NAME
						  FROM
						       MEMBER
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
				String memName = rset.getString("MEM_NAME");
				String memId = rset.getString("MEM_ID");
				String memPwd = rset.getString("MEM_PWD");
				String memAddress = rset.getString("MEM_ADDRESS");
				long accountNum = rset.getLong("ACCOUNT_NUM"); 
				String bankName = rset.getString("BANK_NAME");
				
				System.out.println("번호 : " + memNo
						   + ", 회원 이름 : " + memName 
						   + ", 회원 아이디 : " + memId
						   + ", 회원 비밀번호 : " + memPwd
						   + ", 회원 주소 : " + memAddress
						   + ", 계좌번호 : " + accountNum
						   + ", 은행이름 : " + bankName);
				
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
