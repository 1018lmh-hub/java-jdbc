package com.kh.animal.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template {

	// Connection 객체 생성~ 하지않고
	// SqlSession 객체를 만드는 메소드를 구현할 것
	
	public static SqlSession getSqlSession() {
		
		SqlSession sqlSession = null;
		
		//mybatis-config.xml파일에 작성한 environment요소의 내용을 읽어와서
		//해당 DB와 연결된 SqlSession객체 생성
		String config = "mybatis-config.xml";
		
		try {
			InputStream steam = Resources.getResourceAsStream(config);
			//1단계 : SqlSessionFactoryBuilder 만들기
			// 만드는 법 : 기본생성자를 호출한다.
//			new SqlSessionFactoryBuilder();
			//2단계 : SqlSessionFactory만들기
			// 만드는 법 : Builder를 참조해서 메소드를 호출한다.
			//.build(접속 내용을 담은 파일을 읽어온 입력 스트림);
//			new SqlSessionFactoryBuilder().build(steam);
			//3단계 : SqlSession 만들기
			//만드는 법 : Factory를 참조해서 메서드를 호출한다.
			//.openSession();
			sqlSession = new SqlSessionFactoryBuilder().build(steam).openSession();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sqlSession;
	}
	
	
	
}
