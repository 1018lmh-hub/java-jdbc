package com.kh.member.view;

import java.util.List;
import java.util.Scanner;

import com.kh.member.BoardDto;
import com.kh.member.controller.MemberController;
import com.kh.member.exception.DuplicateMemberIdException;
import com.kh.member.exception.MemberIdTooLargeException;
import com.kh.member.model.dto.LoginResponse;
import com.kh.member.model.dto.MemberDto;

public class MemberView {

	private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();
	private LoginResponse lr = null;
	/*
	 * 오늘의 실습 겸 숙제쓰
	 * 
	 * 나만의 테이블 삼종세트ㅡㅡㅡㅡㅡㅡ
	 * 
	 * JDBC 오늘 버젼(driver.properties 분리, 매퍼.xml분리) 으로
	 * CURD 구현하기(되면 조인도 고고)
	 * 
	 * 
	 */
	
	public void mainMenu() {
		while(true) {
			System.out.println();
			System.out.println("회원서비스에 오신 것을 환영합니다~");
			if(lr != null) {
				System.out.println("1. 로그아웃"); 
				System.out.println("2. 게시판 이동");
			} else {
				System.out.println("1. 회원가입");
				System.out.println("2. 로그인");
			}
			System.out.println("9. 프로그램 종료");
			System.out.println("원하시는 메뉴를 선택해주세요");
			String menu = sc.nextLine();
			if(lr != null) {
				switch(menu) {
				case "1" : logout(); break;
				case "2" : boardMenu(); break;
				case "9" : return;
				}
				
			} else {
				switch(menu) {
				case "1" : signUp(); break;
				case "2" : login(); break;
				case "9" : return;
				}
			}
			
		}
	}
	
	private void logout() {
		lr = null;
		System.out.println("로그아웃 성공!");
	}
	
	private void boardMenu() {
		while(true) {
			System.out.println("게시판 서비스입니다.");
			System.out.println("1. 게시글 작성");
			System.out.println("2. 게시글 전체 조회");
			System.out.println("3. 게시글 상세 조회");
			System.out.println("4. 회원서비스로 돌아가기");
			
			String menu = sc.nextLine();
			
			switch(menu) {
			case "1" : insertBoard(); break;
			case "2" : selectBoardList(); break;
			case "3" : selectBoard(); break;
			case "4" : return;
			}
		}
	}
	
	private void insertBoard() {
		// 먼저 글을 작성할 수 있는 권한이 있는 지 체크
		int result = mc.selectInsertCount(lr.getMemberId());
		
		if(5 > result) {
			System.out.println("게스길 작성 권한이 없습니다.");
			return;
		} 
		
		System.out.println("게시글 작성 서비스데스");
		System.out.print("제목 입력 >");
		String title = sc.nextLine();
		System.out.print("게시글 내용 입력 >");
		String content = sc.nextLine();
		
		int insertResult = mc.insertBoard(new BoardDto(title,content,lr.getMemberId()));
		
		if(insertResult > 0) {
			System.out.println("게시글 작성 성공!");
		} else {
			System.out.println("게시글 작성 실패!");
		}
	}
	
	private void selectBoardList() {
		System.out.println("게시글 전체 조회 서비스입니다.");
		List<BoardDto> boards = mc.selectBoardList();
		
		if(boards.isEmpty()) {
			System.out.println("게시글이 아직 존재하지 않습니다.");  
		} else {
			System.out.println("==============================="); 
			for(BoardDto board : boards) {
				System.out.println("글 번호 : " + board.getBoardNo()
								  +"| 제목 : " + board.getBoardTitle()
								  +"| 작성자 : " + board.getBoardWriter()); 
			}
			System.out.println("===============================");
		}
	}
	
	private void selectBoard() {
		System.out.println("게시글 상세보기 서비스입니다.");
		selectBoardList();
		
		System.out.print("상세보기를 원하시는 게시글 번호를 입력해주세요 > ");
		
		String boardNo = sc.nextLine();
		
		BoardDto board = mc.selectBoard(boardNo);
		
		if(board != null) {
			System.out.println(board.getBoardNo() + "번 게시글");
			System.out.println("============================");
		
			System.out.println("제목 : " + board.getBoardTitle());
			System.out.println("----------------------------");
			System.out.println("내용 : " + board.getBoardContent());
			System.out.println("----------------------------");
			System.out.println("작성자 : " + board.getBoardWriter());
			System.out.println("============================");
		} else {
			System.out.println("그런건 없어용~");
		}
		
	}
	
	private void signUp() {
 		//사용자에게 무슨 값을 받을까~
		// 아이디, 비밀번호, 이름
		
		String memberId;
		System.out.println("회원가입 서비스입니다.");
		while(true) {
			System.out.print("사용하실 아이디를 입력해주세요 > ");
			memberId = sc.nextLine();
			
			if(!mc.idCheck(memberId)) {
				break;
			}
			System.out.println("이미 존재하는 아이디 입니다.");
		}
		
		System.out.print("사용하실 비밀번호를 입력해주세요 > ");
		String memberPwd = sc.nextLine();
		
		System.out.print("이름을 입력해주세요 > ");
		String memberName = sc.nextLine();
		try {
		int result = mc.signUp(new MemberDto(memberId,memberPwd,memberName));
		
		if(result > 0) {
			System.out.println("회원가입 성공!");
		} else {
			System.out.println("회원가입 실패~");
		}
		
		} catch(MemberIdTooLargeException e) {
			System.out.println("아이디가 너무 깁니다 30글자 이내로 해주세요");	
		} catch(DuplicateMemberIdException e) {
			System.out.println("이미 존재하는 아이디입니다. 다른 아이디로 시도하세요.");
		}
	}
	
	private void login() {
		// 사용자에게 아이디 / 비밀번호를 입력받고
		// JDBC_MEMBER 테이블에서 조건을 통해 조회하는 메서드
		
		System.out.print("아이디를 입력해주세요 > ");
		String memberId = sc.nextLine();
		System.out.print("비밀번호를 입력해주세요 > ");
		String memberPwd = sc.nextLine();
		
		MemberDto loginMember = new MemberDto();
		loginMember.setMemberId(memberId);
		loginMember.setMemberPwd(memberPwd);
		
		LoginResponse lr = mc.login(loginMember);
		
		if(lr != null) {
			System.out.println("로그인에 성공~");
			this.lr = lr;
		} else {
			System.out.println("로그링 실패");
		}
	}
}
