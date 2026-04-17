package com.kh.supplements.view;

import java.util.Scanner;

import com.kh.supplements.controller.SupplementsController;
import com.kh.supplements.model.dto.SupplementsDto;

public class SupplementsView {
	private Scanner sc = new Scanner(System.in);
	private SupplementsController supCon = new SupplementsController();

	public void mainMenu() {
		
		
		
		/*
		 * 
		 * JDBC 오늘 버젼(driver.properties 분리, 매퍼.xml분리) 으로
		 * 처리함 리소스에 담아 매퍼 xml 있고 connection properties로 driver 정보 분리해서 담아놓음
		 * CURD 구현하기(되면 조인도 고고)
		 * 이제 이걸 해야하는데
		 * 무슨 기능을 만들까
		 * 
		 * C : 만들기 영양제 목록 추가
		 * R : 읽기 영양제 전체 읽기
		 * U : 업데이트 영양제 목록 수정
		 * D : 삭제 영양제 목록 삭제
		 * 
		 * 
		 */
		while(true) {
		
			System.out.println("영양제 리스트 편집 프로그램입니다.");
			System.out.println("번호를 입력해 메뉴를 선택해주세요.");
			System.out.println("1. 영양제 추가");
			System.out.println("2. 영양제 목록 보기");
			System.out.println("3. 영양제 상세보기");
			System.out.println("4. 영양제 수정");
			System.out.println("5. 영양제 삭제");
			System.out.println("6. 프로그램 종료");
		
			String menu = sc.nextLine();
		
			switch(menu){
			case "1" : insertSupplements(); break;
			case "2" : selectSupplementsList(); break;
			case "3" : selectSupplements(); break;
			case "4" : updateSupplements(); break;
			case "5" : deleteSupplements(); break;
			case "6" : sc.close(); return;
			default : System.out.println("잘못된 입력입니다. 메뉴에 있는 숫자를 입력해주세요."); break; 
			}
		}
	}
	
	private void insertSupplements() {
		String supPrice = "0";
		String pills = "0";
		System.out.println("영양제 추가 기능입니다.");
		System.out.print("영양제 이름을 입력해주세요 > ");
		String supName = sc.nextLine();
		while(true) {
			System.out.print("영양제 가격을 입력해주세요 > ");
			supPrice = sc.nextLine();
			try {
				Integer.parseInt(supPrice);
				break;
			} catch (NumberFormatException e) {
				System.out.println("숫자를 입력해주세요.");
			}
		}
		while(true) {
			System.out.print("영양제 정 수를 입력해주세요 > ");
			pills = sc.nextLine();
			try {
				Integer.parseInt(pills); 
				break;
			} catch (NumberFormatException e) {
				System.out.println("숫자를 입력해주세요.");
			}
		}
		System.out.println(supName);
		System.out.println(supPrice);
		System.out.println(pills);
		
//		int result = supCon.insertSupplements(new SupplementsDto(supName, supPrice, pills));
//		
//		if(result > 0) {
//			System.out.println("추가에 성공하였습니다.");
//		} else {
//			System.out.println("추가에 실패하였습니다.");
//		}
		
	}
	
	private void selectSupplementsList() {
		System.out.println("영양제 전체 목록보기 입니다.");
		
	}
	
	private void selectSupplements() {
		
	}
	
	private void updateSupplements() {
		
	}
	
	private void deleteSupplements() {
		
	}
	

}
