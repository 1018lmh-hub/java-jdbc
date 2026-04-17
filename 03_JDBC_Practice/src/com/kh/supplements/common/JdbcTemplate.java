package com.kh.supplements.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcTemplate {

	public static void registDriver() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {

		Connection conn;
		try {
			// 하드코딩
			Properties prop = new Properties();
			prop.load(new FileInputStream("resources/connection.properties"));

			conn = DriverManager.getConnection(prop.getProperty("URL"), prop.getProperty("USERNAME"),
					prop.getProperty("PASSWORD"));
			conn.setAutoCommit(false);
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;

	}


	public static void commit(Connection conn) {
		try {
			if (conn != null) {
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void close(Connection conn) {
		try {
			if (null != conn) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
