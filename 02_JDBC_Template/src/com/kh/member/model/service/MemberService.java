package com.kh.member.model.service;

import java.sql.Connection;

import static com.kh.keeper.common.JdbcTemplate.*;// <- 가지고 있는 스태틱 매서드들을 가져옴 밑에서
												  // 메서드 쓸 때 참조 안해도 됨
import com.kh.member.exception.MemberIdTooLargeException;
import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.dto.MemberDto;

public class MemberService {
	public boolean idCheck(String memberId) {
		Connection conn = getConnection();
		boolean result = new MemberDao().idCheck(conn,memberId);
		close(conn);
		return result;
	}
	public int signUp(MemberDto member) {
		
		// 
		if(member.getMemberId().length()>30) {
			throw new MemberIdTooLargeException("아이디가 너무 깁니다.");
		}
		
		//모든 검사를 다 넘어갔다고 가정
		Connection conn = getConnection();
		
		MemberDao md = new MemberDao();
		if(md.idCheck(conn, member.getMemberId())){
			throw new MemberIdTooLargeException("중복아이디입니다.");
		}
		int result = md.signUp(conn, member);
		
		if(result> 0) {
			commit(conn);
			
		}
		close(conn);
		
		return result;
		
			
		
		
	}

}
