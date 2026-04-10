package com.kh.start.run;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertSaveRun {

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		int result = 0;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("MEM_NO을 입력해주세요 > ");
		int memNo = sc.nextInt();
		sc.nextLine();
		System.out.print("SUP_NO을 입력해주세요 > ");
		int supNo = sc.nextInt();
		sc.nextLine();
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("INSERT INTO SAVE VALUES(");
		sb.append(memNo + ", ");
		sb.append(supNo + ", ");
		sb.append("SYSDATE)");
		
		
		
		
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
