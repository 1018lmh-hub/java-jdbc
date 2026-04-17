package com.kh.animal.run;

import com.kh.animal.view.AnimalView;

public class AnimalRun {

	/*
	 * SQL 문 따로 분리
	 * 
	 * 1. SQL 수정이 컴파일 없이 가능함
	 *    코드가 아니라 XML만 수정하는거라서 운영중에서 SQL 튜닝이 쉽다.
	 * 2. 같은 SQL문의 재사용이 가능 여러 메서드에서 비슷한 SQL을 공유할 수 있음
	 * 3. DBA(DB담당자) 랑 분업이 쉬워짐. DBA가 자바를 몰라도 XML만 보고 고칠 수 있음 
	 * 
	 * 
	 * JDBC 프레임 워크
	 * JPA
	 * MyBatis
	 * 
	 * JDBC 자바이클립스 MyBatis 각각의 버전을
	 * 잘 맞춰야 함 안맞으면 문제가 생길 수도
	 * 
	 */
	
	public static void main(String[] args) {
		new AnimalView().mainMenu();



	}

}
