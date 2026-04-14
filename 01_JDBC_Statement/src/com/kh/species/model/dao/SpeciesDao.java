package com.kh.species.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kh.species.model.dto.SpeciesDto;

public class SpeciesDao {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}// 얘는 클래스 객체 만들어질 때 한번 밑에 2개는 호출될 때마다
	
	/*
	public SpeciesDao() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	{
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	*/
	
	/*
	 * 오늘의 주인공 JDBC 
	 * 
	 * JDBC용 인터페이스
	 * 
	 * -Connection : 데이터베이스와의 세션(연결)을 나타내는 인터페이스
	 * -> 데이터베이스와의 통신 채널을 연결
	 * -> SQL문을 실행을 위한 Statement 객체 생성
	 * -> 트렌젝션관리
	 * 
	 * 조심해야할 점)
	 * 메모리 누수를 방지하기 위해 항상 close()
	 * 트랜잭션을 직접 관리한다면 DML 수행 이후 반드시 commit / rollback
	 * 
	 * -Statement : SQL 문을 실행(응답이 옴 resultSet이나 행수(정수))하고 결과를 받아오기 위한 인터페이스
	 * 1. Statement: 정적 SQL문(완성된 SQL문) 실행
	 * 2.  PreparedStatement : 파라미터화된 SQL문(미완성 SQL문) 실행
	 * 3. CallableStatement : 저장 프로시저 호출
	 * 
	 * - ResultSet : SELECT문 실행결과를 담는 테이블 형태의 데이터 셋
	 * -> 커서(cursor)라는 개념을 이용해서 데이터에 접근
	 * -> 다양한 데이터타입 반환 메소드를 제공
	 * 
	 * JDBC 처리 순서
	 * 
	 * 1) JDBC Driver 등록 : DBMS 제조사에서 제공하는 클래스를 리플렉션을 통해 등록
	 * 2) Connection 객체 생성 : 접속정보를 전달하면서 Connection 객체 반환
	 * 3) Statement 객체 생성 : Connection 객체를 이용해서 생성
	 * 4) SQL문을 전달하며 실행 : 
	 * > SELECT -> excuteQuery() 호출
	 * > DML	-> excuteUpdate() 호출
	 * 5) 결과받기
	 * > SELECT -> ResultSet(조회된 데이터들이 테이블 모양으로 반환) 객체로 받기
	 * > DML	-> int(처리된 행 수) 로 받기
	 * 6) 
	 * > SELECT -> ResultSet에 담겨있는 데이터를 하나하나 뽑아서 가공
	 * > DML	-> 트랜잭션을 수동으로 처리한다면 commit / rollback
	 * 7) 자원반납 -> close() -> 생성의 역순
	 * 8) 결과값 반환
	 * > SELECT -> 6에서 만든거
	 * > DML	-> 처리된 행 수
	 * 
	 * 
	 * 
	 * 
	 */
	public int save(SpeciesDto sd) {
		
		// DEV가 뭐더라OPS?
		// 0) 필요한 변수 선언 및 null 값으로 초기화
		Connection conn = null;// DB 서버와의 연결정보를 담는 객체
		Statement stmt = null;// SQL문 실행 후 결과를 받는 객체
		int result = 0;// DML 수행 후 결과를 받기 위한 변수
		// SQL문 (정적인 형태)
		/*
		 * INSERT
		 *   INTO
		 *        SPECIES
		 * VALUES
		 *        (
		 *        'S' || SEQ_SPECIES 
		 *        '사용자가 입력한 값'
		 *        '사용자가 입력한 값'
		 *        )
		 * 
		 * 
		 */
		String sql = 
				     "INSERT " 
				     + "INTO "
				            + "SPECIES "
				   + "VALUES " 
				            + "("
				            + "'S' || SEQ_SPECIES.NEXTVAL"
				            + ", '" + sd.getSpeciesName() + "'"
				            + ", '"+ sd.getSpeciesClass()  + "'"
				            + ")";
//		System.out.println(sql);
		//SQL문에 문법적인 문제가 존재한다
		//SLQSyntaxErrorException이 발생함
		
		//1) JDBC Driver 등록
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 1. 패키지 경로 / 클래스 식별자에서 오타가 날 경우
			// 2. 프로젝트에 라이브러리를 추가하지 않아서 진짜로 클래스가 없는 경우
			// ->ClassNotFoundException이 발생
			
			//2) Connection 객체 생성(URL, USERNAME, PASSWORD)
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE"
									  , "C##MH"
									  , "MH");
			//느낌만(비유) new Connection(URL, USERNAME, PASSWORD)
			//1. URL을 잘못 적었을 수 있음
			//2. 서버가 안열려(켜져)있을 수 있음
			//3. 계정명을 잘못적었을 수 있음
			//4. 비밀번호를 잘못적었을 수 있음
			//5. 접속권한을 부여받지 못했을 경우
			//6. 비밀번호 갱신은 안했을 경우
			//SQLException이 발생
			
			//AutoCommit끄기
			conn.setAutoCommit(false);
			
			//3) Statement 객체 생성
			stmt = conn.createStatement();
			// 4,5) SQL문 실행 요청 및 응답 반환
			result = stmt.executeUpdate(sql);
			//INSERT시에 값에 문제가 있을 수 있음
			// 자료형이 맞지 않음
			// 계약조건에 위배
			//데이터 크기가 컬럼의 크기보다 큼
			//SQLException이 발생
			//원래 Service 단에서 처리해야함
			
			//6) 트렌젝션 처리
			//
			if(result > 0) {
				conn.commit();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//DML 수행 결과 반환
		return result;
	
	}
	
	public List<SpeciesDto> findAll() {
		//0) 필요한 변수 선언
		// Connection, Statement
		Connection conn = null;// 연결된 DB정보
		Statement stmt = null;// SQL문 실행 + 응답 반환
		ResultSet rset = null;// SELECT 수행 후 조회 결과가 담기는 객체
		List<SpeciesDto> list = new ArrayList();
		
		
		
		
		
		String sql = """
						SELECT
						       SPECIES_ID
						     , SPECIES_NAME
						     , SPECIES_CLASS
						  FROM
						       SPECIES
						 ORDER
						    BY
						       SPECIES_ID DESC  
					 """;
		//1) JDBC Driver 등록
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2) Connection 객체 생성
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "C##MH", "MH");
			
			//3) Statement 객체 생성
			stmt = conn.createStatement();
			
			//4, 5) SQL(SELECT)문 실행 후 응답 ResultSet에 대입
			rset = stmt.executeQuery(sql);
			
			//6) Mapping 
			// 서로 다른 형태의 데이터 모델 간의 연결을 정의하는 과정
			// 관계형 데이터베이스 == 테이블 형태
			
			// 자바 == 객체 형태
			
			// 현재 조회 결과는 ResultSet 에 담겨 있음
			// => 한 행씩 접근해서 데이터를 뽑아서 => VO/DTO 객체의 필드에 담기
			// rset.next()
			// 커서를 한 줄 아래로 옮긴 뒤 존재한다 true / 없다 false 를 반환
			// while 과 if
			while(rset.next()) {
				
				// 현재 rset 의 커서가 가리키고 있는 행의 데이터를
				// 하나하나씩 뽑아서 SpeciesDto 객체의 필드에 대입
				SpeciesDto sd = new SpeciesDto(); // 원래 VO로 하는데 시간관계상 DTO로 처리
				
				// ResultSet 객체로부터 -> 테이블이 아니라 ResultSet에서 뽑는거임 밑의 컬럼명도 ResultSet거임
				// 어떤 컬럼의 값을 뽑을건지 메소드를 호출하면서 컬럼명을 명시
				//rset.getInt(컬럼명) : 컬럼값이 정수여서 int형으로 매핑할 때
				//rset.getString(컬럼명) : 문자열형값을 String으로 매핑할 때
				//rset.getDate(컬렴명) : 날짜형 값을 java.sql.Date로 매핑
				// 컬럼명 : 대소문자를 가리지 않음
				// 컬럼명말고 컬럼의 순번 / 별칭으로 가능함
				// 권장사항 : 컬럼명으로 작성하고 대문자로 작성
				
				
				
				sd.setSpeciesId(rset.getString("SPECIES_ID"));
				sd.setSpeciesName(rset.getString("SPECIES_NAME"));
				sd.setSpeciesClass(rset.getString("SPECIES_CLASS"));
				
				System.out.println(sd);
				//컬럼명이 오타났을 때 SQLException 발생
				// 테이블에 직접접근해서 컬럼값을 뽑는 것이 아니고
				//ResultSet에서 조회된 결과값을 뽑아내는 것
				
				// 한 행에 모든 컬럼값을
				// 각각의 필드에 담아 DTO 객체로 옮겨담으면 끝!
				
				// 몇개? => 몰라 조회된 개수만큼 싹 다 돌려보내야함
				// 배열 특) 크기 정해야됨
				// 조회 결과가 몇 행 일지 특정짓기가 어려움
				// 여러 주소값을 담아줄 저장소 ==> list set map 중에 List
				
				list.add(sd);
		
			}
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {try {
			// 7) 다 쓴 JDBC 용 객체 자원반납(생성의 역순으로)
			rset.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				   
		}
		//8) 매핑된 객체들 반환 12:44
		// 조회결과물을 
		//list 반환
		
		
		return list;
				
	}
	
	public int update(SpeciesDto sd) {
		//UPDATE -> updatedRows -> int
		int result = 0;
		
		String sql = "UPDATE "
				          + "SPECIES "
				      + "SET "
				          + "SPECIES_NAME = '" + sd.getSpeciesName() + "'"
				        + ", SPECIES_CLASS = '" + sd.getSpeciesClass() + "'"
				   + "WHERE "
				          + "SPECIES_ID = '" + sd.getSpeciesId() + "'";
		
				// try with resource 구문 자동 반납 
				try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "C##MH", "MH");
					Statement stmt = conn.createStatement()){
					result = stmt.executeUpdate(sql);	
				 	
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return result;
		
	}
	
	public int delete(String speciesId) {
		int result = 0;
		String sql = "DELETE "
					 + "FROM "
				            + "SPECIES "
					 + "WHERE "
				            + "SPECIES_ID = '" + speciesId + "'";
		
		try(Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "C##MH", "MH");
			Statement stmt = conn.createStatement()){
			result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return result;
	}
	
	public SpeciesDto findById(String speciesId) {
		SpeciesDto sd = null;
		String sql = """
						SELECT
						       SPECIES_ID
						     , SPECIES_NAME
						     , SPECIES_CLASS
						  FROM
						       SPECIES
						 WHERE
						        SPECIES_ID = 
					 """;
		sql += "'" + speciesId + "'";
		try(Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "C##MH", "MH");
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(sql)){
		
			//6) 매핑
			// 조회결과가 담긴 ResultSet객체에서
			// 조회결과가 존재하면 DTO 객체의 필드에 옮겨담기
			// ID 가지고 검색 => UNIQUE => 한 행
			if(rset.next()) {
				sd = new SpeciesDto(rset.getString("SPECIES_ID"),rset.getString("SPECIES_NAME"),rset.getString("SPECIES_CLASS"));
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sd;
		
	}
	
	public List<SpeciesDto> findByKeyword(String keyword) {
		//돌아갈 때
		List<SpeciesDto> list = new ArrayList();
		
		String sql = "SELECT "
						  + "SPECIES_ID "
						+ ", SPECIES_NAME "
						+ ", SPECIES_CLASS "
				  + "FROM "
						 + "SPECIES "
				  + "WHERE "
						 + "SPECIES_NAME LIKE '%" + keyword + "%' "
				  + "ORDER "
					 + "BY "
				         + "SPECIES_ID DESC";
				
		try(Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "C##MH", "MH");
				Statement stmt = conn.createStatement();
				ResultSet rset = stmt.executeQuery(sql)){
	
			while(rset.next()) {
				
				list.add(
						new SpeciesDto(rset.getString("SPECIES_ID"), rset.getString("SPECIES_NAME"), rset.getString("SPECIES_CLASS"))
						
						);
			} 
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;
	
	}
	
	
	
}
