package com.kh.delivery.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template {
	
	public static SqlSession getSqlSession() {
		
		SqlSession sqlSession = null;
		
		String config = "mybatis-config.xml";
		
		try {
			InputStream steam = Resources.getResourceAsStream(config);
			
			sqlSession = new SqlSessionFactoryBuilder().build(steam).openSession();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		return sqlSession;
		
	}

}
