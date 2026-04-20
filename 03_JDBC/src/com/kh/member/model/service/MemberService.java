package com.kh.member.model.service;

// <- 가지고 있는 스태틱 매서드들을 가져옴 밑에서
import static com.kh.keeper.common.JdbcTemplate.close;
import static com.kh.keeper.common.JdbcTemplate.commit;
import static com.kh.keeper.common.JdbcTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.kh.member.BoardDto;
import com.kh.member.exception.DuplicateMemberIdException;
// 메서드 쓸 때 참조 안해도 됨
import com.kh.member.exception.MemberIdTooLargeException;
import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.dto.LoginResponse;
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
			throw new DuplicateMemberIdException("중복아이디입니다.");
		}
		int result = md.signUp(conn, member);
		
		if(result> 0) {
			commit(conn);
			
		}
		close(conn);
		
		return result;

	}
	
	public LoginResponse login(MemberDto member) {
		
		Connection conn = getConnection();
		
		//1. INSERT를 먼저하고 SELECT를 한다.
		//2. SELECT를 먼저하고 INSERT를 한다.
		// INSERT를 먼저했을 때 실패하면 ROLLBACK 을 해줘야함 SELECT는 실패해도 ROLLBACK 필요없음
		
		
		/*
		int result = new MemberDao().insertCheck(conn, member);
		
		LoginResponse lr = new MemberDao().login(conn, member);
		if(lr != null && result >0) {
			commit(conn);
		}
		rollback();
		*/
		
		
		LoginResponse lr = new MemberDao().login(conn, member);
		//로그인 성공 시 lr => memberId, memberName필드에 값이 있는 객체의 주소값
		//로그인 실패 시 lr => null
	
		if(lr != null) {
			int result = new MemberDao().loginCheck(conn, member.getMemberId());
//			System.out.println(result);
			if(result > 0) {
				commit(conn);
			}	
		}
		close(conn);
		return lr;
	}
	
	public int selectInsertCount(String memberId) {
		Connection conn = getConnection();
		
		int result = new MemberDao().selectInsertCount(conn, memberId);
		
		close(conn);
		
		return result;
	}
	
	public int insertBoard(BoardDto board) {
		Connection conn = getConnection();
		
		int result = new MemberDao().insertBoard(conn, board);
		
		if(result > 0) {
			commit(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	public List<BoardDto> selectBoardList(){
		Connection conn = getConnection();
		
		List<BoardDto> boards = new MemberDao().selectBoardList(conn);
		
		close(conn);
		
		return boards;
		
	}
	
	public BoardDto selectBoard(String boardNo) {
		Connection conn = getConnection();
		BoardDto board = new MemberDao().selectBoard(conn, Integer.parseInt(boardNo));
		
		close(conn);
		return board;
	}

	
}
