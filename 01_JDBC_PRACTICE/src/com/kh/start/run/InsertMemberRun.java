package com.kh.start.run;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertMemberRun {

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		int result = 0;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("MEM_NAME을 입력해주세요 > ");
		String memName = sc.nextLine();
		System.out.print("MEM_ID을 입력해주세요 > ");
		String memId = sc.nextLine();
		System.out.print("MEM_PWD을 입력해주세요 > ");
		String memPwd = sc.nextLine();
		System.out.print("MEM_ADDRESS을 입력해주세요 > ");
		String memAddress = sc.nextLine();
		System.out.print("ACCOUNT_NUM을 입력해주세요 > ");
		String accountNum = sc.nextLine();
		System.out.print("BANK_NAME을 입력해주세요 > ");
		String bankName = sc.nextLine();
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("INSERT INTO MEMBER VALUES(");
		sb.append("SEQ_MEM_ID.NEXTVAL, ");
		sb.append("'" + memName + "', ");
		sb.append("'" + memId + "', ");
		sb.append("'" + memPwd  + "', ");
		sb.append("'" + memAddress + "', ");
		sb.append(accountNum + ", ");
		sb.append("'" + bankName + "')");
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", 
												"C##MH",
												"MH");
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sb.toString());
			
			if(result > 0) {
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
				sc.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		

	}

}
