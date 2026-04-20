package com.kh.delivery.view;

import java.util.Scanner;

import com.kh.delivery.controller.MemberController;
import com.kh.delivery.controller.OrderController;
import com.kh.delivery.controller.RestaurantController;
import com.kh.delivery.dto.DeliMemberDto;
import com.kh.delivery.exception.DuplicateMemberIdException;

public class DeliveryMenu {
	Scanner sc = new Scanner(System.in);
	MemberController mc = new MemberController();
	OrderController oc = new OrderController();
	RestaurantController rc = new RestaurantController();
	
	public void mainMenu() {
		
		String a = sc.nextLine();
		
		while(true) {
			System.out.println("--프로그램입니다.");
			System.out.println("번호를 입력해 메뉴를 골라주세요.");
			System.out.println("0. 프로그램 종료");
			System.out.println("1. 전체 가게 목록");
			System.out.println("2. 카테고리 별 검색");
			System.out.println("3. 가게 상세(메뉴 보기)");
			if(a != null) {
			System.out.println("4. 회원가입"); 
			System.out.println("5. 로그인");
			} else {
			System.out.println("4. 주문하기");
			System.out.println("5. 내 주문내역");
			System.out.println("6. 주문 취소");
			System.out.println("7. 로그아웃");
			}
			String menu = sc.nextLine();
			
			

			if(a != null) {
				switch(menu) {
				case "0" : sc.close(); System.out.println("프로그램을 종료합니다."); return;  
				case "1" : selectAll(); break;
				case "2" : findByCategory(); break;
				case "3" : findByRestName();break;
				case "4" : signUp(); break;
				case "5" : login(); break;
				default : System.out.println("잘못된 입력입니다."); break;
				}
			} else {
				switch(menuNo) {
				case "0" : sc.close(); System.out.println("프로그램을 종료합니다."); return;  
				case "1" : selectAll(); break;
				case "2" : findByCategory(); break;
				case "3" : findByRestName();break;
				case "4" : orderMenu();break;
				case "5" : myOrderList();break;
				case "6" : cancelMyOrder(); break;
				case "7" : logout(); break;	
				default : System.out.println("잘못된 입력입니다."); break;
				}
			}
			
		}		

	}
		
		
	
	
	private void selectAll() {
		
	}
	private void findByCategory() {
		
	}
	private void findByRestName() {
		
	}
	private void signUp() {
		String memberId;
		System.out.println("회원가입 서비스입니다.");
		while(true) {
		System.out.println("아이디를 입력해주세요.");
		memberId =sc.nextLine();
		if(!mc.idcheck(memberId)) {
			break;
		}
		System.out.println("이미 존재하는 아이디입니다ㅏㅏㅏ...");
		}
		
		System.out.println("비밀번호를 입력해주세요.");
		String memberPw =sc.nextLine();
		System.out.println("성함을 입력해주세요.");
		String memberName =sc.nextLine();
		System.out.println("주소지를 입력해주세요.");
		String adress =sc.nextLine();
		try {
		int result = mc.signUp(new DeliMemberDto (memberId, memberPw, memberName, adress));
		if (result >0) {
			System.out.println("회원가입 성공!");
		} else {
			System.out.println("회원가입 실패..ㅠ"); 
		}
		} catch(DuplicateMemberIdException e) {
			System.out.println("이미 존재하는 아이디입니다.");
			
		}
	}
	private void login() {
		System.out.println("로그인 서비스입니다.");
		
	}
	private void orderMenu() {
		
	}
	private void myOrderList() {
		
	}
	private void cancelMyOrder() {
		
	}
	private void logout() {
		
	}

}
