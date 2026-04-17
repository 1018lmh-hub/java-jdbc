package com.kh.keeper.model.service;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.kh.keeper.common.JdbcTemplate;
import com.kh.keeper.model.dao.KeeperDao;
import com.kh.keeper.model.dto.KeeperDto;
import com.kh.keeper.model.vo.Keeper;

/*
 * 비즈니스 로직 작성(의사결정코드) -> 데이터 가동, 중복체크, 연산처리, 암호화 등등
 * 트렌젝션관리
 * 여러 DAO 조합
 * 예외 처리 및 예외 발생
 * 보안 및 권한 검사
 * 
 */
public class KeeperService {
	
	/*
	 * Service : Connection을 생성을 해서 DAO로 전달 + 
	 * 			 만약 SQL문을 수행하는데 필요한 값이 있다면 Controller로부터
	 * 			 전달받아서 Connection과 같이 넘겨줄 것 +
	 * 			 DAO에서 DB 작업이 끝나면 Service 단에서 겨로가에 따른
	 * 			 트랜잭션 처리도 진행
	 * 			 => DAO에는 순수하게 SQL문을 처리하는 부분만 남겨놓을 것
	 */
	
	public int insertKeeper(KeeperDto kd) {
		// DAO 호출 후 겨로가값 Controller로 반환
		Connection conn = JdbcTemplate.getConnection();
		
		int result = new KeeperDao().insertKeeper(conn, kd);
		
		if(result > 0) {
			JdbcTemplate.commit(conn);
		}
		
		JdbcTemplate.close(conn);
		
		return result;
	}
	/*
	 * PreparedStatement가 Statement보다 좋음
	 * 
	 * 1. 구문분석 및 컴파일 최적화
	 * 
	 * Statement 는 매번 SQL문을 파싱하고 실행하지만
	 * PreparedStatement 는 SQL쿼리를 최초 1회만 파싱하고 실행계획을 캐싱(메모리에 올림)
	 * 재사용적인 측면에서 훨씬 효율적
	 * 
	 * 2. DB서버에 대한 트래픽 감소
	 * 
	 * 쿼리자체는 한번만 전송하고 이후에는 바인딩할 값만 전송하기 때문에
	 * 동일쿼리를 반복 실행할 때, 높은 트래픽이 몰리는 애플리케이션일 때 더욱 효율적인
	 * DB작업 -> 계획 세울 때 리소스를 많이 잡아먹음
	 * 
	 * 3. 
	 * SELECT 
	 * 		  EMAIL
	 *   FROM
	 *        MEMBER
	 *  WHERE
	 *        MEMBER_ID = '" + m.getMemberId() + "'
	 *    AND
	 *        MEMBER_PWD = '" + m.getMemberPwd() + "'
	 *        
	 *        '' OR '1' = '1'
	 *        SQL 인젝션 공격
	 *        
	 * 사용자 입력값 == '' OR '1' = '1'
	 * Statement는 이걸 막을 수 없음
	 * PreparedStatement 는 SQL인젝션 방지가 됨 => 보안적인 측면에서도 좋음
	 *        
	 */
	public List<Keeper> selectKeeperList() {
		
		//1. 커넥션 객체 받아오기
		Connection conn = JdbcTemplate.getConnection();
		
		// 2. 적절한 DAO단의 메서드 호출하기
		List<Keeper> keepers = new KeeperDao().selectKeeperList(conn);
		
		//3. 할 일이 모두 끝난 Connection 자원 반납
		JdbcTemplate.close(conn);
		
		//4. 결과값 반환
		return keepers;
	}
	
	public int updateKeeper(Map<String, String> keeper){
		Connection conn = JdbcTemplate.getConnection();
		
		int result = new KeeperDao().updateKeeper(conn, keeper);
		
		//1. 변수명 메소드명 클래스명 똑바로 쓰기
		//2. 들여쓰기 잘하기
		//3. 코드쓸 때 이 코드가 뭔 코든 지 알기
		//4. 코드는 몰라도 뭘 해야할 지는 생각하기(그래도 알면 좋지)
		// 아 3 4 가 상충되는 게 아니라 하나를 써도 제대로 알아야한다는 거군
		//5. 코드 많이 쳐보기
		//5_1 -> 타자가 기본적으로 쳐져야 수업을 따라갈 수 있음
		//5_2 -> 직접 코드를 쳐봐야 어떻게 도는 지 이해가 감
		if(result > 0) {
			JdbcTemplate.commit(conn);
			
		}
		JdbcTemplate.close(conn);
		
		return result;
	}
	public int deleteKeeper(String keeperId) {
		Connection conn = JdbcTemplate.getConnection();
		
		int result = new KeeperDao().deleteKeeper(conn, keeperId);
		
		if(result > 0) {
			JdbcTemplate.commit(conn);
		}
		JdbcTemplate.close(conn);
		
		return result;
	}

}
